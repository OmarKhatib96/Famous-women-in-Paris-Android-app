package com.ismin.opendataapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class FragmentOne(allWomen:AllWomenLoader) : Fragment(), OnWomanClickListener {

    lateinit var recyclerView: RecyclerView
    lateinit var womenadapter: ListAdapter
    var allWomenLoaderClass: AllWomenLoader=allWomen
    val allWomenLoaderList:  ArrayList<Women> = allWomenLoaderClass.getTheWholeWholeList()


    val TAG = "FragmentOne"
    override fun onAttach(context: Context) {
        Log.d(TAG, "onAttach") //for recording each change of fragment by showing the msg
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")

        val rootfrag =
            inflater.inflate(R.layout.fragment_one, container, false) //inflate the layout
        recyclerView = rootfrag.findViewById(R.id.list_weman)

        // specify an adapter
        womenadapter = ListAdapter(allWomenLoaderList, context, this)
        recyclerView.adapter = womenadapter


        // use a linear layout manager
        val layoutManager = LinearLayoutManager(activity)
        recyclerView.layoutManager = layoutManager

        return rootfrag

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()
        //jsonText.text="FUCK"
        //readJson()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach")
        super.onDetach()
    }

    override fun onWomanClick(woman: Women, position: Int) {
        Toast.makeText(context, woman.fields.name, Toast.LENGTH_SHORT).show()

        val intent = Intent(context, WomanActivity::class.java)

        val str =
            "Name: " + woman.fields.name + "\n" +
            "Address: " + woman.fields.short_desc + "\n" +
            "Description: " + "\n" + woman.fields.desc1 + woman.fields.desc2

        intent.putExtra("signal", str)



        val imgUrl= woman.fields.thumb_url

        intent.putExtra("img", imgUrl)

        startActivity(intent)
    }
}