package com.dev.recyle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
private lateinit var recyclerView: RecyclerView
private lateinit var manager: RecyclerView.LayoutManager
lateinit var myAdapter: RecyclerView.Adapter<*>
class MainActivity : AppCompatActivity(), MyAdapter.OnItemClickListener {
    var values= arrayListOf<String>("item1", "item2" , "item3", "item4", "item5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        manager = LinearLayoutManager(this)
        myAdapter = MyAdapter(values,this)
        recyclerView = findViewById<RecyclerView>(R.id.recyclerview).apply {
            layoutManager = manager
            adapter = myAdapter
        }

        var n:Int = values.size + 1
        values.add("item$n") //Ajout dans la source de données
        myAdapter.notifyItemInserted(values.size)//Rafraichissement de l’adapter


        val addButton = findViewById<Button>(R.id.btn)

        addButton.setOnClickListener {
            val n: Int = values.size + 1
            values.add("item$n") // Ajout dans la source de données
            myAdapter.notifyItemInserted(values.size - 1) // Rafraîchissement de l'adaptateur
        }
    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked",
            Toast.LENGTH_SHORT).show()
        values[position]="Clicked"
        myAdapter.notifyItemChanged(position)
    }




}