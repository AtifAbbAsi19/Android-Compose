package com.example.jetpackcomposeandroidmaterial3.utils

sealed class Fragments(val route : String){
    object SplashFragment : Fragments (FragmentName.SPLASH_FRAGMENT.name)
    object SignupFragment : Fragments (FragmentName.SIGNUP_FRAGMENT.name)
    object LoginFragment : Fragments (FragmentName.LOGIN_FRAGMENT.name)
    object HomeFragment : Fragments ("{data}"+FragmentName.HOME_FRAGMENT.name) {
        fun createRouteAndPutExtra(data:String) ="$data/${FragmentName.HOME_FRAGMENT.name}"
    }
}
