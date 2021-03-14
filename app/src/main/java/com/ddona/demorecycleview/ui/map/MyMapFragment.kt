package com.ddona.demorecycleview.ui.map

import android.graphics.Color
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.ddona.demorecycleview.ui.model.MapDirectionViewModel
import androidx.lifecycle.Observer
import com.ddona.demorecycleview.R
import com.ddona.demorecycleview.model.MapDirection
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.*


class MyMapFragment : SupportMapFragment(), OnMapReadyCallback,
    GoogleMap.OnInfoWindowClickListener, GoogleMap.InfoWindowAdapter {
    private lateinit var mMap: GoogleMap
    private lateinit var mModel: MapDirectionViewModel
    private var line: Polyline? = null
    private var markers = mutableListOf<Marker>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mModel = MapDirectionViewModel()
        register()
        getMapAsync(this)
    }

    private fun register() {
        mModel.mapDirection.observe(this, Observer {
            finishGetDirection(it)
        })
    }

    private fun finishGetDirection(data: MapDirection) {
        if (data.geocoded_waypoints[0].geocoder_status == "OK") {
            val latLongs = mutableListOf<LatLng>()
            var index = 0
            for (step in data.routes[0].legs[0].steps) {
                if (index == 0) {
                    latLongs.add(
                        LatLng(
                            step.start_location.lat,
                            step.start_location.lng
                        )
                    )
                }
                latLongs.add(
                    LatLng(
                        step.end_location.lat,
                        step.end_location.lng
                    )
                )
                index++
            }

            if (line == null) {
                val lineOp = PolylineOptions()
                for (latLong in latLongs) {
                    lineOp.add(latLong)
                }
                lineOp.color(Color.GREEN)
                lineOp.width(10f)
                line = this.mMap.addPolyline(lineOp)
            } else {
                line!!.points = latLongs
            }
            addMarkers(latLongs)
            //zoom
            mMap.animateCamera(
                CameraUpdateFactory.newCameraPosition(
                    CameraPosition(latLongs[0], 13f,0f,0f)
                )

            )
        }
    }

    private fun addMarkers(latlongs:MutableList<LatLng>){
        for (marker in markers) {
            marker.remove()
        }
        markers.clear()
        for (latlong in latlongs) {
            val markerOp = MarkerOptions()
                .icon(BitmapDescriptorFactory.defaultMarker(
                    BitmapDescriptorFactory.HUE_RED
                ))
                .position(latlong)
                .title("My localtion")
                .snippet(getLocationString(
                    latlong.latitude, latlong.longitude
                ))
            markers.add(
               mMap.addMarker(markerOp)
            )
        }
    }

    override fun onMapReady(map: GoogleMap) {
        mMap = map
        mMap.uiSettings.isScrollGesturesEnabled=true
        mMap.uiSettings.isZoomControlsEnabled=true
        mMap.uiSettings.isMyLocationButtonEnabled=true

        //set ui when clicking into marker
        mMap.setInfoWindowAdapter(this)
    }

    fun searchDirection(origin: String, destination: String) {
        mModel.direction(origin, destination)
    }

    private fun getLocationString(lat: Double, log: Double): String {
        val geo = Geocoder(context)
        val addresss = geo.getFromLocation(lat, log, 1)
        if (addresss == null || addresss.size == 0) {
            return "Unknow"
        }
        val add = addresss.get(0)
        var addString = add.getAddressLine(0)
        for (i in 1..add.maxAddressLineIndex - 1) {
            addString += (", " + add.getAddressLine(i))
        }
        addString += ", " + add.countryName
        return addString
    }

    override fun getInfoContents(marker: Marker): View? {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.map_popup, null)
        val tv:TextView = view.findViewById(R.id.tv_content)
        tv.setText(marker.snippet)
        return view
//        return null
    }

    override fun getInfoWindow(marker: Marker): View? {
//        val view = LayoutInflater.from(context)
//            .inflate(R.layout.map_popup, null)
//        val tv:TextView = view.findViewById(R.id.tv_content)
//        tv.setText(marker.snippet)
//        return view
        return null
    }

    override fun onInfoWindowClick(p0: Marker?) {

    }
}