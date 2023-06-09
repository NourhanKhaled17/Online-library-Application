package com.example.onlinelibraryapplication.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.repositories.FieldModel
import com.example.onlinelibraryapplication.repositories.myFieldsInCart
import com.google.android.material.imageview.ShapeableImageView
import kotlinx.android.synthetic.main.activity_book.*

@SuppressLint("StaticFieldLeak")
lateinit var contextReligionAdapter2: Context

class ReligionAdapter2(private val cartList: ArrayList<FieldModel>) :
    RecyclerView.Adapter<ReligionAdapter2.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        contextReligionAdapter2 = parent.context

        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.category_list_item_favourite, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem2 = cartList[position]

        holder.image2.setImageResource(currentItem2.image)
        holder.heading2.text = currentItem2.heading
        holder.description2.text = currentItem2.description

        holder.buttonFavouriteRemove.setOnClickListener {
            removeItem(position)
            Toast.makeText(
                contextReligionAdapter2,
                " تم حذف ${holder.heading2.text} من المفضلة",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun removeItem(position: Int) {
        cartList.removeAt(position)
        notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
        return cartList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image2: ShapeableImageView = itemView.findViewById(R.id.image_fav)
        val heading2: TextView = itemView.findViewById(R.id.heading_fav)
        val description2: TextView = itemView.findViewById(R.id.description_fav)
        val buttonFavouriteRemove: ImageButton = itemView.findViewById(R.id.remove_fav)
    }
}