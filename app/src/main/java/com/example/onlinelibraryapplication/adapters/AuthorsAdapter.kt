package com.example.onlinelibraryapplication.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.onlinelibraryapplication.R
import com.example.onlinelibraryapplication.repositories.ChildModelClass
import com.example.onlinelibraryapplication.views.AuthorActivity
import com.example.onlinelibraryapplication.views.BookActivity

@SuppressLint("StaticFieldLeak")
lateinit var contextOfAuthorsAdapter: Context

class AuthorsAdapter(private var authorsList: ArrayList<ChildModelClass>) :
    RecyclerView.Adapter<AuthorsAdapter.ViewHolder>() {

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var cardCircle: CardView = item.findViewById(R.id.card_circle)
        var image: ImageView = item.findViewById(R.id.img_circle)
        /*var name: TextView = item.findViewById(R.id.author_name2)
        var job: TextView = item.findViewById(R.id.job)
        var description: ImageView = item.findViewById(R.id.description_author)
        var hisBooks: ImageView = item.findViewById(R.id.his_books)*/
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.childe_recyclerview_circle, parent, false)
        contextOfAuthorsAdapter = parent.context

        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = authorsList[position]
        holder.image.setImageResource(currentItem.image)

        holder.cardCircle.setOnClickListener {
            val model = authorsList[position]

            val getImage = model.image
            val getName = model.name
            val getJob = model.job
            val getDescription = model.description
            val getBooks = model.hisBooks
            val getBackgroundColor = model.backgroundColor

            val intent = Intent(contextOfHomeAdapter, AuthorActivity::class.java)

            intent.putExtra("iImage", getImage)
            intent.putExtra("iName", getName)
            intent.putExtra("iJob", getJob)
            intent.putExtra("iDescription", getDescription)
            intent.putExtra("iBooks", getBooks)
            intent.putExtra("iBackgroundColor", getBackgroundColor)

            contextOfAuthorsAdapter.startActivity(intent)
            //contextOfAuthorsAdapter.startActivity(Intent(contextOfAuthorsAdapter, AuthorActivity::class.java))
        }
    }

    override fun getItemCount(): Int {
        return authorsList.size
    }
}