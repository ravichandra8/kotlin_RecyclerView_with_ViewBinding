package com.ravi.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ravi.myapplication.databinding.HeaderBinding
import com.ravi.myapplication.databinding.ItemBinding
import java.lang.RuntimeException

class RecyclerViewAdapter(private val data: ArrayList<String?>) : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private val TypeHeader:Int = 1;
    private val TypeItem:Int =2;


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val headerBinding:HeaderBinding = HeaderBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        val itemBinding:ItemBinding = ItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        if (viewType == TypeItem){
          return  ViewItem(itemBinding,data)
        }else if(viewType == TypeHeader){
            return ViewHeader(headerBinding,data)
        }
        return throw RuntimeException("something went wrong")
    }

    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      if(holder is ViewHeader){
            holder.bind(position)
      } else if(holder is ViewItem){
       holder.bind(position)
      }
    }

    override fun getItemViewType(position: Int): Int {
         if(data.get(position).equals("recent")|| data.get(position).equals("New")){
            return TypeHeader
        }
        return TypeItem
    }
    class ViewHeader(headerBinding: HeaderBinding,private val data: ArrayList<String?>) : RecyclerView.ViewHolder(headerBinding.root){

        private val headerBinding: HeaderBinding = headerBinding

        fun bind(position:Int){
            headerBinding.header.text = data.get(position).toString()
        }
    }

    class ViewItem(itemBinding: ItemBinding,private val data: ArrayList<String?>) : RecyclerView.ViewHolder(itemBinding.root){

        private val itemBinding: ItemBinding = itemBinding
      fun bind(position: Int) {
        itemBinding.footer.text = data.get(position)
      }

    }

}