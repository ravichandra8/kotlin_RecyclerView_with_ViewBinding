package com.ravi.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.ravi.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var linearLayoutManager: LinearLayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityMainBinding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        linearLayoutManager = LinearLayoutManager(this)
        binding.rv.layoutManager = linearLayoutManager

        val recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter(MainActivity.getData())
        binding.rv.adapter = recyclerViewAdapter
    }

    companion object{
        private fun getData() : ArrayList<String?>{
            val hashmap: ArrayList<String?> = ArrayList<String?>()

            hashmap.add("recent")
            hashmap.add("body recent")
            hashmap.add("body recent")
            hashmap.add("body recent")
            hashmap.add("body recent")
            hashmap.add("body recent")
            hashmap.add("body recent")
            hashmap.add("body recent")
            hashmap.add("body recent")
            hashmap.add("New")
            hashmap.add("New body")
            hashmap.add("New body")
            hashmap.add("New body")
            hashmap.add("New body")
            hashmap.add("New body")
            hashmap.add("New body")
            hashmap.add("New body")
            hashmap.add("New body")
            hashmap.add("New body")
            hashmap.add("New body")
            hashmap.add("New body")
            hashmap.add("New body")
            hashmap.add("New body")
            return hashmap
        }
    }
}