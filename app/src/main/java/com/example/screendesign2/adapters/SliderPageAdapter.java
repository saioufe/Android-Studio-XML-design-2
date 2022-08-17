package com.example.screendesign2.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;

import com.example.screendesign2.R;
import com.google.android.material.slider.Slider;

import java.util.List;
import java.util.Objects;

public class SliderPageAdapter extends RecyclerView.Adapter<SliderPageAdapter.ViewHolder> {
    int[] images;
    Context context;


    public SliderPageAdapter(Context context, int[] images){
        this.context = context;
        this.images = images;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View imageView = inflater.inflate(R.layout.slider_image_view, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(imageView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int image = images[position];

        // Set item views based on your views and data model
        ImageView imageView = holder.mainImage;
        Drawable drawable = context.getResources().getDrawable(image);
        imageView.setImageDrawable(drawable);

    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView mainImage;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mainImage = (ImageView) itemView.findViewById(R.id.imageViewMain);

    }
}
}
