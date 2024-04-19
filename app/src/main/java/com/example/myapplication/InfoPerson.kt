package com.example.myapplication

import ImageLoader
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.model.User


class InfoPerson : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_info_person)


        val name: String? = intent.getStringExtra("name")
        val photo: String? = intent.getStringExtra("photo")
        val jobTitle: String? = intent.getStringExtra("jobTitle")
        val experience: String? = intent.getStringExtra("experience")

        val imageInfoPerson = ImageLoader(findViewById(R.id.imageInfoPerson))
        val fullnamePerson: TextView = findViewById(R.id.fullnamePerson)
        val descriptionPerson: TextView = findViewById(R.id.descriptionPerson)
        val jobTitlePerson :TextView = findViewById(R.id.jobTitle)


        imageInfoPerson.execute(photo)
        fullnamePerson.text = name
        descriptionPerson.text = experience
        jobTitlePerson.text = jobTitle

    }
}