package com.example.jetpackcomposeandroidmaterial3.data

import androidx.annotation.DrawableRes

data class BottomMenuItem(
    val title : String,
    @DrawableRes val iconId : Int,
    var isSelected : Boolean = false
)
