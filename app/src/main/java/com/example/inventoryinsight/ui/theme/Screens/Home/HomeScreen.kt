package com.example.inventoryinsight.ui.theme.Screens.Home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryinsight.R
import com.example.inventoryinsight.navigation.ROUTE_ABOUT
import com.example.inventoryinsight.navigation.ROUTE_AUDIT
import com.example.inventoryinsight.navigation.ROUTE_INVENTORY
import com.example.inventoryinsight.navigation.ROUTE_ORDER
import com.example.inventoryinsight.navigation.ROUTE_PAYMENT
import com.example.inventoryinsight.navigation.ROUTE_SETTING
import com.example.inventoryinsight.navigation.ROUTE_STOCK
import com.example.inventoryinsight.navigation.ROUTE_STOCKIN
import com.example.inventoryinsight.navigation.ROUTE_STOCKOUT
import com.example.inventoryinsight.navigation.ROUTE_UPDATE


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreens(navController: NavController) {
    var showPhoneDetail by remember {
        mutableStateOf(false)
    }
    var emailDetail by remember {
        mutableStateOf(false)
    }
    var location by remember {
        mutableStateOf(false)
    }
    var setting by remember {
        mutableStateOf(false)
    }




    Box() {
        Image(
            painter = painterResource(id = R.drawable.depot),
            contentDescription = "dashboard background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize( )

        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopAppBar(
            title = { Text(text = "Welcome To Stock Wise WareHouse",) },
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Home",
                        tint = Color.Magenta
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = Color.Cyan,
                titleContentColor = Color.Blue,
                navigationIconContentColor = Color.Red
            ),
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Filled.Phone,
                        contentDescription = "PHONE NUMBER",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { showPhoneDetail = !showPhoneDetail }
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    if (showPhoneDetail) {
                        Text(text = "My Phone Number is 0795542312")
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email Icon",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { emailDetail = !emailDetail }

                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    if (emailDetail) {
                        Text(text = "stephen@gmail.com")
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.LocationOn,
                        contentDescription = "Location",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable { location = !location }
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    if (location) {
                        Text(text = "We are located in Mombasa near Bamburi Cement Industry")
                    }
                }
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector =Icons.Filled.Settings ,
                        contentDescription = "Setting",
                        modifier = Modifier
                            .size(30.dp)
                            .clickable {
                                setting = !setting
                                navController.navigate(ROUTE_SETTING)

                            }

                    )

                }
            }
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
//                .padding(paddingValues)
                .padding(16.dp)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(0xFFEDE7F6),
                            Color(0xFFF3E5F5)
                        )
                    )
                )
        ) {


            // Inventory Button
            CustomButton(
                text = "Inventory",
                iconRes = R.drawable.ikeahouse,
                backgroundColor = Color(0xFF03DAC5),
                onClick = { navController.navigate(ROUTE_INVENTORY) }
            )

            // Orders Button
            CustomButton(
                text = "Orders",
                iconRes = R.drawable.ikeahouse,
                backgroundColor = Color(0xFFFF9800),
                onClick = { navController.navigate(ROUTE_ORDER) }
            )

            // Settings Button
            CustomButton(
                text = "Settings",
                iconRes = R.drawable.ikeahouse,
                backgroundColor = Color(0xFF2196F3),
                onClick = { navController.navigate(ROUTE_SETTING) }
            )
            CustomButton(
                text = "About",
                iconRes = R.drawable.ikeahouse,
                backgroundColor = Color(0xFF6200EE),
                onClick = { navController.navigate(ROUTE_ABOUT) }
            )
            CustomButton(
                text = "Stock",
                iconRes = R.drawable.ikeahouse,
                backgroundColor = Color(0xFFB3E5FC),
                onClick = { navController.navigate(ROUTE_STOCK) }
            )
            CustomButton(
                    text = "Update",
            iconRes = R.drawable.ikeahouse,
            backgroundColor = Color(0xFF212121),
            onClick = { navController.navigate(ROUTE_UPDATE) }
            )
            CustomButton(
                text = "Audit",
                iconRes = R.drawable.ikeahouse,
                backgroundColor = Color(0xFFC6DABF),
                onClick = { navController.navigate(ROUTE_AUDIT) }
            )
            CustomButton(
                text = "Stock in",
                iconRes = R.drawable.ikeahouse,
                backgroundColor = Color(0xFFD4AF37),
                onClick = { navController.navigate(ROUTE_STOCKIN) }
            )
            CustomButton(
                text = "Stock out",
                iconRes = R.drawable.ikeahouse,
                backgroundColor = Color(0xFFC0C0C0),
                onClick = { navController.navigate(ROUTE_STOCKOUT) }
            )
        }
    }
}

@Composable
fun CustomButton(text: String, iconRes: Int, backgroundColor: Color, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Start
    ) {
        Icon(
            painter = painterResource(id = iconRes),
            contentDescription = text,
            tint = Color.White,
            modifier = Modifier
                .size(48.dp)
                .background(Color(0xFF6200EE), shape = CircleShape)
                .padding(12.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 18.sp, color = Color.White, fontWeight = FontWeight.Medium)
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreenPreview(){
    HomeScreens(rememberNavController())

}