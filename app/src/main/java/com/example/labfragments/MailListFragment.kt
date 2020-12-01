package com.example.labfragments

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MailListFragment : Fragment() {

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val user = ArrayList<User>()
        for(i in 1..25){
            user.add(User("Name$i","Position$i"))
        }

        val view = inflater.inflate(R.layout.fragment_mail_detail,container,false)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerview)
        recyclerView.adapter = RecyclerAdapter(user,view.context)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        return view

    }

}