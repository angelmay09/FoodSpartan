package com.example.foodspartan.adapter

import com.example.foodspartan.domain.FoodDomain

interface UpdateFood {

    fun callback (position:Int, list: ArrayList<FoodDomain> )

}