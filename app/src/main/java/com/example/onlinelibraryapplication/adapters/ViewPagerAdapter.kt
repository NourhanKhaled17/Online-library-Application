package com.example.onlinelibraryapplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.onlinelibraryapplication.views.Onboarding1Fragment
import com.example.onlinelibraryapplication.views.Onboarding2Fragment
import com.example.onlinelibraryapplication.views.Onboarding3Fragment

class ViewPagerAdapter(fragment: FragmentManager): FragmentPagerAdapter(fragment) {

    private val fragments = listOf(
        Onboarding1Fragment(),
        Onboarding2Fragment(),
        Onboarding3Fragment()
    )

    override fun getCount(): Int {
        return 3
    }

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

}