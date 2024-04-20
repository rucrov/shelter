package com.example.myapplication

import ImageLoader
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.myapplication.model.DatabaseHelper
import com.example.myapplication.model.User


class AddNewUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_new_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val db = DatabaseHelper(applicationContext)
        db.writableDatabase;

        val fullnamePerson: TextView = findViewById(R.id.userName)
        val jobTitlePerson : TextView = findViewById(R.id.userJobTitle)
        val descriptionPerson: TextView = findViewById(R.id.experience)
        val imagePath: TextView = findViewById(R.id.imagePath)
        val addUserImage = ImageLoader(findViewById(R.id.addUserImage))

        val saveButton: Button = findViewById(R.id.saveButton)
        val clearButton: Button = findViewById(R.id.clearButton)

        imagePath.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                addUserImage.execute(imagePath.text.toString())
            }

        })

        saveButton.setOnClickListener(View.OnClickListener {
            if (fullnamePerson.text.toString() != "" && jobTitlePerson.text.toString() != ""){
                db.addUser(User(
                    0,
                    imagePath.text.toString(),
                    fullnamePerson.text.toString(),
                    jobTitlePerson.text.toString(),
                    descriptionPerson.text.toString()
                ))
                this.finish()

            }
            // обязательны имя и должность!
            else {
                Toast.makeText(this, "Не все поля заполнены!", Toast.LENGTH_LONG).show()
            }

        })

        clearButton.setOnClickListener(View.OnClickListener {
            fullnamePerson.text = ""
            jobTitlePerson.text = ""
            descriptionPerson.text = ""
            imagePath.text = ""
        })



    }
}