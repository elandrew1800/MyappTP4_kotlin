package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.system.Os.remove
import android.view.LayoutInflater
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.detail.DetailActivity
import com.example.myapplication.models.Tweet
import com.example.myapplication.view.TweetAdapter

class MainActivity : AppCompatActivity() {


    private lateinit var recv:RecyclerView
    private lateinit var tweetList:ArrayList<Tweet>
    private lateinit var tweetAdapter:TweetAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tweetList = ArrayList()
        recv = findViewById(R.id.recycle)
        tweetAdapter =TweetAdapter(this,tweetList)
        recv.layoutManager =LinearLayoutManager(this)
        recv.adapter = tweetAdapter

        val addBtn = findViewById<ImageButton>(R.id.add)

        tweetAdapter.onItemClick ={
            val intent= Intent(this, DetailActivity::class.java)
            intent.putExtra("user",it)
            startActivity(intent)
        }
        addBtn.setOnClickListener { addinfo() }

    }

    private fun addinfo() {
        val inflter =LayoutInflater.from(this)
        val  v = inflter.inflate(R.layout.dialog ,null)

        val user = v.findViewById<TextView>(R.id.user)
        val tweet = v.findViewById<EditText>(R.id.tweetEdit)

        val addDialog =AlertDialog.Builder(this)
            addDialog.setView(v)
            addDialog.setPositiveButton("ok"){
                dialog,_->
                val tweety = tweet.text.toString()
                val userName = user.text.toString()
                tweetList.add(Tweet("Elamine bouchafa: $userName","$tweety"))
                tweetAdapter.notifyDataSetChanged()
                Toast.makeText(this,"adding tweet done !", Toast.LENGTH_SHORT).show()
                dialog.dismiss()
            }

            addDialog.setNegativeButton("cancel"){
                dialog ,_->
                dialog.dismiss()
                Toast.makeText(this,"Cancel", Toast.LENGTH_SHORT).show()
            }
            addDialog.create()
            addDialog.show()
    }



}