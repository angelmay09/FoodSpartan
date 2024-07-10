package com.example.foodspartan.domain

class FoodDomain (private val image:Int,
                  private val name: String,
                  private val availability:Int,
                  private val price:Int) {


    fun getImage (): Int {
        return image
    }fun getName():String {
        return name
    } fun getAvail():Int {
        return availability
    } fun getPrice(): Int {
        return price
    }
}