package com.example.jetpackcomposeandroidmaterial3.ui.fragments

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.jetpackcomposeandroidmaterial3.R
import com.example.jetpackcomposeandroidmaterial3.data.BottomMenuItem
import com.example.jetpackcomposeandroidmaterial3.data.Feature
import com.example.jetpackcomposeandroidmaterial3.ui.theme.*
import com.example.jetpackcomposeandroidmaterial3.utils.standardQuadFromTo
import com.example.jetpackcomposeandroidmaterial3.viewmodel.HomeViewModel


@Composable
fun HomeScreen() {


    val homeViewModel = viewModel<HomeViewModel>()

    Box(
        modifier = Modifier
            .background(DeepBlue)
            .fillMaxSize()
    ) {

        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet Sleep", "Insomnia", "Depression","Happiness"))
            CurrentMeditation()
            FeatureSection(
                features = listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_baseline_home_24,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_place_24,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_play_24,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_search_24,
                        Beige1,
                        Beige2,
                        Beige3
                    )
                )
            )
        }
        BottomNavMenu(
            listOf(
                BottomMenuItem("Home", R.drawable.ic_baseline_home_24),
                BottomMenuItem("Meditate", R.drawable.ic_place_24),
                BottomMenuItem("Sleep", R.drawable.ic_play_24),
                BottomMenuItem("Music", R.drawable.ic_search_24),
                BottomMenuItem("Profile", R.drawable.ic_baseline_list_24),
            ),
            modifier = Modifier.align(alignment = Alignment.BottomCenter
            )
        )

    }


}

@Composable
fun GreetingSection(name: String = "Atif") {
    //it will push it to start
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {

        Column(
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Good Morning, $name",
                color = TextWhite,
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = "We wish you have a good day!",
                color = TextWhite,
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(10.dp)
            ) {

                Icon(
                    painter = painterResource(
                        id = R.drawable.ic_search_24
                    ),
                    contentDescription = "Search",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }


        }


    }
}

@Composable
fun ChipSection(chips: List<String>) {

    var selectedChipIndex by remember {
        mutableStateOf(0)
    }

    LazyRow {

        items(count = chips.size) {

            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(
                        start = 15.dp,
                        top = 15.dp,
                        bottom = 15.dp
                    )
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonSelectedBlue
                        else ButtonNormalBlue
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }

    }


}


@Composable
fun CurrentMeditation(color: Color = BackgroundLightRed) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(color = color)
            .padding(horizontal = 15.dp, vertical = 20.dp)
            .fillMaxWidth()
    ) {

        Column {

            Text(
                text = "Daily thought",
                color = TextWhite,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = "Meditation . 3-10 min",
                style = MaterialTheme.typography.bodySmall,
                color = TextWhite
            )
        }

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(ButtonSelectedBlue)
                .padding(10.dp)
        )
        {

            Icon(
                painter = painterResource(id = R.drawable.ic_play_24),
                contentDescription = "Play",
                tint = Color.White,
                modifier = Modifier.size(16.dp)
            )


        }


    }

}


@Composable
fun FeatureSection(features: List<Feature>) {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Features",
            color = TextWhite,
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(15.dp)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(
                start = 7.5.dp, end = 7.5.dp, bottom = 100.dp
            ),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(features[it])
            }
        }

    }

}

@Composable
fun FeatureItem(feature: Feature) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.5.dp)
            .aspectRatio(1f)
            .clip(RoundedCornerShape(10.dp))
            .background(color = feature.darkColor)
    ) {

        val width = constraints.maxWidth
        val height = constraints.maxHeight


        val mediumColorPoint1 = Offset(0f, height * 0.3f)
        val mediumColorPoint2 = Offset(0f * 0.1f, height * 0.35f)
        val mediumColorPoint3 = Offset(0f * 0.4f, height * 0.05f)
        val mediumColorPoint4 = Offset(0f * 0.75f, height * 0.7f)
        val mediumColorPoint5 = Offset(0f * 1.4f, -height.toFloat())

        val mediumColoredPath = Path().apply {

            moveTo(mediumColorPoint1.x, mediumColorPoint1.y)
            standardQuadFromTo(mediumColorPoint1, mediumColorPoint2)
            standardQuadFromTo(mediumColorPoint2, mediumColorPoint3)
            standardQuadFromTo(mediumColorPoint3, mediumColorPoint4)
            standardQuadFromTo(mediumColorPoint4, mediumColorPoint5)

            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        // Light colored path
        val lightPoint1 = Offset(0f, height * 0.35f)
        val lightPoint2 = Offset(width * 0.1f, height * 0.4f)
        val lightPoint3 = Offset(width * 0.3f, height * 0.35f)
        val lightPoint4 = Offset(width * 0.65f, height.toFloat())
        val lightPoint5 = Offset(width * 1.4f, -height.toFloat() / 3f)

        val lightColoredPath = Path().apply {
            moveTo(lightPoint1.x, lightPoint1.y)
            standardQuadFromTo(lightPoint1, lightPoint2)
            standardQuadFromTo(lightPoint2, lightPoint3)
            standardQuadFromTo(lightPoint3, lightPoint4)
            standardQuadFromTo(lightPoint4, lightPoint5)
            lineTo(width.toFloat() + 100f, height.toFloat() + 100f)
            lineTo(-100f, height.toFloat() + 100f)
            close()
        }

        Canvas(modifier = Modifier.fillMaxSize()) {
            drawPath(path = mediumColoredPath, color = feature.mediumColor)
            drawPath(path = lightColoredPath, color = feature.lightColor)
        }


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(15.dp)
        ) {

            Text(
                text = feature.title,
                fontSize = 16.sp,
                style = MaterialTheme.typography.headlineMedium,
                lineHeight = 24.sp,
                modifier = Modifier.align(Alignment.TopStart),
            )

            Icon(
                painter = painterResource(id = feature.iconId),
                contentDescription = feature.title,
                tint = Color.White,
                modifier = Modifier.align(Alignment.BottomStart)
            )

            Text(
                text = "Start",
                color = TextWhite,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .clickable {

                    }
                    .align(Alignment.BottomEnd)
                    .clip(RoundedCornerShape(10.dp))
                    .background(ButtonSelectedBlue)
                    .padding(vertical = 6.dp, horizontal = 15.dp)

            )


        }


    }
}


@Composable
fun BottomNavMenu(
    navItems: List<BottomMenuItem>,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedIndex: Int = 0,
    modifier: Modifier = Modifier,
) {

    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedIndex)
    }

    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier.fillMaxWidth()
            .background(DeepBlue)
            .padding(15.dp)
    ){
        navItems.forEachIndexed {index , item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor = activeHighlightColor,
                activeTextColor = activeTextColor,
                inactiveTextColor = inactiveTextColor
            ) {
                selectedItemIndex = index
            }
        }
    }

}



@Composable
fun BottomMenuItem(
    item: BottomMenuItem,
    isSelected: Boolean = false,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(10.dp)
        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(
            text = item.title,
            color = if(isSelected) activeTextColor else inactiveTextColor
        )
    }
}


