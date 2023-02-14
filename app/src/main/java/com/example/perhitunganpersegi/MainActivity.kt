package com.example.perhitunganpersegi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var Esisi: EditText
    private lateinit var rkeliling:RadioButton
    private lateinit var rluas: RadioButton
    private lateinit var btntampil: Button
    private lateinit var hasil: TextView

    private var persegi : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Esisi = findViewById(R.id.Esisi)
        rkeliling = findViewById(R.id.rkeliling)
        rluas = findViewById(R.id.rluas)
        btntampil = findViewById(R.id.tampil)
        hasil = findViewById(R.id.hasil)

        btntampil.setOnClickListener {
            var sisi = Esisi.text.toString().toInt()

            if (rkeliling.isChecked) {
                persegi = 4* sisi
                hasil.setText(persegi.toString()+"keliling")
            } else {
                persegi = sisi * sisi
                hasil.setText(persegi.toString()+"luas")
            }
        }
    }
}