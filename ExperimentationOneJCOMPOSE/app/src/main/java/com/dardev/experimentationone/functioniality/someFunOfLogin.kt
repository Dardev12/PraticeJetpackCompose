package com.dardev.experimentationone.functioniality

import androidx.navigation.NavController

fun VerifierConnexion(username:String?=null,password:String?=null,navController: NavController){

    if (username=="Darren"&&password=="1234"){

        navController.navigate(route = "main")

    }


}
