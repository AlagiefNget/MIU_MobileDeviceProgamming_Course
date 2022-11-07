package edu.miu.walmartlogin.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import edu.miu.walmartlogin.R
import edu.miu.walmartlogin.adapter.CategoryAdapter
import edu.miu.walmartlogin.data.Product
import edu.miu.walmartlogin.databinding.ActivityElectronicsItemBinding

class ElectronicsCategoryActivity : AppCompatActivity(), CategoryAdapter.Callback {

    private lateinit var binding: ActivityElectronicsItemBinding

    private val productList = mutableListOf(
        Product("RCA Voyager 7\" 16GB android tablet", "$35", "Black", R.drawable.tablet, 13224L, "The sleek, lightweight, and affordable Moxee Tablet 2, powered by 4G LTE, is perfectly designed for your mobile life. The Moxee Tablet 2 is the perfect size for movies, games, browsing, and getting caught up with work. And it will always be there for you with its great battery life and LTE connectivity."),
        Product("HP Flyer Red 15.6 \" Laptop", "$299", "Black & Red", R.drawable.laptop, 1236L, "Nice laptop Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the "),
        Product("Vizio 70\" class 4K", "$1298", "Black", R.drawable.tv, 1234L, "1080p High-Definition - Watch TV in crisp, clear 1080p Full HD resolution. Full Array LED Backlight - Evenly distributed LEDs across the screen’s backlight deliver superior light uniformity and picture performance."),
        Product("EPSON workforce WF-2750", "$69", "Black", R.drawable.printer, 1235L, "Nice Scanner Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the .")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElectronicsItemBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CategoryAdapter(this, productList)
        adapter.setCallback(this)
        recyclerView.adapter = adapter
    }

    override fun onItemClicked(product: Product?) {
        val intent = Intent(this, ElectronicsDetailActivity::class.java)
        intent.putExtra("product", product)
        startActivity(intent)
    }
}