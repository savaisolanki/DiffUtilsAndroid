package com.example.diffutilsapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.diffutilsapplication.databinding.DiffUtilsRecyclerViewDataBinding
import com.example.diffutilsapplication.`interface`.RecyclerItemClick
import com.example.diffutilsapplication.model.DiffUtilsModel
import java.util.zip.Inflater

class DiffUtilsAdapter(private val context: Context,private var listner:RecyclerItemClick): ListAdapter <DiffUtilsModel, DiffUtilsAdapter.DiffUtilsViewHolder>(DiffUtils()) {

    private lateinit var binding:DiffUtilsRecyclerViewDataBinding

    inner class DiffUtilsViewHolder(binding: DiffUtilsRecyclerViewDataBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(position: Int){

            binding.tvItemName.text=getItem(position).itemName
            binding.tvItemWork.text=getItem(position).itemWork


            binding.root.setOnClickListener {
                listner.itemClick(position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiffUtilsViewHolder {
        binding= DiffUtilsRecyclerViewDataBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  DiffUtilsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: DiffUtilsViewHolder, position: Int) {

        holder.bind(position)

 /*       binding.root.setOnClickListener {
            Toast.makeText(context, "Data $position", Toast.LENGTH_SHORT).show()
        }
*/

    }
    class DiffUtils:DiffUtil.ItemCallback<DiffUtilsModel>(){
        override fun areItemsTheSame(oldItem: DiffUtilsModel, newItem: DiffUtilsModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DiffUtilsModel, newItem: DiffUtilsModel): Boolean {
            return oldItem == newItem
        }

    }

}