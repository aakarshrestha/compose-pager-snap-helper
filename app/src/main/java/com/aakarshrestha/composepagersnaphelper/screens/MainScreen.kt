package com.aakarshrestha.composepagersnaphelper.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.*
import com.aakarshrestha.composepagersnaphelper.ComposePagerSnapHelper
import com.aakarshrestha.composepagersnaphelper.R
import com.aakarshrestha.composepagersnaphelper.model.Music

@Composable
fun MainScreen(
    musicList: List<Music>,
    heading: String,
    title: String,
    subtitle: String
) {
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = MaterialTheme.colors.primary)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            TopAppBarSection()
            BodySection(
                musicList = musicList,
                heading = heading,
                title = title,
                subtitle = subtitle
            )
        }
    }
}

@Composable
fun TopAppBarSection() {
    TopAppBar( elevation = 0.dp, modifier = Modifier.background(color = MaterialTheme.colors.primary) ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .align(alignment = Alignment.CenterVertically),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Icon(
                painter = painterResource(R.drawable.ic_menu),
                contentDescription = "Menu",
                modifier = Modifier
                    .padding(16.dp).clickable {
                        //do your thing
                    }
            )

            Row(
                modifier = Modifier.weight(1f).fillMaxSize()
            ) {
                Text(text = "Snap", fontWeight = FontWeight.Bold, modifier = Modifier.padding(16.dp).fillMaxWidth())
            }
        }
    }
}

@Composable
fun BodySection(
    musicList: List<Music>,
    heading: String,
    title: String,
    subtitle: String
) {
    LazyColumn {
        item {
            HeaderSection(
                heading = heading,
                title = title,
                subtitle = subtitle
            )
        }

        item {
            if (musicList.isEmpty()) { return@item }
            HorizontalMusicList(musicList.count())
        }

        item {
            if (musicList.isEmpty()) { return@item }
            VerticalMusicList(musicList)
        }
    }
}

@Composable
fun HeaderSection(
    heading: String,
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier
            .padding(top = 10.dp)
    ) {
        Text(
            text = heading,
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            fontSize = 30.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = title,
            modifier = Modifier
                .padding(start = 16.dp, top = 0.dp, end = 16.dp)
                .fillMaxWidth(),
            fontSize = 24.sp,
            fontWeight = FontWeight.Light
        )
        Text(
            text = subtitle,
            modifier = Modifier
                .padding(start = 16.dp, top = 5.dp, bottom = 16.dp, end = 16.dp)
                .fillMaxWidth(),
            fontSize = 18.sp,
            color = Color.Gray,
            fontWeight = FontWeight.Thin
        )
    }
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun HorizontalMusicList(count: Int) {

    val widthValue = 320.dp

    ComposePagerSnapHelper(
        width = widthValue
    ) { listState ->
            LazyRow(
                state = listState,
            ) {
                items(count = count) { item ->
                    Card(
                        modifier = Modifier
                            .width(widthValue)
                            .height(350.dp)
                            .padding(
                                start = if (item == 0) 16.dp else 16.dp,
                                top = 16.dp, bottom = 16.dp,
                                end = if (item == 4) 16.dp else 8.dp),
                        backgroundColor = Color.LightGray, shape = RoundedCornerShape(12)
                    ) {
                        //Put text or whatever here

                    }
                }
            }
        }
    }

@Composable
fun VerticalMusicList(musicList: List<Music>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 30.dp, bottom = 16.dp)
    ) {
        musicList.forEach { music ->
            MusicRow(
                musicType = music.musicType,
                songName = music.songName
            )
        }
    }
}

@Composable
fun MusicRow(
    musicType: String,
    songName: String
) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp)
        ,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_disc_vinyl),
                contentDescription = "Vinyl Icon",
                modifier = Modifier
                    .width(70.dp)
                    .height(70.dp)

            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
            ) {
                Text(text = musicType, fontWeight = FontWeight.ExtraBold)
                Text(text = songName, fontWeight = FontWeight.Thin)
            }
        }

        Icon(
            painter = painterResource(R.drawable.ic_more),
            contentDescription = "more",
            modifier = Modifier
                .fillMaxHeight()
                .padding(16.dp)
                .align(alignment = Alignment.CenterVertically)
        )
    }
}