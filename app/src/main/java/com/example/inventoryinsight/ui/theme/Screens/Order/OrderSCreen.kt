package com.example.inventoryinsight.ui.theme.Screens.Order
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.inventoryinsight.R
import com.example.inventoryinsight.data.OrderViewModel
import com.example.inventoryinsight.navigation.ROUTE_ORDER
import com.example.inventoryinsight.navigation.ROUTE_PAYMENT


@Composable
fun OrderScreen(navController: NavController){
    var indentificationnumber by remember {
        mutableStateOf(value = "")
    }
    var fullname by remember {
        mutableStateOf(value = "")
    }
    var contactnumber by remember {
        mutableStateOf(value = "")
    }
    var number by remember {
        mutableStateOf(value = "")
    }
    var addressnumber by remember {
        mutableStateOf(value = "")
    }
    var quantityofgood by remember {
        mutableStateOf(value = "")
    }
    var description by remember {
        mutableStateOf(value ="" )
    }
    var location by remember {
        mutableStateOf(value = "")
    }
    Box (){
        Image(painter = painterResource(id = R.drawable.industrial),
            contentDescription = "dashboard background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()

        )


    }
    val context = LocalContext.current
    Column (
        modifier = Modifier
            .clip(shape = RoundedCornerShape(10.dp))
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Welcome to Stock Wise WareHouse",
            fontSize = 20.sp,
            fontFamily = FontFamily.Cursive,
            fontStyle = FontStyle.Normal,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .background(Color.Gray)
                .padding(20.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            modifier = Modifier

                .wrapContentWidth()
                .align(Alignment.CenterHorizontally),
            label = { Text(text = " identification number",
                color = Color.Yellow)},
            placeholder = { Text(text = "Please Enter Your Identification number")},
            value = indentificationnumber,
            onValueChange = {
                newindentification->indentificationnumber=newindentification

            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally),
            label = { Text(text = " full name", color = Color.Yellow)},
            placeholder = { Text(text = "Please Enter Your full name")},
            value = fullname,
            onValueChange = {
                newfullname->fullname=newfullname

            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally),
            label = { Text(text = "   phone number", color = Color.Yellow)},
            placeholder = { Text(text = "Please Enter Your Contact number")},
            value = number,
            onValueChange = {
                newnumber->number=newnumber


            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally),
            label = { Text(text = " address number",
                color = Color.Yellow)},
            placeholder = { Text(text = "Please Enter Your address number")},
            value = addressnumber,
            onValueChange = {
                newaddressnumber->addressnumber=newaddressnumber

            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally),
            label = { Text(text = " quantity of good",
                color = Color.Yellow)},
            placeholder = { Text(text = "Please Enter the quantity of good eg how many tonnes")},
            value = quantityofgood,
            onValueChange = {
                newquantitypfgood->quantityofgood=newquantitypfgood

            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            modifier = Modifier
                .height(100.dp)
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally),
            label = { Text(text = " description",
                color = Color.Yellow)},
            placeholder = { Text(text = "Please can you give us a small detail of which type of goods we are keeping")},
            value = description,
            singleLine = false,
            onValueChange = {
                newdescription->description=newdescription

            })
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(
            modifier = Modifier
                .height(100.dp)
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally),
            label = { Text(text = " location",
                color = Color.Yellow )},
            placeholder = { Text(text = "Please Enter the location where you would like us to deliver")},
            value = location,
            singleLine = false,
            onValueChange = {
                newlocation->location=newlocation

            })
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            onClick = {
//                val order = OrderViewModel(navController, context)
//                order.Order(indentificationnumber.trim(),fullname.trim(),contactnumber.trim(),
//                    addressnumber.trim(),quantityofgood.trim(),description.trim(),location.trim())
                navController.navigate(ROUTE_PAYMENT)
            },
            colors = ButtonDefaults.buttonColors(Color.Yellow),
            modifier = Modifier
                .wrapContentWidth()
                .align(Alignment.CenterHorizontally)
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Place your order")

        }


    }
}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun Preview(){
    OrderScreen(navController = rememberNavController())
}
