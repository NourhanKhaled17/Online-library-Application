package com.example.onlinelibraryapplication.repositories

import com.example.onlinelibraryapplication.R

data class Category(val imageCover: Int, val type: String)

val c1 = Category(R.drawable.horror2, "رعب")
val c2 = Category(R.drawable.crime, "جريمة وغموض")
val c3 = Category(R.drawable.history, "تاريخ")
val c4 = Category(R.drawable.fqh, "فقة")
val c5 = Category(R.drawable.syra, "السيرة النبوية")
val c6 = Category(R.drawable.policy_background, "سياسة")
val c7 = Category(R.drawable.literature, "الأدب")
val c8 = Category(R.drawable.psychology, "علم النفس وتطوير الذات")
val c9 = Category(R.drawable.novels, "روايات")
val c10 = Category(R.drawable.fantasy, "خيال علمي")
val c11 = Category(R.drawable.law, "قانون")
val c12 = Category(R.drawable.phisology, "فلسفة")

val myCategories = arrayListOf(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12)