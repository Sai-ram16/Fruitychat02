package com.sairam.fruitychat

import android.Manifest
import android.content.ContentResolver
import android.content.ContentValues
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sairam.fruitychat.ui.theme.FruitsAppTheme
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import kotlin.math.min

class UserProfileActivity : ComponentActivity() {

    enum class CameraPermissionStatus { NoPermission, PermissionGranted, PermissionDenied }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val cameraPermissionStatusState = mutableStateOf(CameraPermissionStatus.NoPermission)
        val photoUriState: MutableState<Uri?> = mutableStateOf(null)
        val hasPhotoState = mutableStateOf(value = false)
        val resolver = applicationContext.contentResolver

        val requestPermissionLauncher =
            registerForActivityResult(ActivityResultContracts.RequestPermission()){ isGranted: Boolean ->
                if (isGranted) {
                    cameraPermissionStatusState.value = CameraPermissionStatus.PermissionGranted
                } else {
                    cameraPermissionStatusState.value = CameraPermissionStatus.PermissionDenied
                }
            }

        val takePhotoLauncher =
            registerForActivityResult(ActivityResultContracts.TakePicture()) { isSaved ->
                hasPhotoState.value = isSaved
            }

        val takePhoto: () -> Unit = {
            hasPhotoState.value = false

            val values = ContentValues().apply {
                val title = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
                put(MediaStore.Images.Media.TITLE, "Compose Camera Example Image - $title")
                put(MediaStore.Images.Media.DISPLAY_NAME, title)
                put(MediaStore.Images.Media.MIME_TYPE, "image/jpeg")
                put(MediaStore.Images.Media.DATE_TAKEN, System.currentTimeMillis())
            }

            val uri = resolver.insert(
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                values
            )
            takePhotoLauncher.launch(uri)
            photoUriState.value = uri

        }

        // Ideally these would be cached instead of reloaded
        val getThumbnail: (Uri?) -> ImageBitmap? = { uri ->
            val targetSize = 256f
            println("URI is $uri")
            uri?.let {
                println("Opening Input Stream")
                resolver.openInputStream(it)
            }?.let {
                BitmapFactory.decodeStream(it)
            }?.let {
                val height = it.height.toFloat()
                val width = it.width.toFloat()
                val scaleFactor = min(targetSize / height, targetSize / width)
                Bitmap.createScaledBitmap(it, (scaleFactor * width).toInt() , (scaleFactor * height).toInt(), true)
            }?.let {
                val rotation = getImageRotation(resolver, uri)
                Bitmap.createBitmap(it, 0, 0, it.width, it.height, Matrix().apply { postRotate(rotation.toFloat()) }, true)
            }?.asImageBitmap()

        }

        val getFullImage: (Uri?) -> ImageBitmap? = { uri ->
            uri?.let {
                resolver.openInputStream(it)
            }?.let {
                BitmapFactory.decodeStream(it)
            }?.let {
                val rotation = getImageRotation(resolver, uri)
                Bitmap.createBitmap(it, 0, 0, it.width, it.height, Matrix().apply { postRotate(rotation.toFloat()) }, true)
            }?.asImageBitmap()

        }

        setContent {
            val cameraPermissionStatus by remember { cameraPermissionStatusState }
            val hasPhoto by remember { hasPhotoState }
            var shouldShowFullImage by remember { mutableStateOf(false) }
            val navController = rememberNavController()

            FruitsAppTheme() {
                NavHost(navController = navController, startDestination = "profile") {
                    composable("profile") {
                        UserProfileScreen(
                            cameraPermissionStatus = cameraPermissionStatus,
                            requestPermissionLauncher = requestPermissionLauncher,
                            takePhoto = takePhoto,
                            getThumbnail = getThumbnail,
                            getFullImage = getFullImage,
                            hasPhoto = hasPhoto,
                            photoUri = photoUriState.value,
                            shouldShowFullImage = shouldShowFullImage,
                            onFullImageClick = { shouldShowFullImage = it },
                            onSaveClick = { navController.navigate("home") }
                        )
                    }

                }
            }
        }
    }

    private fun composable(s: String, function: @Composable () -> Unit) {

    }

    private fun getImageRotation(resolver: ContentResolver, uri: Uri): Int {
        val cursor = resolver.query(uri, arrayOf(MediaStore.Images.Media.ORIENTATION), null,
            null, null)
        var result = 0

        cursor?.apply {
            moveToFirst()
            val index = getColumnIndex(MediaStore.Images.Media.ORIENTATION)
            result = getInt(index)
            close()
        }
        println("Rotation = $result")
        return result
    }
}

@Composable
fun UserProfileScreen(
    cameraPermissionStatus: UserProfileActivity.CameraPermissionStatus,
    requestPermissionLauncher: ActivityResultLauncher<String>,
    takePhoto: () -> Unit,
    getThumbnail: (Uri?) -> ImageBitmap?,
    getFullImage: (Uri?) -> ImageBitmap?,
    hasPhoto: Boolean,
    photoUri: Uri?,
    shouldShowFullImage: Boolean,
    onFullImageClick: (Boolean) -> Unit,
    onSaveClick: () -> Unit
) {
    var name by remember { mutableStateOf("SaiRam") }
    var email by remember { mutableStateOf("Sairam@gmail.com") }
    var location by remember { mutableStateOf("United Kingdom") }
    var isEditing by remember { mutableStateOf(false) }

    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = Color(0xFFFFA500))) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(350.dp),
                painter = painterResource(id = R.drawable.op),
                contentDescription = null
            )

            TakePhotoButton(
                cameraPermissionStatus = cameraPermissionStatus,
                requestPermissionLauncher = requestPermissionLauncher,
                takePhoto = takePhoto
            )

            if (hasPhoto) {
                val bitmap = getThumbnail(photoUri)
                if (bitmap != null) {
                    Image(
                        bitmap = bitmap,
                        contentDescription = "Thumbnail of Save Photo",
                        modifier = Modifier.clickable { onFullImageClick(true) }
                    )
                }
            }
            val context = LocalContext.current
            if (isEditing) {
                BasicTextField(
                    value = name,
                    onValueChange = { name = it },
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                BasicTextField(
                    value = email,
                    onValueChange = { email = it },
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                BasicTextField(
                    value = location,
                    onValueChange = { location = it },
                    modifier = Modifier.padding(16.dp)
                )
                Spacer(modifier = Modifier.height(15.dp))
                Button(onClick = {
                    val intent = Intent(context, MainOperation::class.java).apply {

                        val fruits="null"
                        putExtra("fruit", fruits) // Pass your data here
                    }
                    context.startActivity(intent) // Start the activity
                }) {
                    Text("Save")
                }
            } else {
                Text("Name: $name", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(15.dp))
                Text("Email: $email", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(15.dp))
                Text("Location: $location", fontSize = 20.sp)
                Spacer(modifier = Modifier.height(15.dp))
                Button(onClick = { isEditing = true }) {
                    Text("Edit")
                }
            }
        }

        if (shouldShowFullImage && hasPhoto) {
            val bitmap = getFullImage(photoUri)
            if (bitmap != null) {
                Box(modifier = Modifier
                    .fillMaxSize()
                    .clickable { onFullImageClick(false) }) {
                    Image(
                        bitmap = bitmap,
                        contentDescription = "Full image of Save Photo",
                        modifier = Modifier.align(Alignment.Center)
                    )
                    androidx.compose.material.Surface(
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(8.dp),
                        color = Color.Black.copy(alpha = 0.5f)
                    ) {
                        Text(
                            text = "Tap to close",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(8.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TakePhotoButton(
    cameraPermissionStatus: UserProfileActivity.CameraPermissionStatus,
    requestPermissionLauncher: ActivityResultLauncher<String>,
    takePhoto: () -> Unit
) {
    when (cameraPermissionStatus) {
        UserProfileActivity.CameraPermissionStatus.PermissionGranted -> {
            OutlinedButton(onClick = takePhoto) {
                Text(text = "Take Photo")
            }
        }
        UserProfileActivity.CameraPermissionStatus.NoPermission -> {
            OutlinedButton(onClick = { requestPermissionLauncher.launch(Manifest.permission.CAMERA) }) {
                Text(text = "Request Camera Permission")
            }
        }
        UserProfileActivity.CameraPermissionStatus.PermissionDenied -> {
            Text(text = "Camera permission denied.")
        }
    }
}
















