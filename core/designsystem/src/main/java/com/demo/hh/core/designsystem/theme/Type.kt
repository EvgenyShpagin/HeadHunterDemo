package com.demo.hh.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.LineHeightStyle.Alignment
import androidx.compose.ui.text.style.LineHeightStyle.Trim
import androidx.compose.ui.unit.sp
import com.demo.hh.core.designsystem.R

private val SFProDisplay = FontFamily(
    Font(R.font.sf_pro_display_regular, weight = FontWeight.Normal),
    Font(R.font.sf_pro_display_medium, weight = FontWeight.Medium),
    Font(R.font.sf_pro_display_semibold, weight = FontWeight.SemiBold)
)

val Title1 = TextStyle(
    fontFamily = SFProDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 22.sp,
    lineHeight = 22.sp * 1.2f,
    letterSpacing = 0.sp
)

val Title2 = TextStyle(
    fontFamily = SFProDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 20.sp,
    lineHeight = 20.sp * 1.2f,
    letterSpacing = 0.sp
)

val Title3 = TextStyle(
    fontFamily = SFProDisplay,
    fontWeight = FontWeight.Medium,
    fontSize = 16.sp,
    lineHeight = 16.sp * 1.2f,
    letterSpacing = 0.sp
)

val Title4 = TextStyle(
    fontFamily = SFProDisplay,
    fontWeight = FontWeight.Medium,
    fontSize = 14.sp,
    lineHeight = 14.sp * 1.2f,
    letterSpacing = 0.sp
)

val Text1 = TextStyle(
    fontFamily = SFProDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 14.sp * 1.2f,
    letterSpacing = 0.sp
)
val ButtonText1 = TextStyle(
    fontFamily = SFProDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 16.sp,
    lineHeight = 16.sp * 1.3f,
    letterSpacing = 0.0.sp,
    lineHeightStyle = LineHeightStyle(
        alignment = Alignment.Center,
        trim = Trim.LastLineBottom,
    )
)

val ButtonText2 = TextStyle(
    fontFamily = SFProDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 14.sp,
    lineHeight = 14.sp * 1.3f,
    letterSpacing = 0.0.sp,
    lineHeightStyle = LineHeightStyle(
        alignment = Alignment.Center,
        trim = Trim.LastLineBottom,
    )
)

val TabText = TextStyle(
    fontFamily = SFProDisplay,
    fontWeight = FontWeight.Normal,
    fontSize = 10.sp,
    lineHeight = 10.sp * 1.1f,
    letterSpacing = 0.0.sp
)

val Number = TextStyle(
    fontFamily = SFProDisplay,
    fontWeight = FontWeight.SemiBold,
    fontSize = 7.sp,
    lineHeight = 7.sp * 1.1f,
    letterSpacing = 0.0.sp
)

internal val HhTypography = Typography(
    titleLarge = Title1,
    titleMedium = Title2,
    titleSmall = Title3,
    bodyLarge = Title4,
    bodyMedium = Text1,
    bodySmall = Number,
    labelLarge = ButtonText1,
    labelMedium = ButtonText2,
    labelSmall = TabText,
)