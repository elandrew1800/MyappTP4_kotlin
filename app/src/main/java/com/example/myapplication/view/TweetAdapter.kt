package com.example.myapplication.view

import android.annotation.SuppressLint
import android.content.Context
import android.service.autofill.OnClickAction
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.core.view.isInvisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.models.Tweet
import kotlin.coroutines.coroutineContext

class TweetAdapter (val c:Context ,val tweetList:ArrayList<Tweet>) :RecyclerView.Adapter<TweetAdapter.TweetViewHolder>()
{
    var onItemClick:((Tweet) -> Unit)? = null

    @SuppressLint("ResourceType")
    inner class TweetViewHolder(@NonNull val v:View):RecyclerView.ViewHolder(v){

        var name:TextView
        var tweet:TextView
        var mMenu:CardView

        init {
            name = v.findViewById<TextView>(R.id.mtitle)
            tweet = v.findViewById<TextView>(R.id.subtitle)

            mMenu =v.findViewById(R.id.card)

            mMenu.setOnLongClickListener{
                DeleteDialog()
            }

        }

        /* customly created , i didnt find a useful longclick delete method in the internet , so with some logic
        * i created mine , i took long time but i did it */

        private fun DeleteDialog():Boolean {

            val inflter =LayoutInflater.from(c)
            val  v = inflter.inflate(R.layout.alert ,null)

            val deleteDialog =AlertDialog.Builder(c)
            deleteDialog.setView(v)
            deleteDialog.setPositiveButton("ok"){
                    dialog,_->
                tweetList.removeAt(adapterPosition)
                notifyDataSetChanged()
                dialog.dismiss()
            }

            deleteDialog.setNegativeButton("cancel"){
                    dialog ,_->
                dialog.dismiss()
            }
            deleteDialog.create()
            deleteDialog.show()
            return true
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
        holder.tweet.text = newList.tweet

        holder.itemView.setOnClickListener {

            onItemClick?.invoke(newList)
        }

    }

    override fun getItemCount(): Int {
        return tweetList.size
    }




}






