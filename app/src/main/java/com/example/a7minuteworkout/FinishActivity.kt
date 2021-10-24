package com.example.a7minuteworkout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_exersice.*
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        setSupportActionBar(finishAcivityToolbar)

        val actionaBar=supportActionBar
        if(actionaBar!=null){
            actionaBar.setDisplayHomeAsUpEnabled(true)

        }

        toolbar_exersice_activity.setNavigationOnClickListener {
            onBackPressed()
        }

        finishButton.setOnClickListener(View.OnClickListener {
            finish()
        })

    }
}