package com.example.screendesign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.screendesign2.adapters.SliderPageAdapter;
import com.example.screendesign2.data.Slider;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creating object of ViewPager
        ViewPager2 mViewPager;

        // sliders array

        List<Slider> sliders = new ArrayList<Slider>();
        sliders.add(new Slider(R.drawable.app_image1 , "Baghdad Tower" , "Larges tower in baghdad"));
        sliders.add(new Slider(R.drawable.app_image2 , "Central Bank of Baghdad" , "Illustration image for the bank"));
        sliders.add(new Slider(R.drawable.app_image3 , "Zoha Hadded Design" , "The first design for Zoha"));


        // Creating Object of ViewPagerAdapter
        SliderPageAdapter sliderPageAdapter;


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