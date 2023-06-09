package com.example.onlinelibraryapplication.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.adapters.AuthorsAdapter
import com.example.onlinelibraryapplication.adapters.HomeAdapter
import com.example.onlinelibraryapplication.repositories.*
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Authors Recycler View
        authors_title.text = "أكثر المؤلفين إنتشارًا"
        authors_recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        authors_recyclerView.adapter = AuthorsAdapter(mostPopular6)

        //For You Recycler View
        for_you_title.text = "خصيصًا لك"
        for_you_recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        for_you_recyclerView.adapter = HomeAdapter(myForYouBooks)

        //Most Reading Recycler View
        more_reading_title.text = "الأكثر قراءة"
        more_reading_recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        more_reading_recyclerView.adapter = HomeAdapter(myMostReadingBooks)

        //Popular Recycler View
        popular_title.text = "الأكثر إنتشارًا"
        popular_recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        popular_recyclerView.adapter = HomeAdapter(myPopularBooks)

        //Books Recycler View
        books_title.text = "الكُتب"
        books_recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        books_recyclerView.adapter = HomeAdapter(myBooks)

        //Novels Recycler View
        novels_title.text = "الروايات"
        novels_recyclerView.layoutManager =
            LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        novels_recyclerView.adapter = HomeAdapter(myNovels)
    }
}