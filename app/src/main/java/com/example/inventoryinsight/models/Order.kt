package com.example.inventoryinsight.models


class Order {
        var indentificationnumber:String=""
        var fullname:String=""
        var contactnumber:String=""
        var addressnumber:String = ""
        var quantityofgoods:String = ""
        var description:String=""
        var location:String = ""

        constructor(indentificationnumber:String,fullname:String,contactnumber:String,addressnumber:String,quantityofgoods:String,description:String,location:String){
            this.indentificationnumber = indentificationnumber
            this.fullname = fullname
            this.contactnumber = contactnumber
            this.addressnumber = addressnumber
            this.quantityofgoods = quantityofgoods
            this.description = description
            this.location = location
        }
        constructor()

    }
