package lostankit7.droid.androidcustomview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import lostankit7.droid.utils.setCircularBackground
import lostankit7.droid.utils.setCustomBackground
import lostankit7.droid.utils.toDp

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}