package lostankit7.droid.customview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import lostankit7.droid.utils.*
import lostankit7.droid.utils.DEF_BG_CIRCULAR
import lostankit7.droid.utils.DEF_CORNER_RADIUS
import lostankit7.droid.utils.NO_COLOR

/**
 * @property p change fontawesome icon type : from xml [icon_type] or updateTypeface(@FontAwesomeIconType),
 * border properties - [show_stroke] , [stroke_width], [stroke_color],
 * ripple effect on click - [show_ripple], [ripple_color], [mask_color],
 * background properties - [background_color] , [background_circular], [corner_radius]
 * @author AnkitKumar
 */
class FontAwesomeIcon
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) :
    AppCompatTextView(context, attrs, defStyleAttr) {

    init {
        val arr = context.obtainStyledAttributes(attrs, R.styleable.FontAwesomeIcon)
        manageAttributes(arr)
        arr.recycle()
    }

    private fun manageAttributes(arr: TypedArray) = with(arr) {

        try {
            updateTypeface(
                getInt(R.styleable.FontAwesomeIcon_icon_type, FontAwesomeIconType.REGULAR)
            )

            val bgColor = getColor(R.styleable.FontAwesomeIcon_background_color, NO_COLOR)

            val isBgCircular =
                getBoolean(R.styleable.FontAwesomeIcon_background_circular, DEF_BG_CIRCULAR)
            val cornerRadius =
                getDimension(R.styleable.FontAwesomeIcon_corner_radius, DEF_CORNER_RADIUS)

            val setStroke = getBoolean(R.styleable.FontAwesomeIcon_show_stroke, DEF_SET_STROKE)
            val strokeWidth =
                getDimension(R.styleable.FontAwesomeIcon_stroke_width, DEF_STROKE_WIDTH)
            val strokeColor = getColor(R.styleable.FontAwesomeIcon_stroke_color, DEF_STROKE_COLOR)

            val showRipple = getBoolean(R.styleable.FontAwesomeIcon_show_ripple, DEF_SHOW_RIPPLE)
            val rippleColor = getColor(R.styleable.FontAwesomeIcon_ripple_color, DEF_RIPPLE_COLOR)
            val maskColor = getColor(R.styleable.FontAwesomeIcon_mask_color, DEF_MASK_COLOR)

            if(!setStroke && !showRipple) return@with

            if (isBgCircular) setCircularBackground(
                bgColor, strokeColor, strokeWidth, showRipple, rippleColor, maskColor
            ) else
                setCustomBackground(
                    bgColor, cornerRadius, strokeColor, strokeWidth,
                    showRipple, rippleColor, maskColor
                )

        } catch (e: Exception) {
        }
    }
}
