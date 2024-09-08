package com.example.inventoryinsight.models

class Payment {
    var cardholdername:String=""
    var cardnumber:String=""
    var expirationdate:String=""
    var cvv:String=""
    constructor(cardholdername:String,cardnumber:String,expirationdate:String,cvv:String){
        this.cardholdername = cardholdername
        this.cardnumber = cardnumber
        this.expirationdate = expirationdate
        this.cvv = cvv
     }



}