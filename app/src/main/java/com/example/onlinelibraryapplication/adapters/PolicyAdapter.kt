package com.example.onlinelibraryapplication.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.repositories.FieldModel
import com.example.onlinelibraryapplication.repositories.myFieldsInCart
import com.example.onlinelibraryapplication.views.BookActivity
import com.google.android.material.imageview.ShapeableImageView

@SuppressLint("StaticFieldLeak")
lateinit var contextPolicyAdapter: Context

class PolicyAdapter(private val fieldsList: ArrayList<FieldModel>) :
    RecyclerView.Adapter<PolicyAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.category_list_item, parent, false)
        contextPolicyAdapter = parent.context

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = fieldsList[position]
        holder.image1.setImageResource(currentItem.image)
        holder.heading1.text = currentItem.heading
        holder.description1.text = currentItem.description.substring(0, 80).plus("...")

        holder.bookCard.setOnClickListener {
            val model = fieldsList[position]

            val getTitle = model.heading
            val getDescription = model.description
            val getImage = model.image
            val getAuthor = model.author
            val getRate = model.rate
            val getPages = model.pages
            val getLanguage = model.language
            val getPrice = model.price
            val getAboutAuthor = model.aboutAuthor
            val getURLRead = model.URLRead
            val getURLListen = model.URLListen

            val intent = Intent(contextPolicyAdapter, BookActivity::class.java)

            intent.putExtra("iTitle", getTitle)
            intent.putExtra("iDescription", getDescription)
            intent.putExtra("iImage", getImage)
            intent.putExtra("iAuthor", getAuthor)
            intent.putExtra("iRate", getRate)
            intent.putExtra("iPages", getPages)
            intent.putExtra("iLanguage", getLanguage)
            intent.putExtra("iPrice", getPrice)
            intent.putExtra("iAboutAuthor", getAboutAuthor)
            intent.putExtra("iURLRead", getURLRead)
            intent.putExtra("iURLListen", getURLListen)

            contextPolicyAdapter.startActivity(intent)
        }

        holder.goCard.setOnClickListener {
            addItem(currentItem)
            Toast.makeText(
                contextPolicyAdapter, " تم إضافة ${holder.heading1.text} إلي العربة", Toast.LENGTH_SHORT
            ).show()
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun addItem(list: FieldModel) {
        myFieldsInCart.add(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return fieldsList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image1: ShapeableImageView = itemView.findViewById(R.id.image)
        val heading1: TextView = itemView.findViewById(R.id.heading)
        val description1: TextView = itemView.findViewById(R.id.description)
        val bookCard: CardView = itemView.findViewById(R.id.book_card)
        val goCard: ImageButton = itemView.findViewById(R.id.go_card)
    }
}