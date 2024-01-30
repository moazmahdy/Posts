package com.example.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.domain.models.PostResponseItem
import com.example.ui.databinding.PostItemBinding

class PostAdapter(var list: List<PostResponseItem>?) : Adapter<PostAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = PostItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val post = list?.get(position)
        holder.item.titleTxv.text = post?.title
        holder.item.descTxv.text = post?.body
    }

    override fun getItemCount(): Int = list?.size!!

    class ViewHolder(val item: PostItemBinding) : RecyclerView.ViewHolder(item.root)

    fun changeList(posts: List<PostResponseItem>) {
        list = posts
    }
}