package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView

class Splash : AppCompatActivity() {

    lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        val ttb = AnimationUtils.loadAnimation(this,R.anim.ttb)
        val stb = AnimationUtils.loadAnimation(this,R.anim.stb)
        val logo = findViewById<ImageView>(R.id.splash4)
        val welcome = findViewById<TextView>(R.id.textView3)


        logo.startAnimation(stb)
        welcome.startAnimation(ttb)



        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        },3000)
    }
}