package com.ismin.opendataapp

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.ismin.opendataapp.webservice.WomanWebService


class MainActivity : AppCompatActivity() {


    val manager = supportFragmentManager
    var allWomenLoaderClass: AllWomenLoader=AllWomenLoader()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = findViewById<Button>(R.id.list)
        val map = findViewById<Button>(R.id.MAPS)
        val info = findViewById<Button>(R.id.information)

        list.setOnClickListener() {
            ShowFragmentOne()
        }
        map.setOnClickListener() {

            ShowFragmentMapTwo()
        }

        info.setOnClickListener() {
            ShowFragmentFour()
        }
    }

    fun ShowFragmentOne() {
        val transaction = manager.beginTransaction()
        val frag = FragmentOne(allWomenLoaderClass)
        transaction.replace(R.id.a_main, frag) //replace the using one when you want to use another
        transaction.addToBackStack(null)
        transaction.commit()
    }

    fun ShowFragmentMapTwo() {
        val transaction = manager.beginTransaction()
        val frag = FragmentMapTwo(allWomenLoaderClass)
        transaction.replace(R.id.a_main, frag) //replace the using one when you want to use another
        transaction.addToBackStack(null)
        transaction.commit()
    }


    fun ShowFragmentFour() {
        val transaction = manager.beginTransaction()
        val frag = FragmentFour()
        transaction.replace(R.id.a_main, frag) //replace the using one when you want to use another
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
