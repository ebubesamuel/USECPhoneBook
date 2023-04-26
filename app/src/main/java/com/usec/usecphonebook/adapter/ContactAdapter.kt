package com.usec.usecphonebook.adapter

import android.content.Context
import android.content.Intent
import android.location.Address
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.RecyclerView
import com.usec.usecphonebook.ContactInfoActivity
import com.usec.usecphonebook.Database.ContactDatabase
import com.usec.usecphonebook.Database.ContactDatabaseDao
import com.usec.usecphonebook.R
import com.usec.usecphonebook.model.Contacts
import com.usec.usecphonebook.model.AddressListViewModel

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ContactAdapter(private val dataset: List<Contacts>) :
    RecyclerView.Adapter<ContactAdapter.ContactViewHolder>() {
    // Called when the RecyclerView needs a new ViewHolder to represent an item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
// Inflate the contact_list_item layout
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
// Create and return a new ContactViewHolder instance with the inflated layout
        return ContactViewHolder(view)
    }
    // Called for each item in the RecyclerView to bind the data to the views
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
// Get the contact object at the current position
//        val contact = dataset[position]
// Set the name, phone, and email TextViews to display the contact's data
//        holder.contactName.text = contact.name
//        holder.contactPhone.text = contact.number
//        holder.contactEmail.text = contact.email
        val contact = dataset[position]

// Set an OnClickListener on the item view to start the ContactDetailsActivity
        holder.itemView.setOnClickListener {
// Create a new Intent to start the ContactDetailsActivity
            val intent = Intent(holder.itemView.context, ContactInfoActivity::class.java) //
// Add the clicked contact object to the Intent as an extra
            intent.putExtra("contact", contact)
// Start the ContactDetailsActivity with the Intent
            holder.itemView.context.startActivity(intent)
        }
        holder.textView.text = holder.itemView.context.getString(contact.stringResourceId)

//        private val addressDao = ContactDatabase.getInstance(context).
//
//        holder.itemView.setOnClickListener{
//           dao.delete(list[position])
//            notifyItemChanged(position)
//        }


    }




    // Returns the number of items in the list
    override fun getItemCount(): Int {
        return dataset.size
    }
    // Defines the views that make up each item in the RecyclerView
    inner class ContactViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val contactName: TextView = itemView.findViewById(R.id.ContactName)
//        val contactPhone: TextView = itemView.findViewById(R.id.ContactNumber)
//        val contactEmail: TextView = itemView.findViewById(R.id.ContactEmail)
        val textView: TextView = itemView.findViewById(R.id.item_title) //item_title

    }


}