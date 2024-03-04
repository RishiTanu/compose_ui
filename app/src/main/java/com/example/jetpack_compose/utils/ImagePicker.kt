package com.example.jetpack_compose.utils

import android.Manifest
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.Button
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CameraAlt
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.FileProvider
import com.example.democompose.R
import java.io.File

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ImagePicker(
    modifier: Modifier = Modifier,
    onImagePicked: (Uri?) -> Unit
) {
    // State to hold the image URI
    var imageUri by remember {
        mutableStateOf<Uri?>(null)
    }

    val scaffoldState = rememberBottomSheetScaffoldState(bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed))
    var showBottomSheet by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // Observing the showBottomSheet state to open or close the bottom sheet
    LaunchedEffect(showBottomSheet) {
        if (showBottomSheet) {
            scaffoldState.bottomSheetState.expand()
        } else {
            scaffoldState.bottomSheetState.collapse()
        }
    }

    // Image picker launcher
    val launcher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.GetContent()) { uri: Uri? ->
            imageUri = uri
            onImagePicked(uri)
        }

    // Camera capture launcher
    val cameraLauncher =
        rememberLauncherForActivityResult(contract = ActivityResultContracts.TakePicture()) { success: Boolean ->
            if (success) {
                onImagePicked(imageUri)
            }
        }


    fun takePicture() {
        // Get URI for the temporary file
        imageUri = FileProvider.getUriForFile(
            context,
            "com.example.democompose.provider",
            File.createTempFile("temp_image", ".jpg", context.cacheDir)
        )
        cameraLauncher.launch(imageUri)
    }

    BottomSheetScaffold(
        scaffoldState = scaffoldState,
        sheetContent = {
            BottomSheetContent(onOptionSelected = { picker->
                if(picker == "gallery"){
                    launcher
                }else{
                    takePicture()
                }
                showBottomSheet = false
            })
        }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) { // Use Box for overlaying content
            Image(
                painter = painterResource(id = R.drawable.placeholder), // Use painterResource for drawable
                contentDescription = "Placeholder image",
                modifier = Modifier.size(150.dp)
            )
            FloatingActionButton(onClick = {
                showBottomSheet = !showBottomSheet
            }, modifier = Modifier.size(56.dp)) { // Default FAB size, adjust as necessary
                Icon(Icons.Filled.CameraAlt, contentDescription = "Pick image")
            }
        }
    }
}

@Composable
fun BottomSheetContent(onOptionSelected: (String) -> Unit) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Choose an option", style = MaterialTheme.typography.h6)
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = {
            onOptionSelected("gallery")
        }) {
            Text("Pick from Gallery")
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = {
            onOptionSelected("camera")
        }) {
            Text("Take a Picture")
        }
    }
}