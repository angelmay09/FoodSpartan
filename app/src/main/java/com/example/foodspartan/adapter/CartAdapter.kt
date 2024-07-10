package com.example.foodspartan.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodspartan.R
import com.example.foodspartan.domain.CartDomain

class CartAdapter(private val list: List<CartDomain>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.cart_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.imageView.setImageResource(item.getImage())
        holder.name.text = item.getName()
        holder.avail.text = item.getAvail()
        holder.price.text = item.getPrice()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.itemimage)
        val name: TextView = itemView.findViewById(R.id.itemname)
        val avail: TextView = itemView.findViewById(R.id.itemavail)
        val price: TextView = itemView.findViewById(R.id.itemprice)
    }
}
