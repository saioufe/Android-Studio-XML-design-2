package com.example.screendesign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.screendesign2.adapters.PressedPageAdapter;
import com.example.screendesign2.adapters.SliderPageAdapter;
import com.example.screendesign2.data.Slider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {


    LinearLayout sliderDotspanel;
    private int dotscount;
    private ImageView[] dots;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);

        // creating object of ViewPager
        ViewPager2 mViewPager;



        // sliders array

        List<Slider> sliders = new ArrayList<Slider>();
        sliders.add(new Slider(R.drawable.app_image1 , "Baghdad Tower" , "Larges tower in baghdad"));
        sliders.add(new Slider(R.drawable.app_image2 , "Central Bank of Baghdad" , "Illustration image for the bank"));
        sliders.add(new Slider(R.drawable.app_image3 , "Zoha Hadded Design" , "The first design for Zoha"));


        List<Integer> imagesSliders = new ArrayList<Integer>();
        imagesSliders.add(R.drawable.app_image1);
        imagesSliders.add( R.drawable.app_image2);
        imagesSliders.add(R.drawable.app_image3);


        // Creating Object of ViewPagerAdapter
        SliderPageAdapter sliderPageAdapter;
        PressedPageAdapter pressedPageAdapter;


        Toolbar toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle("");
        toolbar.setBackgroundColor(getResources().getColor(R.color.white , getResources().newTheme()));
        setSupportActionBar(toolbar);

        // Initializing the ViewPager Object
        mViewPager = (ViewPager2) findViewById(R.id.pager_slider);


        // Initializing the ViewPagerAdapter
        sliderPageAdapter = new SliderPageAdapter(MainActivity.this, sliders);



        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(sliderPageAdapter);



        dotscount = sliders.size();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){

            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_slider_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(4, 5, 4, 5);

            sliderDotspanel.addView(dots[i], params);

        }

        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_slider_dot));

        mViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                for(int i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.non_active_slider_dot));
                }

                dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_slider_dot));

            }

        });



        List<View> shapes = new ArrayList<>();

        Button button1 = findViewById(R.id.first_button);
        Button button2 = findViewById(R.id.second_button);
        Button button3 = findViewById(R.id.third_button);
        Button button4 = findViewById(R.id.fourth_button);


        View shape1 = findViewById(R.id.first_shape);
        shapes.add(shape1);
        View shape2 = findViewById(R.id.second_shape);
        shapes.add(shape2);
        View shape3 = findViewById(R.id.third_shape);
        shapes.add(shape3);
        View shape4 = findViewById(R.id.fourth_shape);
        shapes.add(shape4);


        AtomicReference<View> visiableShape = new AtomicReference<>(shape1);
        shape1.setVisibility(View.VISIBLE);


        button1.setOnClickListener(view -> {
            shape1.setVisibility(View.VISIBLE);
            visiableShape.set(view);
            turnOfTheOthers(shapes , shape1);

        });
        button2.setOnClickListener(view -> {
            shape2.setVisibility(View.VISIBLE);
            visiableShape.set(view);
            turnOfTheOthers(shapes , shape2);
            startActivity(new Intent(this, PressedActivity.class));
        });
        button3.setOnClickListener(view -> {
            shape3.setVisibility(View.VISIBLE);
            visiableShape.set(view);
            turnOfTheOthers(shapes , shape3);
        });
        button4.setOnClickListener(view -> {
            shape4.setVisibility(View.VISIBLE);
            visiableShape.set(view);
            turnOfTheOthers(shapes , shape4);
        });





    }

    private void turnOfTheOthers(List<View> shapes , View visiableShape) {
        for (int i = 0; i < shapes.size(); i++) {
            if(visiableShape != shapes.get(i)){
                shapes.get(i).setVisibility(View.INVISIBLE);
            }
        }
    }
}