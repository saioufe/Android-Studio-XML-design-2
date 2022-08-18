package com.example.screendesign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.screendesign2.adapters.PressedPageAdapter;
import com.example.screendesign2.adapters.SliderPageAdapter;

import java.util.ArrayList;
import java.util.List;

public class PressedActivity extends AppCompatActivity {
    LinearLayout sliderPressedDotspanel;
    private int dotscount;
    private ImageView[] dots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pressed);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        sliderPressedDotspanel = (LinearLayout) findViewById(R.id.SliderDotsSecond);

        ViewPager2 pressedViewPager;

        List<Integer> imagesSliders = new ArrayList<Integer>();
        imagesSliders.add(R.drawable.app_image1);
        imagesSliders.add( R.drawable.app_image2);
        imagesSliders.add(R.drawable.app_image3);


        // Creating Object of ViewPagerAdapter
        PressedPageAdapter pressedPageAdapter;


        pressedViewPager = (ViewPager2) findViewById(R.id.back_slider);

        pressedPageAdapter = new PressedPageAdapter(PressedActivity.this , imagesSliders);

        pressedViewPager.setAdapter(pressedPageAdapter);



        dotscount = imagesSliders.size();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_pressed_slider));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(4, 5, 4, 5);

            sliderPressedDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_pressed_slider));


        pressedViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_pressed_slider));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_pressed_slider));

            }

        });
    }
}