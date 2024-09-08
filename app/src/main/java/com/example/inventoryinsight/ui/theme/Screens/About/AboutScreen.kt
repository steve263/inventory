package com.example.inventoryinsight.ui.theme.Screens.About

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryinsight.R
import com.example.inventoryinsight.ui.theme.Screens.Home.HomeScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    Box() {
        Image(
            painter = painterResource(id = R.drawable.depot),
            contentDescription = "dashboard background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize( )

        )
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("About", fontSize = 20.sp) },
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Inventory Insight",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Version 1.0",
                fontSize = 18.sp,
                color = Color.Gray
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Inventory Insight is a comprehensive warehouse management application " +
                        "designed to streamline your inventory management process. " +
                        "With features like real-time inventory tracking, order management, and shipment tracking, " +
                        "Inventory Insight helps you manage your warehouse efficiently.We have been approved by KEBS due to our clean work" +
                        "We are located at Mombasa county near Bamburi Cement industry"
            )
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "For support or inquiries, contact us at:",
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            ClickableText(
                text = AnnotatedString("support@InventoryInsight.com"),
                onClick = {
                    // Handle email click (e.g., open email client)
                },
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = MaterialTheme.colorScheme.primary
                )
            )
        }
    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview(){
    AboutScreen(rememberNavController())

}
