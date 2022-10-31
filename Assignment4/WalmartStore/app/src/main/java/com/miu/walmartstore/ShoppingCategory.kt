package com.miu.walmartstore


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategory : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)

        val shoppingCategoryIntent = intent
        txtViewUserName.text = shoppingCategoryIntent.getStringExtra("userName")
    }

    fun chooseCategory(view: View){
        var category = ""
        when(view.id){
            R.id.electronicsBtn -> category = "Electronics"
            R.id.clothingBtn -> category = "Clothing"
            R.id.beautyBtn -> category = "Beauty"
            R.id.foodBtn -> category = "Food"
        }
        Toast.makeText(this,"You have chosen the $category category of shopping", Toast.LENGTH_LONG).show()
    }
}