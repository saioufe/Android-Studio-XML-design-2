package com.example.screendesign2.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.screendesign2.R;
import com.example.screendesign2.data.Slider;


import java.util.List;

public class SliderPageAdapter extends RecyclerView.Adapter<SliderPageAdapter.ViewHolder> {
    List<Slider> sliders;
    Context context;


    public SliderPageAdapter(Context context, List<Slider> sliders){
        this.context = context;
        this.sliders = sliders;
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
        int image = sliders.get(position).getImage();
        String title = sliders.get(position).getTitle();
        String subTitle = sliders.get(position).getSubTitle();

        // Set item views based on your views and data model
        ImageView imageView = holder.mainImage;
        Drawable drawable = context.getResources().getDrawable(image);
        imageView.setImageDrawable(drawable);

        TextView mainTextTitle = holder.mainTextTitle;
        mainTextTitle.setText(title);

        TextView mainTextSubTitle = holder.mainTextSubTitle;
        mainTextSubTitle.setText(subTitle);


    }

    @Override
    public int getItemCount() {
        return sliders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView mainImage;
    public TextView mainTextTitle;
    public TextView mainTextSubTitle;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);
        mainImage = (ImageView) itemView.findViewById(R.id.imageViewMain);
        mainTextTitle = (TextView) itemView.findViewById(R.id.textViewMain);
        mainTextSubTitle = (TextView) itemView.findViewById(R.id.textViewSubTitle);

    }
}
}
