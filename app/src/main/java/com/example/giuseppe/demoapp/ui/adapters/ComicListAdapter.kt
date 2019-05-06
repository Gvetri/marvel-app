package com.example.giuseppe.demoapp.ui.adapters

import android.support.constraint.ConstraintLayout
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.giuseppe.demoapp.R
import com.example.giuseppe.demoapp.domain.model.ComicDataEntity

class ComicListAdapter(
    private val listener: ComicListAdapter.OnClickListener
) : RecyclerView.Adapter<ComicListAdapter.MyViewHolder>() {

    private var comicList = mutableListOf<ComicDataEntity>()


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvComicName: TextView = itemView.findViewById(R.id.tv_title)
        var tvComicPicture: ImageView = itemView.findViewById(R.id.iv_thumbnail)
        var clContainer: ConstraintLayout = itemView.findViewById(R.id.cl_container)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.comic_row, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvComicName.text = comicList[position].title ?: ""
        Glide.with(holder.itemView.context)
            .load((comicList[position].thumbnail?.path ?: "") + "." + (comicList[position].thumbnail?.extension ?: ""))
            .into(holder.tvComicPicture)
        holder.clContainer.setOnClickListener { comicList[position].let { Comic -> listener.onClickItemListener(Comic) } }
    }

    override fun getItemCount(): Int {
        return comicList.size
    }

    fun setComics(list: MutableList<ComicDataEntity>) {
        comicList.clear()
        comicList.addAll(list)
        notifyDataSetChanged()
    }

    interface OnClickListener {
        fun onClickItemListener(comic: ComicDataEntity)
    }
}