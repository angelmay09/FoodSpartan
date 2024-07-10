package com.example.foodspartan.adapter

import android.content.Context
import com.example.foodspartan.domain.FoodDomain
import com.example.foodspartan.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog

class FoodAdapter(private val context: Context,private val foodDomain: ArrayList<FoodDomain>):
    RecyclerView.Adapter<FoodAdapter.ViewHolder>() {

    private var bottomsheetdialog: BottomSheetDialog? = null

    override fun onCreateViewHolder(parent: ViewGroup, position:Int) : ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.scroll_menu,parent,false)
        return ViewHolder(itemView)
    }
    override fun getItemCount() : Int {
        return foodDomain.size
    }

    override fun onBindViewHolder(holder:ViewHolder, position:Int) {
        val food = foodDomain[position]

        val  mname:String = food.getName()
        val  mavail:String = food.getAvail().toString()
        val  mprice:String = food.getPrice().toString()
        val  mimage: Int = food.getImage()

        holder.image.setImageResource(food.getImage())
        holder.name.text = food.getName()
        holder.avail.text= food.getAvail().toString()
        holder.price.text= food.getPrice().toString()

        holder.itemView.setOnClickListener {
            val dialog = BottomSheetDialog(context, R.style.BottomSheetTheme)
            val sheetView = LayoutInflater.from(context).inflate(R.layout.cartadd, null)
            sheetView.findViewById<Button>(R.id.addbutton).setOnClickListener {
                Toast.makeText(context, "Added to a Cart", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }
            val cImg: ImageView = sheetView.findViewById(R.id.itemimage)
            val cname: TextView = sheetView.findViewById(R.id.itemname)
            val cavail: TextView = sheetView.findViewById(R.id.itemavail)
            val cprice: TextView = sheetView.findViewById(R.id.itemprice)

            cname.setText(mname)
            cavail.setText(mavail)
            cprice.setText(mprice)
            cImg.setImageResource(mimage)

            dialog.setContentView(sheetView)
            dialog.show()

            val picUrl = when (position) {
                0 -> "images"
                1 -> "images"
                2 -> "images"
                3 -> "images"
                else -> ""
            }
            val drawableResourceId = context.resources.getIdentifier(
                picUrl, "drawable", context.packageName
            )
            holder.image.setImageResource(drawableResourceId)
        }
    }

    inner class ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image:ImageView = itemView.findViewById(R.id.food_img)
        val name:TextView = itemView.findViewById(R.id.food_name)
        val avail:TextView = itemView.findViewById(R.id.food_avail)
        val price:TextView = itemView.findViewById(R.id.food_price)
        val card:ConstraintLayout = itemView.findViewById(R.id.foodCard)
    }
}