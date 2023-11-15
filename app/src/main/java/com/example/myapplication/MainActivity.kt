package com.example.danhba

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.danhba.adapter.ContactListAdapter
import com.example.danhba.model.Contact

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val contacts = arrayListOf<Contact>()
        val contactListView: RecyclerView = findViewById(R.id.contact_view)
        repeat(20) {
            val name = "${(65..90).random().toChar()} Khoa"
            val contact = Contact("12322", name, "0123456789", "khoa@gmail.com" )
            contacts.add(contact)
        }
        val adapter = ContactListAdapter(contacts)
        contactListView.adapter = adapter
        contactListView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL, false)

        adapter.onItemClick = {
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("contact", it)
            startActivity(intent)
        }
    }


}


