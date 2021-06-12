package com.example.nihatturanodeva9

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.nihatturanodeva9.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.fragment_listeleme.*
import kotlinx.android.synthetic.main.fragment_detay.*

class Main : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        binding.hakkindaButton.setOnClickListener { view ->
            val intent = Intent(this,HakkimdaActivity::class.java)
            startActivity(intent)
        }

        val listView = findViewById<ListView>(R.id.listView)
        val names = arrayOf("İstanbul","Ankara","İzmir","Antalya","Trabzon","Eskişehir","Manisa")
        val arrayAdapter: ArrayAdapter<String> = ArrayAdapter(
            this, android.R.layout.simple_list_item_1, names
        )

        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val intent = Intent(this, DataBundleActivity::class.java)
            val bundle = Bundle()

            bundle.putString("secilenYazi", names[i])
            intent.putExtras(bundle)
            startActivity(intent)
            finish()
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}