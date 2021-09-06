package com.dardev.onlyclone.model

data class OFUser(
    var tagU:Int,
    var prenom:String,
    var nom:String,
    var bio:String,
    var posts:List<OFPost>
)
