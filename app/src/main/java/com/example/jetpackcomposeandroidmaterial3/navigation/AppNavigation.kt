package com.example.jetpackcomposeandroidmaterial3.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeandroidmaterial3.ui.fragments.HomeScreen
import com.example.jetpackcomposeandroidmaterial3.ui.fragments.LoginFragment
import com.example.jetpackcomposeandroidmaterial3.ui.fragments.SignupFragment
import com.example.jetpackcomposeandroidmaterial3.ui.fragments.SplashFragment
import com.example.jetpackcomposeandroidmaterial3.utils.Fragments


@Composable
fun SetupNavigationGraph(context : Context) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Fragments.SplashFragment.route) {

       composable(route = Fragments.SplashFragment.route) {
           SplashFragment(navController)
        }

        composable(route = Fragments.HomeFragment.route) {
            val data = it.arguments?.getString("data") //receiving data
            HomeScreen()
        }

        composable(route = Fragments.LoginFragment.route) {
            LoginFragment(context,navController)
        }

        composable(route = Fragments.SignupFragment.route) {
            SignupFragment()
        }


    }

}