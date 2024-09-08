package com.example.inventoryinsight.data

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.example.inventoryinsight.models.Payment
import com.google.firebase.database.FirebaseDatabase

class PaymentViewModel (var navController: NavController,var context: Context){
    var progress: ProgressDialog

    init {
        progress = ProgressDialog(context)
        progress.setTitle("Loading")
        progress.setMessage("PLease Wait")
    }
    fun Payment(
        cardholdername:String,
        cardnumber:String,
        expiration:String,
        cvv:String
    ){
        var id = System.currentTimeMillis().toString()
        var payment = Payment(
            cardholdername,
            cardnumber,
            expiration,
            cvv
        )
        var paymentRef = FirebaseDatabase.getInstance().getReference()
        if (cardholdername.isEmpty()|| cardnumber.isEmpty()|| expiration.isEmpty()||cvv.isEmpty()){
            Toast.makeText(context, "Please fill all the Field", Toast.LENGTH_LONG).show()
            return

        } else {
            progress.show()
            paymentRef.setValue(payment).addOnCompleteListener{

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



