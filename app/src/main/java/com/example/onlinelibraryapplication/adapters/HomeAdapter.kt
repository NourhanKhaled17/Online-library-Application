package com.example.onlinelibraryapplication.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.repositories.FieldModel
import com.example.onlinelibraryapplication.views.BookActivity

@SuppressLint("StaticFieldLeak")
lateinit var contextOfHomeAdapter: Context

class HomeAdapter(private var forYouList: ArrayList<FieldModel>) :
    RecyclerView.Adapter<HomeAdapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var card: CardView = item.findViewById(R.id.card_child)
        var image: ImageView = item.findViewById(R.id.img1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.child_reyclerview_cardview, parent, false)
        contextOfHomeAdapter = parent.context

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = forYouList[position]
        holder.image.setImageResource(currentItem.image)

        holder.card.setOnClickListener {
            val model = forYouList[position]

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

            val intent = Intent(contextOfHomeAdapter, BookActivity::class.java)

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

            contextOfHomeAdapter.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return forYouList.size
    }
}