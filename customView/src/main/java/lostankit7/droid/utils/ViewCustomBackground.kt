package lostankit7.droid.utils

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.RippleDrawable
import android.view.View

fun View.setCustomBackground(
    solidColor: Int,
    cornerRadius: Float = DEF_CORNER_RADIUS,
    strokeColor: Int = DEF_STROKE_COLOR,
    strokeWidth: Float = DEF_STROKE_WIDTH,
    showRipple: Boolean = DEF_SHOW_RIPPLE,
    rippleColor: Int = DEF_RIPPLE_COLOR,
    maskColor: Int = DEF_MASK_COLOR
): GradientDrawable {
    val drawable = GradientDrawable().also {
        it.cornerRadius = cornerRadius
        it.setColor(solidColor)
        it.setStroke(strokeWidth.toInt(), strokeColor)
    }
    background = if (showRipple) RippleDrawable(
        ColorStateList.valueOf(rippleColor),
        drawable,
        maskColor.getRippleMask(cornerRadius)
    ) else drawable
    return drawable
}

fun View.setGradientBackground(
    startColor: Int,
    endColor: Int,
    cornerRadius: Float = DEF_CORNER_RADIUS,
    strokeColor: Int = DEF_STROKE_COLOR,
    strokeWidth: Float = DEF_STROKE_WIDTH,
    gradDirection: GradientDrawable.Orientation = GradientDrawable.Orientation.LEFT_RIGHT,
    showRipple: Boolean = DEF_SHOW_RIPPLE,
    rippleColor: Int = DEF_RIPPLE_COLOR,
    maskColor: Int = DEF_MASK_COLOR
): GradientDrawable {
    val drawable = GradientDrawable(
        gradDirection,
        intArrayOf(startColor, endColor)
    ).also {
        it.cornerRadius = cornerRadius
        it.setStroke(strokeWidth.toInt(), strokeColor)
    }
    background = if (showRipple) RippleDrawable(
        ColorStateList.valueOf(rippleColor),
        drawable,
        maskColor.getRippleMask(cornerRadius)
    ) else drawable
    return drawable
}

fun View.setCircularBackground(
    solidColor: Int,
    strokeColor: Int = DEF_STROKE_COLOR,
    strokeWidth: Float = DEF_STROKE_WIDTH,
    showRipple: Boolean = DEF_SHOW_RIPPLE,
    rippleColor: Int = DEF_RIPPLE_COLOR,
    maskColor: Int = DEF_MASK_COLOR
): GradientDrawable {
    val drawable = GradientDrawable().also {
        it.shape = GradientDrawable.OVAL
        it.cornerRadii = floatArrayOf(0f, 0f, 0f, 0f, 0f, 0f, 0f, 0f)
        it.setColor(solidColor)
        it.setStroke(strokeWidth.toInt(), strokeColor)
    }
    background = if (showRipple) RippleDrawable(
        rippleColor.colorStateList(),
        drawable,
        maskColor.getCircularRippleMask()
    ) else drawable
    return drawable
}

