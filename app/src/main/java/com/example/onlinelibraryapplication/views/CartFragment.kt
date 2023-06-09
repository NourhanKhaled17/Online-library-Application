package com.example.onlinelibraryapplication.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.adapters.CartAdapter
import com.example.onlinelibraryapplication.adapters.totalPrice
import com.example.onlinelibraryapplication.repositories.myFieldsInCart
import kotlinx.android.synthetic.main.fragment_cart.*

class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cart_recyclerView.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        cart_recyclerView.adapter = CartAdapter(myFieldsInCart)

        /*val cart: CartAdapter = CartAdapter(myFieldsInCart)
        val price = cart.calculateTotalPrice()

        totalPriceOfCart.text = price.toString()*/

        if (myFieldsInCart.isEmpty()) {
            button_buy.visibility = View.GONE
            totalPriceOfCart.visibility = View.GONE
        } else {
            cart_is_empty.visibility = View.GONE
        }
    }
}