package com.example.screendesign2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toolbar toolbar = findViewById(R.id.main_toolbar);
        toolbar.setTitle("");
        toolbar.setBackgroundColor(getResources().getColor(R.color.white , getResources().newTheme()));
        setSupportActionBar(toolbar);

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