package com.example.inventoryinsight.ui.theme.Screens.stockout

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryinsight.navigation.ROUTE_STOCK

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockOutScreen(navController: NavController) {
    var quantity by remember { mutableStateOf("") }
    var selectedLocation by remember { mutableStateOf("") }
    val locations = listOf("Warehouse A", "Warehouse B", "Warehouse C")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Stock Out", fontSize = 20.sp, fontWeight = FontWeight.Bold) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Quantity input field
            OutlinedTextField(
                value = quantity,
                onValueChange = { newquantity->quantity = newquantity },
                label = { Text("Quantity") },
                modifier = Modifier.fillMaxWidth()
            )

            // Dropdown to select storage location
            var expanded by remember { mutableStateOf(false) }
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                OutlinedTextField(
                    value = selectedLocation,
                    onValueChange = {newLocation->selectedLocation = newLocation},
                    label = { Text("Select Location") },
                    readOnly = false,
                    modifier = Modifier.fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    locations.forEach { location ->
                        DropdownMenuItem(
                            text = { Text(location) },
                            onClick = {
                                selectedLocation = location
                                expanded = false
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.navigate(ROUTE_STOCK)
            },
                colors = ButtonDefaults.buttonColors(Color.Yellow),
                modifier = Modifier
                    .wrapContentWidth()
                    .align(Alignment.CenterHorizontally)
            ) {
                Text(modifier = Modifier,
                    text ="Stock out" )

            }



            // Submit Button

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewStockOutScreen() {
    StockOutScreen(rememberNavController())
}
