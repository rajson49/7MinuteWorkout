package com.example.a7minuteworkout

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.SyncStateContract
import android.service.autofill.VisibilitySetterAction
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_exersice.*
import java.lang.Exception
import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.log

class ExersiceActivity : AppCompatActivity() , TextToSpeech.OnInitListener{

    private var restTimer:CountDownTimer?=null
    private var restProgress=0

    private var exersiceTimer:CountDownTimer?=null
    private var exersiceProgress = 0

    private var exersiceDuration:Long=10

    private var exersiceList:ArrayList<ExersiceModel>?=null
    private var currentExersicePosition=-1
    private var player:MediaPlayer?=null

    private var tts:TextToSpeech?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exersice)

        setSupportActionBar(toolbar_exersice_activity)

        val actionbar=supportActionBar
        if (actionbar!=null){
            actionbar.setDisplayHomeAsUpEnabled(true)
        }

        toolbar_exersice_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        tts= TextToSpeech(this,this)
        exersiceList=Constacts.defualtExcersiceList()
        setupRestView()
    }

    override fun onDestroy() {
        if (restTimer!=null){
            restTimer!!.cancel()
            restProgress=0
        }

        if(exersiceTimer!=null){
            exersiceTimer!!.cancel()
            exersiceProgress=0
        }

        if(tts!=null){
            tts!!.stop()
            tts!!.shutdown()
        }

        if(player!=null){
            player!!.stop()
        }

        super.onDestroy()
    }

    private fun setRestProgressBar(){

        progressBar.progress=restProgress
        restTimer=object:CountDownTimer(10000,1000){
            override fun onTick(millisUntilFinished: Long) {
                restProgress++
                progressBar.progress=10-restProgress
                tvTimer.text=(10-restProgress).toString()


            }
            override fun onFinish() {
                Toast.makeText(this@ExersiceActivity,"Here now we will start the exersice"
                ,Toast.LENGTH_SHORT).show()
                currentExersicePosition++
                setupExcersiceView()
            }

        }.start()
    }

    private fun setExersiceProgressBar(){

        progressBarExersice.progress=restProgress
        exersiceTimer=object:CountDownTimer(exersiceDuration*1000,1000){
            override fun onTick(millisUntilFinished: Long) {
                exersiceProgress++
                progressBarExersice.progress=exersiceDuration.toInt()-exersiceProgress
                tvExcersiceTimer.text=(exersiceDuration-exersiceProgress).toString()
            }
            override fun onFinish() {
                    Toast.makeText(this@ExersiceActivity,"finish",Toast.LENGTH_SHORT).show()

                if(currentExersicePosition<(exersiceList!!.size-1)){
                    setupRestView()
                }else{
                    Toast.makeText(this@ExersiceActivity,"finish",Toast.LENGTH_SHORT).show()
                }
            }
        }.start()
    }

    private fun setupRestView(){

        try {
            player=MediaPlayer.create(applicationContext,R.raw.press_start)

            player!!.isLooping=false
            player!!.start()

        }catch (e:Exception){

        }

        llExersiceLayout.visibility=View.GONE
        llRestView.visibility=View.VISIBLE
        tvUpcomingExcersiceName.text="Upcoming Exersice : "+exersiceList!![currentExersicePosition+1].getName()

        if(restTimer!=null){
            restTimer!!.cancel()
            restProgress=0
        }

        setRestProgressBar()
    }

    private fun setupExcersiceView(){

        //Toast.makeText(this,"Hello",Toast.LENGTH_SHORT).show()
        llRestView.visibility= View.GONE
        llExersiceLayout.visibility=View.VISIBLE

        if(exersiceTimer!=null){
            exersiceTimer!!.cancel()
            exersiceProgress=0
        }

        var excersiceName=exersiceList!![currentExersicePosition].getName()
        speakOut(excersiceName)
        setExersiceProgressBar()

        ivImage.setImageResource(exersiceList!![currentExersicePosition].getImage())
        exersiceName.text=exersiceList!![currentExersicePosition].getName()

    }

    override fun onInit(status: Int) {

        if(status==TextToSpeech.SUCCESS){
            val result=tts!!.setLanguage(Locale.US)
            if(result==TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED){
                Log.e("TTS","The Language specified is not supported")
            }
        }else{
            Log.e("TTS","initialization Failed")
        }
    }

    private fun speakOut(text:String){
        tts!!.speak(text,TextToSpeech.QUEUE_FLUSH,null)
    }

}