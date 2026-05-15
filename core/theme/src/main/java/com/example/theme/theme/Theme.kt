package com.example.theme.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.theme.R


@Composable
fun HomeWorkoutTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors: WorkoutColors =  if (darkTheme) darkWorkoutColors else lightWorkoutColors

    WorkoutTheme(workoutColors = colors, content = content)
}

@Composable
fun WorkoutTheme(
    workoutColors: WorkoutColors,
    content: @Composable () -> Unit
) {
    CompositionLocalProvider(
        WorkoutShapes provides workoutShapes,
        WorkoutColorScheme provides workoutColors,
        WorkoutTypography provides workoutTypography,
    ){
        content()
    }
}

data class WorkoutColors(
    val primary : Color,
    val onPrimary:Color,
    val secondary : Color,
    val onSecondary:Color,
    val background : Color,
    val onBackground:Color,
    )

data class CustomTypography(
    val title: TextStyle,
    val headline: TextStyle,
    val body: TextStyle,
)

data class CustomShapes(
    val small: CornerBasedShape,
    val medium: CornerBasedShape,
    val large: CornerBasedShape,
)

@SuppressLint("CompositionLocalNaming")
val WorkoutColorScheme = staticCompositionLocalOf { WorkoutColors(
    primary = Color.Unspecified,
    onPrimary = Color.Unspecified,
    secondary = Color.Unspecified,
    onSecondary = Color.Unspecified,
    background = Color.Unspecified,
    onBackground = Color.Unspecified
)}
val WorkoutTypography = staticCompositionLocalOf { CustomTypography(
    title = TextStyle.Default,
    headline = TextStyle.Default,
    body = TextStyle.Default
) }

val WorkoutShapes = staticCompositionLocalOf { CustomShapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
) }

val Poppins = FontFamily(Font(R.font.poppins_bold, FontWeight.Bold),
    Font(R.font.poppins_semi_bold, FontWeight.SemiBold),
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium))
private val workoutTypography = CustomTypography(
    title = TextStyle(fontFamily = Poppins, fontWeight = FontWeight.SemiBold, fontSize = 20.sp),
    headline = TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Bold, fontSize = 24.sp),
    body = TextStyle(fontFamily = Poppins, fontWeight = FontWeight.Normal, fontSize = 14.sp)
)

private val workoutShapes = CustomShapes(
    small = RoundedCornerShape(8.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
)
private val lightWorkoutColors = WorkoutColors(
    primary = Color(0xFF5B67F1),      // Vibrant Indigo
    onPrimary = Color(0xFFFFFFFF),

    secondary = Color(0xFFFF7A59),    // Energetic Orange
    onSecondary = Color(0xFFFFFFFF),

    background = Color(0xFFF7F9FC),   // Soft Light Background
    onBackground = Color(0xFF1C1C1E)  // Dark Text
)
private val darkWorkoutColors = WorkoutColors(
    primary = Color(0xFF8B93FF),      // Soft Neon Indigo
    onPrimary = Color(0xFF0F1115),

    secondary = Color(0xFFFF9B7A),    // Warm Accent
    onSecondary = Color(0xFF0F1115),

    background = Color(0xFF0F1115),   // Dark Charcoal
    onBackground = Color(0xFFEAEAEA)  // Light Text
)

object WorkoutTheme {

    val colors: WorkoutColors
        @Composable
        get() = WorkoutColorScheme.current

    val typography: CustomTypography
        @Composable
        get() = WorkoutTypography.current

    val shapes: CustomShapes
        @Composable
        get() = WorkoutShapes.current
}