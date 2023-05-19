package com.example.jetpackcomposeandroidmaterial3.utils

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeandroidmaterial3.R


@Composable
fun CardViewUi() {
    val painter = painterResource(id = R.drawable.ic_launcher_background)
    val description = "Hello this is image view"
    val title = "Cool Title"
    val modifier = Modifier.fillMaxWidth(0.5f)

    Box(modifier = modifier.padding(16.dp)) {
        ImageCard(painter, description, title)
    }


}



@Composable
fun SplashUi() {


    Column(
        modifier = Modifier.fillMaxSize(),
    ) {

        //.fillMaxSize()
        //.padding(24.dp),

        // horizontalAlignment = Alignment.CenterHorizontally
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(.3f)
        )
        {


            Text("1")
            Text("2")
            Text("3")
        }





        Text(
            text = "First item",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = "Second item",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.End
        )


        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                text = "Click",

                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .align(alignment = Alignment.CenterHorizontally)
                    .padding(16.dp)
            )


            Spacer(modifier = Modifier.width(10.dp))

        }

    }

}


@Composable
fun ImageCard(
    painter: Painter, //to use image from image resources
    contentDescription: String?,
    title: String?,
    modifier: Modifier = Modifier
) {

    val elevation: CardElevation = CardDefaults.cardElevation(5.dp)

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        elevation = elevation
    ) {


        Box(modifier = Modifier.height(200.dp)) {

            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop, //equal to center crop
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush =
                        Brush.verticalGradient(
                            colors = listOf(Color.Transparent, Color.Black),
                            startY = 300f
                        )
                    )

            ) {

            }


            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart

            ) {

                Text(
                    text = title!!,
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 16.sp
                    )
                )
            }


        }


    }


}