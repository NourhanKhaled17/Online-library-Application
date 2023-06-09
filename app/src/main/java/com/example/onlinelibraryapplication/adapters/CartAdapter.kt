package com.example.onlinelibraryapplication.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.repositories.FieldModel
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.cart_cardview.view.*

var totalPrice: Double = 0.0
lateinit var contextCartAdapter: Context

class CartAdapter(private val cartItemList: ArrayList<FieldModel>) :
    RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val imageCart: ShapeableImageView = itemView.findViewById(R.id.imageCart)
        val headingCart: TextView = itemView.findViewById(R.id.headingCart)
        val buttonCartRemove: ImageButton = itemView.findViewById(R.id.remove_from_cart)
        val bookTotalPrice: TextView = itemView.findViewById(R.id.bookTotalPrice)
        val quantitySpinner: Spinner = itemView.findViewById(R.id.quantitySpinner)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.cart_cardview, parent, false)
        contextCartAdapter = parent.context

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val listItems = cartItemList[position]

        holder.imageCart.setImageResource(listItems.image)
        holder.headingCart.text = listItems.heading
        holder.bookTotalPrice.text = listItems.price
        holder.quantitySpinner.setSelection(0, true)

        ArrayAdapter.createFromResource(
            contextCartAdapter,
            R.array.quantity_string_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
            holder.quantitySpinner.adapter = adapter
        }

        holder.quantitySpinner.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    val total = (listItems.price.toDouble() * (position + 1).toDouble())
                    holder.bookTotalPrice.text = total.toString()
                    totalPrice += total
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

        holder.buttonCartRemove.setOnClickListener {
            removeItem(listItems)
            Toast.makeText(
                contextCartAdapter,
                " تم حذف ${holder.headingCart.text} من العربة",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    override fun getItemCount(): Int {
        return cartItemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun removeItem(element: FieldModel) {
        cartItemList.remove(element)
        notifyDataSetChanged()
    }
}