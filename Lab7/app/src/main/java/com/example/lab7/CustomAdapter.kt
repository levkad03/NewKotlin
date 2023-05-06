package com.example.lab7

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class CustomAdapter (
    private val mList: List<ItemData>,
    private val onItemClick:(position:Int)->Unit
):RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    class ViewHolder(private val ItemView: View, private val onItemClick: (position: Int) -> Unit
    ):RecyclerView.ViewHolder(ItemView){

        init {
            itemView.setOnClickListener {
                onItemClick(adapterPosition)
            }
        }

        val textView: TextView = itemView.findViewById(R.id.textView)
        val imageView: ImageView = itemView.findViewById(R.id.imageview)
        val imageView2: ImageView = itemView.findViewById(R.id.imageview2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_view_design, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val ItemData = mList[position]

        holder.textView.text = ItemData.title

        Glide.with(holder.itemView.context)
            .load(ItemData.image1)
            .into(holder.imageView)


        Glide.with(holder.itemView.context)
            .load(ItemData.image2)
            .into(holder.imageView2)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

}