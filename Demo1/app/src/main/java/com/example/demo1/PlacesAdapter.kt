package com.example.demo1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row_places.view.*


class PlacesAdapter : RecyclerView.Adapter<PlacesAdapter.ItemHolder> {

    companion object {
        var clickListener: ClickListener? = null
    }

    interface ClickListener {
        fun onItemClick(position: Int, v: View)
    }

    fun setOnItemClickListener(clickListener: ClickListener?) {
        PlacesAdapter.clickListener = clickListener!!
    }

    var list: ArrayList<Places>

    constructor(list: ArrayList<Places>) : super() {
        this.list = list
    }

    class ItemHolder : RecyclerView.ViewHolder, View.OnClickListener {

        var img_places: ImageView
        var text_title: TextView
        var text_date: TextView

        constructor(itemView: View) : super(itemView) {
            img_places = itemView.img_places
            text_title = itemView.text_title
            text_date = itemView.text_date

            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            clickListener!!.onItemClick(adapterPosition, v!!)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        var v: View = LayoutInflater.from(parent.context).inflate(R.layout.row_places, parent, false)
        var itemHolder = ItemHolder(v)

        return itemHolder
    }

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        var item = list.get(holder.adapterPosition)
        holder.img_places.setImageResource(item.img)
        holder.text_title.text = item.title
        holder.text_date.text = item.date
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int {
        return list.size
    }

}
