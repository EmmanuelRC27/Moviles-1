package com.example.contactmanageremma

import android.annotation.SuppressLint
import Util.Util
import android.widget.Button
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.createBitmap
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val btnAddContact: Button = findViewById<Button>(R.id.btnAddContact)
        btnAddContact.setOnClickListener(View.OnClickListener {
            Util.openActivity(this,AddContactActivity::class.java)
        })

            val btnViewContactList: Button = findViewById<Button>(R.id.BtnViewContactList)
        btnViewContactList.setOnClickListener(View.OnClickListener {
            Util.openActivity(this,ViewContactListActivity::class.java)
            })
        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.mnu_Contact -> {
                Util.openActivity(this, AddContactActivity::class.java)
                return true
            }
            R.id.mnu_ContactList -> {
               Util.openActivity(this, ViewContactListActivity::class.java)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }



}
