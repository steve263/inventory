package cimport

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.text.font.FontWeight


import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryinsight.ui.theme.Screens.Home.HomeScreens

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuditAndAdjustmentScreen(navController: NavController) {
    var selectedItem by remember { mutableStateOf("") }
    var recordedQuantity by remember { mutableStateOf(0) }
    var actualQuantity by remember { mutableStateOf("") }
    var adjustmentNeeded by remember { mutableStateOf(false) }
    var adjustmentAmount by remember { mutableStateOf(0) }

    val items = listOf("Item A", "Item B", "Item C", "Item D") // Sample items

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Stock Audit & Adjustment", fontSize = 20.sp, fontWeight = FontWeight.Bold) }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            // Select item for audit
            Text("Select Item:", fontSize = 18.sp)
            DropdownMenu(
                items = items,
                selectedItem = selectedItem,
                onItemSelected = {
                    selectedItem = it
                    recordedQuantity = getRecordedQuantityForItem(it) // Fetch recorded stock from DB
                    adjustmentNeeded = false
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Display recorded stock quantity
            Text("Recorded Stock: $recordedQuantity", fontSize = 18.sp)

            Spacer(modifier = Modifier.height(16.dp))

            // Enter actual stock quantity
            Text("Actual Stock Count:", fontSize = 18.sp)
            BasicTextField(
                value = actualQuantity,
                onValueChange = { actualQuantity = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .background(MaterialTheme.colorScheme.surface, MaterialTheme.shapes.small)
                    .padding(12.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Calculate adjustment
            Button(
                onClick = {
                    val actual = actualQuantity.toIntOrNull()
                    if (actual != null) {
                        adjustmentAmount = actual - recordedQuantity
                        adjustmentNeeded = true
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calculate Adjustment")
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Show adjustment if needed
            if (adjustmentNeeded) {
                Text(
                    "Adjustment Needed: $adjustmentAmount",
                    fontSize = 18.sp,
                    color = if (adjustmentAmount > 0) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Apply adjustment button
                Button(
                    onClick = {
                        applyStockAdjustment(selectedItem, adjustmentAmount)
                        navController.navigateUp() // Return to previous screen
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Apply Adjustment")
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

// Dummy function to fetch recorded quantity for an item from database
fun getRecordedQuantityForItem(item: String): Int {
    // Replace with actual logic to fetch from the database
    return when (item) {
        "Item A" -> 100
        "Item B" -> 80
        "Item C" -> 150
        "Item D" -> 60
        else -> 0
    }
}

// Dummy function to apply stock adjustment
fun applyStockAdjustment(item: String, adjustment: Int) {
    // Implement logic to update stock in database
    println("Adjusting stock for $item by $adjustment units")
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun  StockAuditAndAdjustmentScreenPreview(){
    AuditAndAdjustmentScreen(rememberNavController())

}
