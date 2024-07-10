package com.example.foodspartan.domain.adapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.foodspartan.R
import com.example.foodspartan.domain.StoreDomain
import android.widget.ImageView
import com.example.foodspartan.activity.CustomerActivity
import com.example.foodspartan.domain.FoodDomain

class StoreAdapter(private val updatefood: CustomerActivity, private val activity: Activity, private val storeDomains: ArrayList<StoreDomain>) :
    RecyclerView.Adapter<StoreAdapter.ViewHolder>() {

    private var check = true
    private var select = true
    private var row_index = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.viewholder_store, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return storeDomains.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val storepic: ImageView = itemView.findViewById(R.id.storepic)
        val mainLayout: ConstraintLayout = itemView.findViewById(R.id.mainlayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val storeDomain = storeDomains[position]
        holder.storepic.setImageResource(storeDomain.getPicResourceId())
        val picUrl = when (position) {
            0 -> "tender"
            1 -> "barista"
            2 -> "juice"
            3 -> "waffle"
            else -> ""
        }
        val context:  Context = holder.itemView.context
        val drawableResourceId = context.resources.getIdentifier(
            picUrl, "drawable", context.packageName
        )
        holder.storepic.setImageResource(drawableResourceId)

        if (check) {
            val foods = ArrayList<FoodDomain>()
            foods.add(FoodDomain(R.drawable.images, "Hotdog Sandwich", 8, 35))
            foods.add(FoodDomain(R.drawable.images, "Chickendog Sandwich", 7, 55))
            foods.add(FoodDomain(R.drawable.images, "Pizza", 6, 83))
            foods.add(FoodDomain(R.drawable.images, "Siomai", 5, 92))

            updatefood.callback(holder.adapterPosition, foods)
            check = false
        }
            holder.mainLayout.setOnClickListener {
                row_index = holder.adapterPosition
                notifyDataSetChanged()


                if (position == 0) {
                    val foods = ArrayList<FoodDomain>()
                    foods.add(FoodDomain(R.drawable.images,"Hotdog Sandwich",8,35))
                    foods.add(FoodDomain(R.drawable.images,"Chickendog Sandwich",7,55))
                    foods.add(FoodDomain(R.drawable.images,"Pizza",6,83))
                    foods.add(FoodDomain(R.drawable.images,"Siomai",5,92))
                    updatefood.callback(position,foods);
                } else if (position == 1) {
                    val foods = ArrayList<FoodDomain>()
                    foods.add(FoodDomain(R.drawable.barista," Sandwich",8,35))
                    foods.add(FoodDomain(R.drawable.tender," Sandwich",7,55))
                    foods.add(FoodDomain(R.drawable.images,"Pizza",6,83))
                    foods.add(FoodDomain(R.drawable.images,"Siomai",5,92))
                    updatefood.callback(position,foods);
                } else if (position == 2) {
                    val foods = ArrayList<FoodDomain>()
                    foods.add(FoodDomain(R.drawable.waffle,"Burger",8,35))
                    foods.add(FoodDomain(R.drawable.tender," Sandwich",7,55))
                    foods.add(FoodDomain(R.drawable.images,"Pizza",6,83))
                    foods.add(FoodDomain(R.drawable.images,"Siomai",5,92))
                    updatefood.callback(position,foods);
                } else if (position == 3) {
                    val foods = ArrayList<FoodDomain>()
                    foods.add(FoodDomain(R.drawable.juice,"Ice Cream",8,35))
                    foods.add(FoodDomain(R.drawable.tender,"Buko Juuice",7,55))
                    foods.add(FoodDomain(R.drawable.images,"Pizza",6,83))
                    foods.add(FoodDomain(R.drawable.images,"Siomai",5,92))
                    updatefood.callback(position,foods);
                }
            }

            if (select) {
                if (position == 0){
                    holder.mainLayout.setBackgroundResource(R.drawable.changebg)
                    select = false
                }
            } else {
                if (row_index == position){
                    holder.mainLayout.setBackgroundResource(R.drawable.changebg)
                } else {
                    holder.mainLayout.setBackgroundResource(R.drawable.storeback)
                }
            }

    }
}


