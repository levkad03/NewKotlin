package com.example.lab9

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab9.databinding.PostsItemBinding
import android.content.Context


class PostsAdapter(var postsList:ArrayList<Posts>, private val context: Context):RecyclerView.Adapter<PostsAdapter.PostsViewHolder>() {
    class PostsViewHolder(val adapterBinding: PostsItemBinding):RecyclerView.ViewHolder(adapterBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = PostsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        holder.adapterBinding.textViewUserId.text = postsList[position].userId.toString()
        holder.adapterBinding.textViewId.text = postsList[position].id.toString()
        holder.adapterBinding.textViewTitle.text = postsList[position].title
        holder.adapterBinding.textViewBody.text = postsList[position].subtitle

        val post = postsList[position]
        holder.itemView.setOnClickListener {
            val data = "${post.title} - ${post.subtitle}\n"
            DataFileHelper.writeDataToFile(context, data)
        }
    }

    override fun getItemCount(): Int {
        return postsList.size
    }

}