package com.example.a08_recyclerview

import android.annotation.SuppressLint
import android.media.Image.Plane
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.a08_recyclerview.databinding.PlaneItemBinding

class PlaneAdapter: RecyclerView.Adapter<PlaneAdapter.PlaneHolder>() {
    val planeList=ArrayList<Plains>()
    class PlaneHolder(item:View):RecyclerView.ViewHolder(item) {
        val binding=PlaneItemBinding.bind(item)
        fun bind(plane:Plains)= with(binding){
            imageView.setImageResource(plane.imageId)
            tvText.text=plane.title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaneHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.plane_item,parent,false)
        return PlaneHolder(view)
    }

    override fun getItemCount(): Int {
        return planeList.size
    }

    override fun onBindViewHolder(holder: PlaneHolder, position: Int) {
        holder.bind(planeList[position])
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addPlant(plant:Plains){
        planeList.add(plant)
        notifyDataSetChanged()
    }
}