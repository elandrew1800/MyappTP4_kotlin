package com.example.myapplication.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.ImageButton
import android.widget.TextView
import com.example.myapplication.R
import com.example.myapplication.models.Tweet
import java.util.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        lateinit var tts : TextToSpeech

        val tweet = intent.getParcelableExtra<Tweet>("user")
        if (tweet !=null){
            val textView : TextView =findViewById(R.id.textView)
            val textView2 : TextView =findViewById(R.id.textView2)

            val currentTime: TextView =findViewById(R.id.time)
            val cTime : Date = Calendar.getInstance().time

            currentTime.setText(cTime.toString())



            textView.text= tweet.user
            textView2.text= tweet.tweet
        }


        /* le text vers audio  ps : customly created */

        var btn = findViewById<ImageButton>(R.id.btnSpeak)
        var text = findViewById<TextView>(R.id.textView2)


        btn.setOnClickListener {
            tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
                if (it == TextToSpeech.SUCCESS){
                    tts.language = Locale.US
                    tts.setSpeechRate(1.0f)
                    tts.defaultVoice
                    tts.voice
                    tts.speak(text.text.toString(),TextToSpeech.QUEUE_ADD,null)
                }
            })
        }




    }
}