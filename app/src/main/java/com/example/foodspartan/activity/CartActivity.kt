package com.example.foodspartan.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodspartan.R
import com.example.foodspartan.adapter.CartAdapter
import com.example.foodspartan.domain.CartDomain

class CartActivity : AppCompatActivity() {

    private lateinit var cartAdapter: CartAdapter
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        window.setBackgroundDrawableResource(android.R.color.white)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)

        recyclerView = findViewById(R.id.cart)
        recyclerViewCart()
    }

    private fun recyclerViewCart() {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager

        val list = ArrayList<CartDomain>()
        list.add(CartDomain((R.drawable.images), "Hotdog", "3", "99"))
        list.add(CartDomain((R.drawable.images), "Ice Cream", "6", "949"))
        list.add(CartDomain((R.drawable.images), "Burger", "8", "997"))

        cartAdapter = CartAdapter(list)
        recyclerView.adapter = cartAdapter
    }
}