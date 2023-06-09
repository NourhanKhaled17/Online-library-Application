package com.example.onlinelibraryapplication.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.core.view.WindowCompat
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.onlinelibraryapplication.R
import kotlinx.android.synthetic.main.activity_home.*

const val homeID = 1
const val favoriteID = 2
const val categoriesID = 3
const val cartID = 4


class HomeActivity : AppCompatActivity() {
    private val myHomeFragment = HomeFragment()
    private val myFavouriteFragment = FavouriteFragment()
    private val myCategoriesFragment = CategoriesFragment()
    private val myCartFragment = CartFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //This code line to make window take all size of the screen
        WindowCompat.setDecorFitsSystemWindows(window, false)

        //This code line to change color of items in status bar to black
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        //This code line to hide action bar from this activity
        if (supportActionBar != null) {
            supportActionBar!!.hide()
        }

        //This code line to open profile page
        account.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        //To Show Bottom Navigation Bar and fragments
        meowBottomNavBar()
        menuNavigationListener()

        //Initialize Fragments
        initFragments()
    }

    private fun meowBottomNavBar() {

        meow_bottom_navigation.add(MeowBottomNavigation.Model(homeID, R.drawable.home))
        meow_bottom_navigation.add(MeowBottomNavigation.Model(favoriteID, R.drawable.favorite))
        meow_bottom_navigation.add(MeowBottomNavigation.Model(categoriesID, R.drawable.categories))
        meow_bottom_navigation.add(MeowBottomNavigation.Model(cartID, R.drawable.shopping_cart))

        meow_bottom_navigation.show(homeID, true)
    }

    private fun menuNavigationListener() {
        meow_bottom_navigation.setOnClickMenuListener {
            when (it.id) {
                homeID -> {
                    replaceFragment(myHomeFragment)
                    home.text = "الصفحة الرئيسية"
                    search_view.queryHint = "كتب، روايات أو مؤلفين"
                }
                favoriteID -> {
                    replaceFragment(myFavouriteFragment)
                    home.text = "المفضلة"
                    search_view.queryHint = "ابحث بين كتبك ورواياتك المفضلة"
                }
                categoriesID -> {
                    replaceFragment(myCategoriesFragment)
                    home.text = "التصنيفات"
                    search_view.queryHint = "رعب، أدب، تاريخ أو سياسة"
                }
                cartID -> {
                    replaceFragment(myCartFragment)
                    home.text = "العربة"
                    search_view.queryHint = "ابحث عن كتاب أو رواية في العربة"
                }
            }
        }
    }

    private fun initFragments() {
        addFragment(myHomeFragment)
    }

    //Add new Fragments
    private fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frame_layout, fragment).setPrimaryNavigationFragment(fragment).commit()
    }

    //Replace Fragments
    private fun replaceFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment).commit()
    }
}