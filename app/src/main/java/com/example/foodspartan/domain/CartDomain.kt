package com.example.foodspartan.domain

class CartDomain( private val image: Int,
                  private var name: String,
                  private var avail: String,
                  private var price: String) {

    fun getImage() : Int {
        return image
    } fun getName() : String {
        return name
    } fun getAvail() : String {
        return avail
    } fun getPrice() : String {
        return price
    }
}