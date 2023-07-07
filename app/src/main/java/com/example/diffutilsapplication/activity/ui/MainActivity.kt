package com.example.diffutilsapplication.activity.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.diffutilsapplication.R
import com.example.diffutilsapplication.adapter.DiffUtilsAdapter
import com.example.diffutilsapplication.databinding.ActivityMainBinding
import com.example.diffutilsapplication.`interface`.RecyclerItemClick
import com.example.diffutilsapplication.model.DiffUtilsModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        //Click event In Recyclerview Adapter
        /*
                val diffUtilsModel: MutableList<DiffUtilsModel> = mutableListOf()

                diffUtilsModel.apply {
                    add(DiffUtilsModel("1", "Android", "Coding"))
                    add(DiffUtilsModel("2", "C", "Coding"))
                    add(DiffUtilsModel("3", "c++", "Coding"))
                    add(DiffUtilsModel("4", "java", "Coding"))
                    add(DiffUtilsModel("5", "kotlin", "Coding"))
                    add(DiffUtilsModel("6", "node", "Coding"))
                    add(DiffUtilsModel("7", "React", "Coding"))
                    add(DiffUtilsModel("8", "html", "Coding"))
                    add(DiffUtilsModel("9", "css", "Coding"))
                    add(DiffUtilsModel("10", "javascript", "Coding"))
                }


                val adapter = DiffUtilsAdapter(this)
                adapter.submitList(diffUtilsModel)
                binding.rvRecyclerView.adapter = adapter

        */

        //Click event using Interface


        var diffUtilsModel: List<DiffUtilsModel> = listOf(
            DiffUtilsModel("1", "Android", "Coding1"),
            DiffUtilsModel("2", "C", "Coding2"),
            DiffUtilsModel("3", "c++", "Coding3"),
            DiffUtilsModel("4", "java", "Coding4"),
            DiffUtilsModel("5", "kotlin", "Coding5"),
            DiffUtilsModel("6", "node", "Coding6"),
            DiffUtilsModel("7", "React", "Coding7"),
            DiffUtilsModel("8", "html", "Coding8"),
            DiffUtilsModel("9", "css", "Coding9"),
            DiffUtilsModel("10", "javascript", "Coding10")
        )

        val adapter = DiffUtilsAdapter(this, object : RecyclerItemClick {
            override fun itemClick(position: Int) {
                Toast.makeText(
                    this@MainActivity,
                    "Hello Data Name ${diffUtilsModel[position].itemName}",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })

        adapter.submitList(diffUtilsModel)
        binding.rvRecyclerView.adapter = adapter

        Handler(Looper.myLooper()!!).postDelayed(Runnable {
            diffUtilsModel = listOf(
                DiffUtilsModel("1", "Ruby", "Coding1"),
                DiffUtilsModel("2", "Laravel", "Coding2"),
                DiffUtilsModel("3", "python", "Coding3"),
                DiffUtilsModel("4", "PHP", "Coding4")
            )
            adapter.submitList(diffUtilsModel)
        }, 3000)


    }
}