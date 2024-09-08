package com.example.inventoryinsight.ui.theme.Screens.Stock

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue

import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryinsight.R
import com.example.inventoryinsight.navigation.ROUTE_ORDER
import com.example.inventoryinsight.navigation.ROUTE_STOCKIN
import com.example.inventoryinsight.navigation.ROUTE_STOCKOUT

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StockInOutScreen(navController: NavController) {
    var selectedItem by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf(TextFieldValue("")) }
    var location by remember { mutableStateOf("") }
    var isStockIn by remember { mutableStateOf(true) } // Toggle for stock in or out

    val locations = listOf("Warehouse 1", "Warehouse 2", "Warehouse 3") // Sample locations
    val items = listOf("Item A", "Item B", "Item C", "Item D")

    Box() {
        Image(
            painter = painterResource(id = R.drawable.depot),
            contentDescription = "null",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize( )

        )
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

   // Sample items

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Stock In/Out Management", fontSize = 20.sp, fontWeight = FontWeight.Bold) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Select item
            Text("Select Item:", fontSize = 18.sp)
            DropdownMenu(
                items = items,
                selectedItem = selectedItem,
                onItemSelected = { selectedItem = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Enter quantity
            Text("Enter Quantity:", fontSize = 18.sp)
            BasicTextField(
                value = quantity,
                onValueChange = { quantity = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.small)
                    .padding(12.dp),
                keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Select location
            Text("Select Location:", fontSize = 18.sp)
            DropdownMenu(
                items = locations,
                selectedItem = location,
                onItemSelected = { location = it }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Stock In/Out toggle
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { isStockIn = true
                        navController.navigate(ROUTE_STOCKIN)
                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isStockIn) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )
                ) {
                    Text("Stock In")
                }
                Button(
                    onClick = { isStockIn = false
                        navController.navigate(ROUTE_STOCKOUT)

                              },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!isStockIn) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.onSurface
                    )

                ) {
                    Text("Stock Out")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Submit Button
            Button(
                onClick = {
                    navController.navigate(ROUTE_ORDER)
                    // Logic for adding or removing stock
                    if (isStockIn) {
                        // Stock In logic
                    } else {
                        // Stock Out logic
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Submit")
            }
        }

    }
    }
}

@Composable
fun DropdownMenu(items: List<String>, selectedItem: String, onItemSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxWidth()) {
        OutlinedButton(
            onClick = { expanded = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = if (selectedItem.isNotEmpty()) selectedItem else "Select an option")
        }
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
//            items.forEach { item ->
//                DropdownMenuItem(onClick = {
//                    onItemSelected(item)
//                    expanded = false
//                }) {
//                    Text(text = item)
//                }
//            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun StockInOutScreenPreview() {
    StockInOutScreen(rememberNavController())
}
