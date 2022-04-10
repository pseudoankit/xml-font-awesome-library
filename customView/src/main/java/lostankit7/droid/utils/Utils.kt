package lostankit7.droid.utils

import android.graphics.Color
import android.widget.TextView
import lostankit7.droid.customview.FontAwesomeIconType
import lostankit7.droid.customview.FontCache

internal const val NO_COLOR = Color.TRANSPARENT

internal const val DEF_CORNER_RADIUS = 8f
internal const val DEF_BG_CIRCULAR = true

internal const val DEF_SET_STROKE = false
internal const val DEF_STROKE_COLOR = Color.BLUE
internal const val DEF_STROKE_WIDTH = 3f

internal const val DEF_SHOW_RIPPLE = false
internal const val DEF_RIPPLE_COLOR = Color.LTGRAY
internal const val DEF_MASK_COLOR = Color.GRAY

fun TextView.updateTypeface(@FontAwesomeIconType iconType: Int) {
    typeface = when (iconType) {
        FontAwesomeIconType.BRAND -> FontCache[context, FontCache.faBrandIcon]
        FontAwesomeIconType.SOLID -> FontCache[context, FontCache.faSolidIcon]
        else -> FontCache[context, FontCache.faRegularIcon]
    }
}