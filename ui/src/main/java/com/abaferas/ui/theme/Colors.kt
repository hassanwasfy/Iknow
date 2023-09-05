package com.abaferas.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

data class Colors(
    val i100: Color = info100,
    val i400: Color = info400,
    val i500: Color = info500,
    val i600: Color = info600,
    val i700: Color = info700,
    val n200: Color = neutral200,
    val n500: Color = neutral500,
    val n600: Color = neutral600,
    val n700: Color = neutral700,
    val secondary: Color = Secondary,
    val fontPrimary: Color = FontPrimary,
    val fontSecondary: Color = FontSecondary,
    val fontAccent: Color = FontAccent,
    val white: Color = White,
    val black: Color = Black
)

val LocalColors = compositionLocalOf { Colors() }

val MaterialTheme.color: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
