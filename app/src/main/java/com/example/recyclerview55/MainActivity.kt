package com.example.recyclerview55

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.NumberPicker
import android.widget.Toast
import androidx.core.view.get
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView:RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView=findViewById(R.id.recyclerview)

        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        recyclerview.layoutManager = LinearLayoutManager(this)
        val data = ArrayList<ItemsViewModel>()
        for (i in 1..20) {
            data.add(ItemsViewModel(R.drawable.ic_launcher_background, "Item " + i))
        }
        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter

        adapter.setOnItemClickListener(object : CustomAdapter.onItemClickListener {
            override fun onItemClick(position: String) {
                Toast.makeText(this@MainActivity,position,Toast.LENGTH_LONG).show()
                if(position!=null){
                  //  Toast.makeText(this@MainActivity,"delete",Toast.LENGTH_SHORT).show()
                    val dialog=Dialog(this@MainActivity)
                    dialog.setContentView(R.layout.number_picker_layout)
                    dialog.show()
                }

            }
        })
      //  ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT){



        }
    }

