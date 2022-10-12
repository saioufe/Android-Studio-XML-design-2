package com.example.screendesign2.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.screendesign2.R

class PressedPageAdapter(var context: Context, var sliders: List<Int>) :
    RecyclerView.Adapter<PressedPageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val imageView =
            inflater.inflate(R.layout.pressed_image_view, parent, false)

        // Return a new holder instance
        return ViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = sliders[position]

        // Set item views based on your views and data model
        val imageView = holder.mainImage
        val drawable = context.resources.getDrawable(image)
        imageView.setImageDrawable(drawable)
    }

    override fun getItemCount(): Int {
        return sliders.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mainImage: ImageView

        init {
            mainImage = itemView.findViewById<View>(R.id.pressedImageView) as ImageView
        }
    }
}