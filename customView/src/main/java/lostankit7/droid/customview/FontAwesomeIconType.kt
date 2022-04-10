package lostankit7.droid.customview

import androidx.annotation.IntDef

@IntDef(FontAwesomeIconType.REGULAR, FontAwesomeIconType.SOLID, FontAwesomeIconType.BRAND)
        @Retention(AnnotationRetention.SOURCE)
        annotation class FontAwesomeIconType {
            companion object {
                const val REGULAR = 0
                const val SOLID = 1
                const val BRAND = 2
            }
        }