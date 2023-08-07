package me.darthwithap.android.simpletweets.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import me.darthwithap.android.simpletweets.R

// Set of Material typography styles to start with
val Typography = Typography(
  body1 = TextStyle(
    fontFamily = FontFamily(
      Font(R.font.montserrat_thin, FontWeight.Thin),
      Font(R.font.montserrat_regular, FontWeight.Normal),
      Font(R.font.montserrat_medium, FontWeight.Medium),
      Font(R.font.montserrat_semibold, FontWeight.SemiBold),
      Font(R.font.montserrat_bold, FontWeight.Bold),
    ),
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    lineHeight = 24.sp,
    color = Color.White,
    letterSpacing = 0.5.sp
  ),
  body2 = TextStyle(
    fontFamily = FontFamily(
      Font(R.font.montserrat_thin, FontWeight.Thin),
      Font(R.font.montserrat_regular, FontWeight.Normal),
      Font(R.font.montserrat_medium, FontWeight.Medium),
      Font(R.font.montserrat_semibold, FontWeight.SemiBold),
      Font(R.font.montserrat_bold, FontWeight.Bold),
    ),
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    color = Color.White,
    lineHeight = 20.sp,
    letterSpacing = 0.4.sp
  ),
  h3 = TextStyle(
    fontFamily = FontFamily(
      Font(R.font.montserrat_thin, FontWeight.Thin),
      Font(R.font.montserrat_regular, FontWeight.Normal),
      Font(R.font.montserrat_medium, FontWeight.Medium),
      Font(R.font.montserrat_semibold, FontWeight.SemiBold),
      Font(R.font.montserrat_bold, FontWeight.Bold),
    ),
    fontWeight = FontWeight.SemiBold,
    fontSize = 20.sp,
    color = Color.White,
    lineHeight = 20.sp,
    letterSpacing = 0.4.sp
  )
)