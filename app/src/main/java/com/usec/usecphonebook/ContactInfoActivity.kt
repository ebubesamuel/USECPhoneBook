package com.usec.usecphonebook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.usec.usecphonebook.databinding.ContactInfoBinding

class ContactInfoActivity : AppCompatActivity() {

    private lateinit var binding: ContactInfoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContactInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.EditButton.setOnClickListener {
            val intent = Intent(this, ContactEditActivity::class.java)
            startActivity(intent)
        }
    }
}
