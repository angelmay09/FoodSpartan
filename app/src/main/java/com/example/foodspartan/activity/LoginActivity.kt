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


class LoginActivity : AppCompatActivity() {

    private lateinit var edName: EditText
    private lateinit var edEmail: EditText
    private lateinit var btnReg: Button
    private lateinit var btnSign: Button

    private lateinit var sqLiteHelper: SQLiteHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_login)
        initView()
        sqLiteHelper = SQLiteHelper(this)


        val onClick = findViewById<TextView>(R.id.register)
        onClick.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        val buttonClick = findViewById<Button>(R.id.signup)
        buttonClick.setOnClickListener {
            val intent = Intent(this, CustomerActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun initView() {
        edName = findViewById(R.id.name)
        edEmail= findViewById(R.id.email)
        btnReg = findViewById(R.id.register)
        btnSign= findViewById(R.id.signup)
    }

    private fun clearEditText() {
        edName.setText("")
        edEmail.setText("")
        edName.requestFocus()
    }
}