package com.ismin.opendataapp

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.*
import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.ismin.opendataapp.webservice.WomanWebService
import java.nio.charset.Charset

class AllWomenLoader {

    var womenList:   ArrayList<Women> =ArrayList<Women>()


    constructor (){
        loadList()
    }

    fun loadList() {

        val  requete= WomanWebService()
        womenList= requete.gettingDatafromServer()

    }

    //add a femme to the femmeList by Femme object
    fun addWomen(women: Women) {
        womenList.add(women)
    }


    //get a femme from femmeList by using recordid
    fun getWomen(recordid: Int): Women? {
        val storedWomen = womenList.find { women: Women -> women.recordid.equals(recordid) }
        return storedWomen
    }

    //return the number of women in the womenList
    fun getNumberOfFemmes(): Int {
        val numOfFemmes: Int = womenList.count()
        return numOfFemmes
    }

    //delete all women in the womenList
    fun deleteAllinWomenList() {
        womenList.clear()
    }

    //get the list "womenList"
    fun getTheWholeWholeList(): ArrayList<Women>{
        return womenList
    }

    fun returnOneWoman(index: Int): String {
//        val str =
//            "ID: " + womenList[index].recordid + "\nCoordinate: (" + womenList[index].fields.geo_point_2d[0] + ", " +
//                    womenList[index].fields.geo_point_2d[1] + ") \nName: " + womenList[index].fields.name + "\nInfo: " +
//                    womenList[index].fields.desc1 + "\n" + womenList[index].fields.desc2 + "\nThumb_url: " + womenList[index].fields.thumb_url +
//                    "\nTab_name: " + womenList[index].fields.tab_name
        val str =
            "Name: " + womenList[index].fields.name + "\n" +
                    "Address: " + womenList[index].fields.short_desc + "\n" +
                    "Description: " + "\n" + womenList[index].fields.desc1 + womenList[index].fields.desc2

        return str
    }

    fun returnWomanUrl(index:Int):String{
        val url=womenList[index].fields.thumb_url
        return url
    }


}

