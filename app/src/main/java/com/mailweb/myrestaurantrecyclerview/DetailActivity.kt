package com.mailweb.myrestaurantrecyclerview

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mailweb.myrestaurantrecyclerview.R.id.img_detail_menu

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detail)

        val imgPhoto = findViewById<ImageView>(img_detail_menu)
        val tvName = findViewById<TextView>(R.id.detail_item_name)
        val tvDescription = findViewById<TextView>(R.id.detail_item_description)
        val etBtn = findViewById<Button>(R.id.btnBack)

        val name = intent.getStringExtra("EXTRA_NAME")
        val description = intent.getStringExtra("EXTRA_DESCRIPTION")
        val photo = intent.getIntExtra("EXTRA_PHOTO", 0)

        imgPhoto.setImageResource(photo)
        tvName.text = getString(R.string.nama, name)
        tvDescription.text = getString(R.string.deskripsi, description)

        etBtn.setOnClickListener {
            finish()

        }
    }
}