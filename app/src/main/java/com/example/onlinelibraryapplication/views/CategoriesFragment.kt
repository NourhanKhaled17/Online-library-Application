package com.example.onlinelibraryapplication.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.adapters.CategoryAdapter
import com.example.onlinelibraryapplication.repositories.myCategories
import kotlinx.android.synthetic.main.fragment_categories.*

class CategoriesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_categories, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categories_recyclerView.layoutManager = GridLayoutManager(context, 2)
        categories_recyclerView.setHasFixedSize(true)
        categories_recyclerView.adapter = CategoryAdapter(myCategories)
    }
}