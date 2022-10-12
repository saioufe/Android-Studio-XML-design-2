package com.example.screendesign2.adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.screendesign2.R
import android.widget.TextView
import com.example.screendesign2.data.Slider

class SliderPageAdapter(var context: Context, var sliders: List<Slider>) :
    RecyclerView.Adapter<SliderPageAdapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(context)

        // Inflate the custom layout
        val imageView =
            inflater.inflate(R.layout.slider_image_view, parent, false)

        // Return a new holder instance
        return ViewHolder(imageView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = sliders[position].image
        val title = sliders[position].title
        val subTitle = sliders[position].subTitle

        // Set item views based on your views and data model
        val imageView = holder.mainImage
        val drawable = context.resources.getDrawable(image)
        imageView.setImageDrawable(drawable)
        val mainTextTitle = holder.mainTextTitle
        mainTextTitle.text = title
        val mainTextSubTitle = holder.mainTextSubTitle
        mainTextSubTitle.text = subTitle
    }

    override fun getItemCount(): Int {
        return sliders.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mainImage: ImageView
        var mainTextTitle: TextView
        var mainTextSubTitle: TextView

        init {
            mainImage = itemView.findViewById<View>(R.id.imageViewMain) as ImageView
            mainTextTitle = itemView.findViewById<View>(R.id.textViewMain) as TextView
            mainTextSubTitle = itemView.findViewById<View>(R.id.textViewSubTitle) as TextView
        }
    }
}