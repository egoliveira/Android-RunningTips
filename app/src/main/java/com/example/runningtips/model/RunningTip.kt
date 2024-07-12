package com.example.runningtips.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class RunningTip(
    val day: Int,
    @StringRes val tipTitleResId: Int,
    @StringRes val tipDescriptionResId: Int,
    @DrawableRes val tipPhotoResId: Int
)
