package com.example.inventoryinsight.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cimport.AuditAndAdjustmentScreen
import com.example.inventoryinsight.ui.theme.Screens.About.AboutScreen
import com.example.inventoryinsight.ui.theme.Screens.Home.HomeScreens
import com.example.inventoryinsight.ui.theme.Screens.Inventory.InventoryScreen
import com.example.inventoryinsight.ui.theme.Screens.Order.OrderScreen
import com.example.inventoryinsight.ui.theme.Screens.Setting.SettingsScreen

import com.example.inventoryinsight.ui.theme.Screens.Signup.SignupScreen
import com.example.inventoryinsight.ui.theme.Screens.Stock.StockInOutScreen
import com.example.inventoryinsight.ui.theme.Screens.Stockin.StockInScreen
import com.example.inventoryinsight.ui.theme.Screens.Update.UpdateScreen
import com.example.inventoryinsight.ui.theme.Screens.login.Login
import com.example.inventoryinsight.ui.theme.Screens.payment.PaymentScreen
import com.example.inventoryinsight.ui.theme.Screens.stockout.StockOutScreen


@Composable
fun AppNavHost(navController: NavHostController = rememberNavController(),
               startDestination: String  = ROUTE_SIGNUP){
    NavHost(navController = navController,
        startDestination =startDestination ) {
        composable(ROUTE_SIGNUP){ SignupScreen(navController) }
        composable(ROUTE_HOME){ HomeScreens(navController) }
        composable(ROUTE_ORDER){ OrderScreen(navController)}
        composable(ROUTE_LOGIN){ Login(navController) }
        composable(ROUTE_UPDATE){ UpdateScreen(navController)}
        composable(ROUTE_ABOUT){ AboutScreen(navController)}
        composable(ROUTE_STOCK){ StockInOutScreen(navController)}
        composable(ROUTE_AUDIT){AuditAndAdjustmentScreen(navController)}
        composable(ROUTE_PAYMENT){ PaymentScreen(navController)}
        composable(ROUTE_STOCKIN){ StockInScreen(navController)}
        composable(ROUTE_STOCKOUT){ StockOutScreen(navController)}

        composable(ROUTE_INVENTORY){ InventoryScreen(navController)}
        composable(ROUTE_SETTING){ SettingsScreen(navController)}



    }
}

