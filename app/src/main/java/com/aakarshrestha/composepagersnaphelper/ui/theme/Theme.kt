package com.aakarshrestha.composepagersnaphelper.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = BLACK_800,
    primaryVariant = BLACK_800,
    secondary = TEAL_200,
    background = BLACK_800,
    surface = BLACK_800,
    onPrimary = WHITE_50,
    onSecondary = WHITE_50,
    onBackground = WHITE_50,
    onSurface = WHITE_50,
)

private val LightColorPalette = lightColors(
    primary = WHITE_50,
    primaryVariant = WHITE_50,
    secondary = TEAL_200,
    background = Color.White,
    surface = Color.White,
    onPrimary = BLACK_800,
    onSecondary = BLACK_800,
    onBackground = BLACK_800,
    onSurface = BLACK_800,
)

@Composable
fun SampleAppComposePagerSnapHelperTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}