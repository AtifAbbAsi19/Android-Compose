package com.example.jetpackcomposeandroidmaterial3.ui.fragments

import android.content.Context
import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposeandroidmaterial3.R
import com.example.jetpackcomposeandroidmaterial3.ui.theme.BlueViolet3
import com.example.jetpackcomposeandroidmaterial3.ui.theme.TextWhite
import com.example.jetpackcomposeandroidmaterial3.utils.Fragments
import kotlinx.coroutines.delay

@Composable
fun SplashFragment(navController : NavController) {


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {


        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .background(BlueViolet3)
                .fillMaxSize()
        ){

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Icon(painter = painterResource(id = R.drawable.ic_place_24), contentDescription = "place" )

                Text(
                    text = "MVP \n Application",
                    textAlign = TextAlign.Center,
                    color = TextWhite,
                    minLines = 2,
                    style = MaterialTheme.typography.headlineMedium
                )

                Spacer(modifier = Modifier.padding(8.dp))

                Text(
                    text = "Welcome to MVP App",
                    style = MaterialTheme.typography.bodySmall,
                    color = TextWhite
                    //, modifier = Modifier.align(alignment = Alignment.CenterHorizontally)
                )
            }


            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ){

            }

                Text(
                    text = "Lets Get Started!",
                    color = TextWhite,
                    style = MaterialTheme.typography.bodySmall
                   , modifier = Modifier
                        .align(alignment = Alignment.BottomCenter)
                        .padding(16.dp)
                )


        }


        Handler(Looper.getMainLooper()).postDelayed({
            navigateToHomeFragment(navController)
        }, 1000)



    }

}


fun navigateToHomeFragment(navController: NavController){



    navController.navigate(Fragments.LoginFragment.route)
}

@Preview
@Composable
fun SplashFragmentPreview(){

    val navController = rememberNavController()

    Surface {
        SplashFragment(navController)
    }

}