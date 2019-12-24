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
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions

class FragmentMapTwo(allWomen:AllWomenLoader) : Fragment(), OnMapReadyCallback {

    val TAG = "FragmentTwo"
    lateinit var mapFragment: SupportMapFragment
    private lateinit var mMap: GoogleMap
     var allWomenLoaderClass: AllWomenLoader=allWomen
    val allWomenLoaderList:  ArrayList<Women> = allWomenLoaderClass.getTheWholeWholeList()
    override fun onAttach(context: Context) {
        Log.d(TAG, "onAttach") //fot recording each change of fragment by showing the msg
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
        return inflater.inflate(
            R.layout.activity_fragment_map_two,
            container,
            false
        ) //inflate the layout
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        mapFragment = childFragmentManager.findFragmentById(R.id.MAPS) as SupportMapFragment
        mapFragment.getMapAsync(this)
        super.onStart()
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

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {


        mMap = googleMap
        // Add women's markers and move the camera

        for (index in 1..allWomenLoaderClass.getNumberOfFemmes()) {
            val name = allWomenLoaderList[index - 1].fields.name
            val x = allWomenLoaderList[index - 1].fields.geo_point_2d[0]
            val y = allWomenLoaderList[index - 1].fields.geo_point_2d[1]
            val latLng = LatLng(x, y)
            val infoStr = allWomenLoaderClass.returnOneWoman(index - 1)

            val infoUrl=allWomenLoaderClass.returnWomanUrl(index-1)

            val markerOptions = MarkerOptions().position(latLng).snippet(infoStr)

            mMap.animateCamera(CameraUpdateFactory.zoomTo(15f))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
            mMap.addMarker(markerOptions.title(name))
        }
        mMap.setOnMarkerClickListener(GoogleMap.OnMarkerClickListener() { marker ->
            onMarkerClick(marker)
            true
        })
    }

    fun onMarkerClick(p0: Marker?): Boolean {
        // Do something extra here
        val intent = Intent(context, WomanActivity::class.java)

        // Send the info of specifieed woman
        Toast.makeText(context, p0!!.title, Toast.LENGTH_SHORT).show()
        intent.putExtra("signal", p0.snippet)


        startActivity(intent)

        return true
    }

}
