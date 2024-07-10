package com.example.foodspartan.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodspartan.R
import com.example.foodspartan.domain.StoreDomain
import com.example.foodspartan.domain.adapter.StoreAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: StoreAdapter
    private lateinit var recyclerViewStoreList: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        window.setBackgroundDrawableResource(android.R.color.white)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerViewStore()
    }

    private fun recyclerViewStore() {
        val linearLayoutManager=LinearLayoutManager (this, LinearLayoutManager.VERTICAL, false)
        recyclerViewStoreList=findViewById(R.id.recyclerView)
        recyclerViewStoreList.layoutManager = linearLayoutManager
        val store = ArrayList<StoreDomain>()
        store.add(StoreDomain(R.drawable.tender))
        store.add(StoreDomain(R.drawable.juice))
        store.add(StoreDomain(R.drawable.barista))
        store.add(StoreDomain(R.drawable.waffle))

        recyclerViewStoreList.adapter = adapter
    }
}