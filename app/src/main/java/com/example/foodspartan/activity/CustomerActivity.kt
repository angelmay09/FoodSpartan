package com.example.foodspartan.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodspartan.R
import com.example.foodspartan.adapter.FoodAdapter
import com.example.foodspartan.adapter.UpdateFood
import com.example.foodspartan.domain.StoreDomain
import com.example.foodspartan.domain.FoodDomain
import com.example.foodspartan.domain.adapter.StoreAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CustomerActivity : AppCompatActivity(), UpdateFood {
    private lateinit var adapter: StoreAdapter
    private lateinit var recyclerViewStoreList: RecyclerView
    private lateinit var recyclerViewFoodList: RecyclerView
    private lateinit var adapter1 :  FoodAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        window.setBackgroundDrawableResource(android.R.color.white)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
        recyclerViewStore()
        recyclerViewFood()

        val cartClick = findViewById<FloatingActionButton>(R.id.cartshop)
        cartClick.setOnClickListener {
            val intent = Intent(this, CartActivity::class.java)
            startActivity(intent)
        }
    }

    private fun recyclerViewStore() {
        val linearLayoutManager=LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewStoreList=findViewById(R.id.recyclerView)
        recyclerViewStoreList.layoutManager = linearLayoutManager
        val store = ArrayList<StoreDomain>()
        store.add(StoreDomain(R.drawable.tender))
        store.add(StoreDomain(R.drawable.juice))
        store.add(StoreDomain(R.drawable.barista))
        store.add(StoreDomain(R.drawable.waffle))

        adapter = StoreAdapter(this@CustomerActivity, this, store)
        recyclerViewStoreList.adapter = adapter
    }

    private fun recyclerViewFood() {
        val linearLayoutManager=LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerViewFoodList=findViewById(R.id.recyclerViewFood)
        recyclerViewFoodList.layoutManager = linearLayoutManager
        val food = ArrayList<FoodDomain>()

        adapter1 = FoodAdapter(this,food)
        recyclerViewFoodList.adapter = adapter1
    }

    override fun callback(position: Int, list: ArrayList<FoodDomain>) {
        val foodAdapter = FoodAdapter(this@CustomerActivity,list)
        foodAdapter.notifyDataSetChanged()
        recyclerViewFoodList.adapter= foodAdapter
    }

}

