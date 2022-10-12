package com.example.screendesign2

import androidx.appcompat.app.AppCompatActivity
import android.widget.LinearLayout
import android.widget.TextView
import android.os.Bundle
import com.example.screendesign2.R
import android.content.Intent
import android.os.Build
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.screendesign2.adapters.PressedPageAdapter
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import java.util.ArrayList

class PressedActivity : AppCompatActivity() {
    var sliderPressedDotspanel: LinearLayout? = null
    private var dotscount = 0
    private lateinit var dots: Array<ImageView?>
    lateinit var  mainText: TextView
    var messageFromIntent: String? = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pressed)
        mainText = findViewById(R.id.second_page_titles)
        val intent = intent
        messageFromIntent = intent.getStringExtra("Title")
        mainText.setText("Discover $messageFromIntent")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        sliderPressedDotspanel = findViewById<View>(R.id.SliderDotsSecond) as LinearLayout
        val pressedViewPager: ViewPager2
        val imagesSliders: MutableList<Int> = ArrayList()
        imagesSliders.add(R.drawable.app_image1)
        imagesSliders.add(R.drawable.app_image2)
        imagesSliders.add(R.drawable.app_image3)


        // Creating Object of ViewPagerAdapter
        val pressedPageAdapter: PressedPageAdapter
        pressedViewPager = findViewById<View>(R.id.back_slider) as ViewPager2
        pressedPageAdapter = PressedPageAdapter(this@PressedActivity, imagesSliders)
        pressedViewPager.adapter = pressedPageAdapter
        dotscount = imagesSliders.size
        dots = arrayOfNulls(dotscount)
        for (i in 0 until dotscount) {
            dots[i] = ImageView(this)
            dots[i]!!.setImageDrawable(
                ContextCompat.getDrawable(
                    applicationContext,
                    R.drawable.non_active_pressed_slider
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(4, 5, 4, 5)
            sliderPressedDotspanel!!.addView(dots[i], params)
        }
        dots[0]!!.setImageDrawable(
            ContextCompat.getDrawable(
                applicationContext,
                R.drawable.active_pressed_slider
            )
        )
        pressedViewPager.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                for (i in 0 until dotscount) {
                    dots[i]!!
                        .setImageDrawable(
                            ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.non_active_pressed_slider
                            )
                        )
                }
                dots[position]!!
                    .setImageDrawable(
                        ContextCompat.getDrawable(
                            applicationContext,
                            R.drawable.active_pressed_slider
                        )
                    )
            }
        })
    }
}