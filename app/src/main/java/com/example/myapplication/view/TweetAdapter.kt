package com.example.myapplication.view

import android.content.Context
import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.Tweet

class TweetAdapter (val c:Context ,val tweetList:ArrayList<Tweet>) :RecyclerView.Adapter<TweetAdapter.TweetViewHolder>()
{


    inner class TweetViewHolder(val v:View):RecyclerView.ViewHolder(v){
        var name:TextView
        var tweet:TextView


        init {
            name = v.findViewById<TextView>(R.id.mtitle)
            tweet = v.findViewById<TextView>(R.id.subtitle)
        }



    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TweetViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.list_item,parent, false)
        return TweetViewHolder(v)
    }

    override fun onBindViewHolder(holder: TweetViewHolder, position: Int) {
        val newList = tweetList[position]
        holder.name.text = newList.user
        holder.tweet.text =newList.tweet



    }

    override fun getItemCount(): Int {
        return tweetList.size
    }










}






