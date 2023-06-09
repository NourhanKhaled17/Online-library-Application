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
import com.example.onlinelibraryapplication.repositories.Category
import com.example.onlinelibraryapplication.views.*

@SuppressLint("StaticFieldLeak")
lateinit var contextOfCategoryAdapter: Context

class CategoryAdapter(private val FieldList: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image_horror)
        val textView: TextView = itemView.findViewById(R.id.title)
        val categoryCard: CardView = itemView.findViewById(R.id.category_id)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.category_cardview, parent, false)
        contextOfCategoryAdapter = parent.context

        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val field = FieldList[position]
        holder.imageView.setImageResource(field.imageCover)
        holder.textView.text = field.type
        holder.categoryCard

        holder.categoryCard.setOnClickListener {
            when (position) {
                0 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, FearActivity::class.java
                        )
                    )
                }
                1 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, CrimeActivity::class.java
                        )
                    )
                }

                2 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, HistoryActivity::class.java
                        )
                    )
                }

                3 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, FqhActivity::class.java
                        )
                    )
                }
                4 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, ReligionActivity::class.java
                        )
                    )
                }

                5 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, PolicyActivity::class.java
                        )
                    )
                }
                6 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, LiterateActivity::class.java
                        )
                    )
                }
                7 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, DevelopingActivity::class.java
                        )
                    )
                }
                8 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, NovelsActivity::class.java
                        )
                    )
                }
                9 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, FantasyActivity::class.java
                        )
                    )
                }


                10 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, LawActivity::class.java
                        )
                    )
                }
                11 -> {
                    contextOfCategoryAdapter.startActivity(
                        Intent(
                            contextOfCategoryAdapter, PhilosophyActivity::class.java
                        )
                    )
                }

            }
        }
    }

    override fun getItemCount(): Int {
        return FieldList.size
    }
}