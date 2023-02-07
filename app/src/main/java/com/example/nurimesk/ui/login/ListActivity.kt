package com.example.nurimesk.ui.login

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import com.example.nurimesk.R
import com.example.nurimesk.data.mesks.Mesk
import com.example.nurimesk.data.mesks.MesksAdapter
import com.example.nurimesk.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val logout = findViewById<View>(R.id.logout)
        val recyclerView = binding.list

        fun onClick(meskList: List<Mesk>, position: Int)
        {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(meskList.get(position).link))
            startActivity(browserIntent)
        }

        recyclerView.adapter = MesksAdapter(::onClick)

        logout.setOnClickListener {
            finish()
        }
    }
}