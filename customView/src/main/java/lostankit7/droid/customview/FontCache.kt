package lostankit7.droid.customview

import android.content.Context
import android.graphics.Typeface
import java.util.*

object FontCache {
        const val faBrandIcon = "fonts/FaBrand5.ttf"
        const val faSolidIcon = "fonts/FaSolid5.ttf"
        const val faRegularIcon = "fonts/FaRegular5.ttf"

        private val fontCache: Hashtable<String, Typeface> = Hashtable()

        operator fun get(context: Context, name: String?): Typeface? {
            var typeface: Typeface? = fontCache[name]
            if (typeface == null) {
                typeface = try {
                    Typeface.createFromAsset(context.assets, name)
                } catch (e: Exception) {
                    return null
                }
                fontCache[name] = typeface
            }
            return typeface
        }
    }