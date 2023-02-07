package com.example.nurimesk.data.mesks

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.nurimesk.R

class MesksAdapter(val openBrowserAction: (List<Mesk>, Int) -> Unit) : RecyclerView.Adapter<MesksAdapter.MeskViewHolder>() {
    private var meskList = listOf<Mesk>(
        Mesk("Physics", "https://disk.yandex.com/d/aA_cv92_ObgHQA", R.drawable.ic_baseline_construction_24),
        Mesk("Maths", "https://disk.yandex.com/d/upByM3et3PTbhg", R.drawable.ic_baseline_all_inclusive_24),
        Mesk("Informatics", "https://disk.yandex.com/d/rWTh3HFLD66h8g", R.drawable.ic_baseline_computer_24)
    )

    class MeskViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MeskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_mesk, parent, false)
        return MeskViewHolder(view)
    }

    override fun onBindViewHolder(holder: MeskViewHolder, position: Int) {
        holder.itemView.findViewById<TextView>(R.id.name).text = meskList.get(position).subject
        holder.itemView.findViewById<ImageView>(R.id.img).setImageResource(meskList[position].img)
        holder.itemView.findViewById<View>(R.id.item_area).setOnClickListener {
            Log.e("pressed", "ok")
            openBrowserAction(meskList, position)
        }
    }

    override fun getItemCount(): Int {
         return meskList.size
    }
}