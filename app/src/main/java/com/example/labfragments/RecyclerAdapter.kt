package com.example.labfragments

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter(
    val users: ArrayList<User>,
    val context: Context
): RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(view,context)
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = users.get(position)
        holder.nameText.text = user.name
        holder.positionText.text = user.position
    }

    class MyViewHolder(view: View, context: Context):RecyclerView.ViewHolder(view){
        var nameText: TextView = view.findViewById(R.id.name)
        var positionText: TextView = view.findViewById(R.id.position)
        var imageView: ImageView = view.findViewById(R.id.image)

        init {
            view.setOnClickListener{
                view.findNavController().navigate(R.id.action_mailListFragment_to_mailDetailFragment)
            }
        }


    }


}