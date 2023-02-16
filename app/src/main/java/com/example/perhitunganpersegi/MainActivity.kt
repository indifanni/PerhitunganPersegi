package com.example.perhitunganpersegi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var Esisi: EditText
    private lateinit var rkeliling:RadioButton
    private lateinit var rluas: RadioButton
    private lateinit var btntampil: Button
    private lateinit var btnsimpan: Button
    private lateinit var hasil: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

    private var persegi : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Esisi = findViewById(R.id.Esisi)
        rkeliling = findViewById(R.id.rkeliling)
        rluas = findViewById(R.id.rluas)
        btntampil = findViewById(R.id.tampil)
        btnsimpan = findViewById(R.id.simpan)
        hasil = findViewById(R.id.hasil)
        recyclerView = findViewById(R.id.listdata)

        val data = mutableListOf<PersegiData>()
        viewManager = LinearLayoutManager(this)
        recyclerAdapter = PersegiAdapter(data)
        recyclerView.adapter = recyclerAdapter
        recyclerView.layoutManager = viewManager
        btnsimpan.setOnClickListener{
            val sisi = Esisi.text.toString().toInt()
            val hasil = hasil.text.toString()
            val dataper = PersegiData(sisi,hasil)
            data.add(dataper)
            recyclerAdapter.notifyDataSetChanged()
        }

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