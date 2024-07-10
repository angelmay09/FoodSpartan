package com.example.foodspartan.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.foodspartan.R
import com.example.foodspartan.SQLiteHelper
import com.example.foodspartan.StudentModel

class RegisterActivity : AppCompatActivity() {

    private lateinit var edName: EditText
    private lateinit var edEmail: EditText
    private lateinit var edPassword:EditText
    private lateinit var btnReg: Button

    private lateinit var sqLiteHelper: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_register)
        initView()
        sqLiteHelper = SQLiteHelper(this)
        btnReg.setOnClickListener{addStudent()}

        val onClick = findViewById<TextView>(R.id.signup)
        onClick.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initView() {
        edName = findViewById(R.id.name)
        edEmail= findViewById(R.id.email)
        edPassword=findViewById(R.id.password)
        btnReg = findViewById(R.id.register)
    }

    private fun addStudent() {
        val name = edName.text.toString()
        val email = edEmail.text.toString()
        val password = edPassword.text.toString()

        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill in every field", Toast.LENGTH_SHORT).show()
        }else {
            val std = StudentModel(name = name, email = email, password = password)
            val status = sqLiteHelper.insertStudent(std)

            if(status > -1) {
                Toast.makeText(this, "Student Added...", Toast.LENGTH_SHORT).show()
                clearEditText()
            }else {
                Toast.makeText(this,"Record not Saved", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun clearEditText() {
        edName.setText("")
        edEmail.setText("")
        edName.requestFocus()
    }
}