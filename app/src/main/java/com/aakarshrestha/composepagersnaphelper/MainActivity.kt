package com.aakarshrestha.composepagersnaphelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.core.view.WindowCompat
import com.aakarshrestha.composepagersnaphelper.data.MusicData
import com.aakarshrestha.composepagersnaphelper.model.Music
import com.aakarshrestha.composepagersnaphelper.screens.MainScreen
import com.aakarshrestha.composepagersnaphelper.screens.Screen
import com.aakarshrestha.composepagersnaphelper.ui.theme.SampleAppComposePagerSnapHelperTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, true)
        setContent {
            SampleAppComposePagerSnapHelperTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MyApp(MusicData.musicList)
                }
            }
        }
    }

    @Composable
    fun MyApp(musicList: List<Music>, screen: Screen? = Screen.MainScreen) {
        when(screen) {
            is Screen.MainScreen -> {
                MainScreen(
                    musicList = musicList,
                    heading = "Beats that",
                    title = "Touch your Heart",
                    subtitle = "Best songs of the year"
                )
            }
        }

    }
}