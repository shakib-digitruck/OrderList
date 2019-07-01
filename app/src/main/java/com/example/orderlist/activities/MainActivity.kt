package com.example.orderlist.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import com.example.orderlist.fragments.Ongoing
import com.example.orderlist.R
import com.example.orderlist.fragments.Shipment

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val manager = supportFragmentManager
        val transaction = manager!!.beginTransaction()
        val fragment = Shipment()
        transaction.replace(R.id.fragment, fragment)
        transaction.addToBackStack(null)
        transaction.commit()



        buttonOngoing.setOnClickListener {
            val manager = supportFragmentManager
            val transaction = manager!!.beginTransaction()
            val fragment = Ongoing()
            transaction.replace(R.id.fragment, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        buttonShipment.setOnClickListener {
            val manager = supportFragmentManager
            val transaction = manager!!.beginTransaction()
            val fragment = Shipment()
            transaction.replace(R.id.fragment, fragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }
    }
}
