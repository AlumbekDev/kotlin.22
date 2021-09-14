package com.example.kotlin2.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlin2.databinding.ImageLayoutBinding
import com.squareup.picasso.Picasso

class PhotoAdapter() :
    RecyclerView.Adapter<PhotoAdapter.MyViewHolder>() {
    lateinit var binding: ImageLayoutBinding

    private var list: List<String> = ArrayList()

    fun addList(getList: List<String>){
        list = getList
        notifyDataSetChanged()
    }

    inner class MyViewHolder(root: View) : RecyclerView.ViewHolder(root){
        fun onBind(s: String) {
            Picasso.get ()
                .load (s)
                .resize (200, 200)
                .into (binding.img)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        binding = ImageLayoutBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return MyViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int = list.size
}