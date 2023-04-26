package com.usec.usecphonebook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.usec.usecphonebook.R.id.rvContacts
import com.usec.usecphonebook.adapter.ContactAdapter
import com.usec.usecphonebook.adapter.ItemAdapter
import com.usec.usecphonebook.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val myDataset = Datasource().loadContacts()

        val  rv = findViewById<RecyclerView>(rvContacts)
        rv.adapter = ContactAdapter(myDataset)
        //rv.setHasFixedSize(true)

        var searchView: SearchView


//        rv.layoutManager = LinearLayoutManager(this)
//
//        rv.adapter = MyAdapter(IntRange(0, 100).toList())

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu, menu)
//        MenuItem menuItem = menu.findItem(R.id.action_search)
//        return super.onCreateOptionsMenu(menu)
//    }
}

//class MyAdapter(val data: List<Int>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
//    class MyViewHolder(val row: View) : RecyclerView.ViewHolder(row) {
//        val textView = row.findViewById<TextView>(R.id.rvContacts)
//    }
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
//        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view,
//            parent, false)
//        return MyViewHolder(layout)
//    }
//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        holder.textView.text = data.get(position).toString()
//    }
//    override fun getItemCount(): Int = data.size
//
//}

