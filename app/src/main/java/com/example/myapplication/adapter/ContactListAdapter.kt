package com.example.danhba.adapter

import android.util.Log
import android.view.ContextMenu
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.danhba.R
import com.example.danhba.model.Contact
import android.view.View.OnCreateContextMenuListener
class ContactListAdapter(private val contacts: List<Contact>): RecyclerView.Adapter<ContactListAdapter.ContactListViewHolder>() {

     var onItemClick: ((contact: Contact) -> Unit)?= null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactListViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.contact_view, parent, false)

        return ContactListViewHolder(adapterLayout)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onBindViewHolder(holder: ContactListViewHolder, position: Int) {
        val contact = contacts[position]
        if(contact.name.isBlank()) return
        holder.avatar.text = contact.name.subSequence(0..0)
        holder.name.text = contact.name

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(contact)


        }

    }


    class ContactListViewHolder(private val view: View): RecyclerView.ViewHolder(view), OnCreateContextMenuListener  {
        val avatar: TextView = view.findViewById(R.id.avatar_name)
        val name: TextView = view.findViewById(R.id.contact_name)
        init {

            itemView.setOnCreateContextMenuListener(this);
        }

        override fun onCreateContextMenu(
            menu: ContextMenu,
            v: View?,
            menuInfo: ContextMenu.ContextMenuInfo?
        ) {
            val call = menu.add(Menu.NONE, 1, 1, "Call")
            val sms = menu.add(Menu.NONE, 2, 2, "SMS")
            val email = menu.add(Menu.NONE, 3, 3, "Email")
            call.setOnMenuItemClickListener(onEditMenu)
            sms.setOnMenuItemClickListener(onEditMenu)
            email.setOnMenuItemClickListener(onEditMenu)
        }

        private val onEditMenu: MenuItem.OnMenuItemClickListener =
            MenuItem.OnMenuItemClickListener { item ->
                when (item.itemId) {
                    1 -> {
                        Toast.makeText(itemView.context, "Call ${name.text}", Toast.LENGTH_SHORT).show()
                    }
                    2 -> {
                        Toast.makeText(itemView.context, "SMS ${name.text}", Toast.LENGTH_SHORT).show()
                    }
                    3 ->{
                        Toast.makeText(itemView.context, "Email ${name.text}", Toast.LENGTH_SHORT).show()
                    }
                }
                true
            }

        }
    }





