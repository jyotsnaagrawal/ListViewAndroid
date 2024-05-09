package com.jyotsna.listview

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val daysOfWeek = arrayOf(
            "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"
        )

        // ArrayAdapter
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, daysOfWeek)

        // Find ListView
        val listView: ListView = findViewById(R.id.listView)

        // Set adapter to ListView
        listView.adapter = adapter

        // Set item click listener
        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            val clickedDay = daysOfWeek[position]
            val message = when (clickedDay) {
                "Sunday" -> "Relaxing day"
                "Monday" -> "Busy day"
                "Tuesday" -> "Meeting day"
                "Wednesday" -> "Hump day"
                "Thursday" -> "Almost there"
                "Friday" -> "TGIF!"
                "Saturday" -> "Fun day"
                else -> ""
            }
            showToast(message)
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
