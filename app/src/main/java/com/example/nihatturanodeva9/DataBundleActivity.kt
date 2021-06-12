package com.example.nihatturanodeva9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_data_bundle.*
import kotlinx.android.synthetic.main.activity_splash.*

class DataBundleActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_bundle)

        if(intent.getStringExtra("secilenYazi") == null){
            Toast.makeText(getApplicationContext(),"Veri yok", Toast.LENGTH_LONG).show();
        }else{
            textView.text = intent.getStringExtra("secilenYazi")
        }

        hakkindaButton3.setOnClickListener { view ->
            val intent = Intent(this,HakkimdaActivity::class.java)
            startActivity(intent)
        }
    }
}