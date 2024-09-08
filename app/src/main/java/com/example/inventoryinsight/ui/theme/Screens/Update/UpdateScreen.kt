package com.example.inventoryinsight.ui.theme.Screens.Update

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun UpdateScreen(navController: NavController) {
    var isUpdating by remember { mutableStateOf(false) }
    var appVersion by remember { mutableStateOf("1.0.0") } // Replace with dynamic version fetching if needed
    var latestVersion by remember { mutableStateOf("1.1.0") } // Replace with server call to get the latest version

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("App Version: $appVersion", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(8.dp))

        Text("Latest Version: $latestVersion", fontSize = 18.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                isUpdating = true
                // Implement update check and download logic here
            },
            modifier = Modifier.fillMaxWidth(),
            enabled = !isUpdating // Disable button while updating
        ) {
            Text(if (isUpdating) "Updating..." else "Check for Updates")
        }

        if (isUpdating) {
            Spacer(modifier = Modifier.height(16.dp))
            CircularProgressIndicator() // Shows a loading spinner while updating
        }
    }
}
@Preview
@Composable
fun Preview(){
    UpdateScreen(rememberNavController())
}