package edu.uw.ischool.harmaz.biggobutton

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random
import android.content.res.ColorStateList


class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private var clickCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        button = findViewById(R.id.BigGoButton)

        button.setOnClickListener {
            updateButton()
        }
    }

    private fun updateButton() {
        clickCount++
        val buttonText = if (clickCount == 1) {
            getString(R.string.pushed_once)
        } else {
            getString(R.string.pushed_multiple, clickCount)
        }
        button.text = buttonText

        button.backgroundTintList = ColorStateList.valueOf(randomColor())
        button.setTextColor(randomColor())
    }

    private fun randomColor(): Int {
        val random = Random
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }

}
