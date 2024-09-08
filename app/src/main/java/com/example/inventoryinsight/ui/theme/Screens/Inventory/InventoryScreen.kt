package com.example.inventoryinsight.ui.theme.Screens.Inventory

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.navigation.NavController
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search

import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

data class InventoryItem(
    val name: String,
    val description: String,
    val quantity: Int,
    val location: String,
    val recordLevel: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryScreen(navController: NavController) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    var filterByQuantity by remember { mutableStateOf(false) }
    var sortAscending by remember { mutableStateOf(true) }

    var inventoryList by remember {
        mutableStateOf(sampleInventory())
    }

    // Filtering logic
    val filteredList = inventoryList.filter {
        it.name.contains(searchText.text, ignoreCase = true) ||
                it.description.contains(searchText.text, ignoreCase = true) ||
                it.location.contains(searchText.text, ignoreCase = true)
    }.sortedWith(compareBy { if (sortAscending) it.name else it.name.reversed() })

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Inventory Management", fontSize = 20.sp, fontWeight = FontWeight.Bold) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Search bar
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    value = searchText,
                    onValueChange = { searchText = it },
                    modifier = Modifier
                        .fillMaxWidth(0.85f)
                        .padding(end = 8.dp)
                        .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.small)
                        .padding(12.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Search),
                    keyboardActions = KeyboardActions(onSearch = {
                        // Trigger search logic
                    }),
                    singleLine = true
                )
                IconButton(onClick = { /* Trigger search */ }) {
                    Icon(Icons.Filled.Search, contentDescription = "Search")
                }
            }

            // Filter and Sort Buttons
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Filter by Quantity button
                IconButton(onClick = { filterByQuantity = !filterByQuantity }) {
                    Icon(Icons.Filled.Search, contentDescription = "Filter by Quantity")
                }
                // Sort by Name button
                IconButton(onClick = { sortAscending = !sortAscending }) {
                    Icon(Icons.Filled.Search, contentDescription = "Sort by Name")
                }
            }

            // Inventory list
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(vertical = 8.dp)
            ) {
                items(filteredList) { item ->
                    InventoryItemRow(item)
                    Divider()
                }
            }
        }
    }
}

@Composable
fun InventoryItemRow(item: InventoryItem) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = item.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "Qty: ${item.quantity}",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal
            )
        }
        Text(
            text = "Location: ${item.location}",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = "Record Level: ${item.recordLevel}",
            fontSize = 14.sp,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
        Text(
            text = item.description,
            fontSize = 14.sp,
            textAlign = TextAlign.Start,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}

// Sample Inventory Data
fun sampleInventory(): List<InventoryItem> {
    return listOf(
        InventoryItem("Item A", "Description of Item A", 100, "Warehouse 1", "Normal"),
        InventoryItem("Item B", "Description of Item B", 50, "Warehouse 2", "Critical"),
        InventoryItem("Item C", "Description of Item C", 200, "Warehouse 3", "Normal"),
        InventoryItem("Item D", "Description of Item D", 75, "Warehouse 4", "Low"),
        InventoryItem("Item E", "Description of Item E", 150, "Warehouse 5", "Normal")
    )
}


@Preview(showBackground = true , showSystemUi = true)
@Composable
fun InventoryScreen(){
    InventoryScreen(rememberNavController())
}