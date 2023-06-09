package com.example.onlinelibraryapplication.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.adapters.ReligionAdapter2
import kotlinx.android.synthetic.main.fragment_favourite.*

class FavouriteFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favourite_recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)

        /*val myFavouriteRecycler = ReligionAdapter2(myFearFieldsInFavourite)
        favourite_recyclerView.adapter = myFavouriteRecycler

        if (myFearFieldsInFavourite.isNotEmpty()) {
            favorite_is_empty.visibility = View.GONE
        }*/
    }
}