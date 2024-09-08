package com.example.inventoryinsight.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.google.firebase.database.FirebaseDatabase


class OrderViewModel(var navController: NavController, var context: Context) {
    var progress: ProgressDialog

    init {
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("Please wait a moment")
    }

    fun Order(
        indentificationnumber: String,
        filenames: String,
        contactnumber: String,
        addressnumber: String,
        quantityofgoods: String,
        description: String,
        location: String,
    ) {
        var id = System.currentTimeMillis().toString()
        var order = Order(
            indentificationnumber,
            filenames,
            contactnumber,
            addressnumber,
            quantityofgoods,
            description,
            location,
        )
        var orderRef = FirebaseDatabase.getInstance().getReference()
            .child("Order/$id")
        if (indentificationnumber.isEmpty() || filenames.isEmpty() || contactnumber.isEmpty() || addressnumber.isEmpty() || quantityofgoods.isEmpty() ||
            description.isEmpty() || location.isEmpty()
        ) {
            Toast.makeText(context, "Please fill all the Field", Toast.LENGTH_LONG).show()
            return

        } else {
            progress.show()
            orderRef.setValue(order).addOnCompleteListener {
                progress.dismiss()
                if (it.isSuccessful) {
                    Toast.makeText(
                        context,
                        "Order is successfully included",
                        Toast.LENGTH_LONG
                    ).show()

                } else {
                    Toast.makeText(
                        context,
                        "ERROR:${it.exception!!.message}",
                        Toast.LENGTH_LONG

                    )
                        .show()
                }

            }

        }

    }
}

