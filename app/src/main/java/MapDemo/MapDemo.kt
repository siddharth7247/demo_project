package MapDemo

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.demo.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.tasks.Task
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MapDemo : AppCompatActivity(), OnMapReadyCallback {
    lateinit var myMap: GoogleMap
    lateinit var btnMyLocation: FloatingActionButton
    lateinit var mFusedLocationClient: FusedLocationProviderClient
    lateinit var currentLocation: LatLng
    lateinit var searchView: androidx.appcompat.widget.SearchView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map_demo)

        currentLocation = LatLng(23.0225, 72.57)
        btnMyLocation = findViewById(R.id.btnMyLocation)
        searchView = findViewById(R.id.searchView)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        btnMyLocation.setOnClickListener {
            if (ContextCompat.checkSelfPermission(
                    this,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_DENIED
            ) {
                requestPermission()
            } else {
                getLocation()
            }
        }
//        searchView.setOnQueryTextListener(OnQueryTextListener {
//            override fun onQueryTextChange(p0: String?): Boolean {
//                val location = searchView.query.toString()
//                var addressList: List<Address>? = null
//                if (location.isNotEmpty()) {
//                    val geocoder = Geocoder(this@MapDemo)
//                    try {
//                        addressList = geocoder.getFromLocationName(location, 1)
//                    } catch (e: IOException) {
//                        e.printStackTrace()
//                    }
//                    val address = addressList?.get(0)
//                    val latLng = LatLng(address?.latitude ?: 0.0, address?.longitude ?: 0.0)
//                    myMap.addMarker(MarkerOptions().position(latLng).title(location))
//                    myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 10f))
//                }
//                return false
//            }
//        })


    }

    override fun onMapReady(googleMap: GoogleMap) {
        myMap = googleMap
        myMap.setOnMapLongClickListener(GoogleMap.OnMapLongClickListener { latLng ->
            currentLocation = LatLng(latLng.latitude, latLng.longitude)
            myMap.clear()
            val location = Location("Test")
            location.latitude = latLng.latitude
            location.longitude = latLng.longitude
            var address = getAddress(location)

            myMap.addMarker(
                MarkerOptions().position(currentLocation).title(address).icon(
                    BitmapDescriptorFactory.fromResource(R.drawable.locationhome)
                )
            )
            myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 16F))

        })
        myMap.setOnMarkerClickListener(OnMarkerClickListener { marker ->
            val markerName = marker.title
            Toast.makeText(this, "location is $markerName", Toast.LENGTH_SHORT)
                .show()
            false
        })

    }

    @SuppressLint("MissingPermission")
    fun getLocation() {
        val task: Task<Location> = mFusedLocationClient.lastLocation
        task.addOnSuccessListener { location ->
            if (location != null) {
                currentLocation = LatLng(location.latitude, location.longitude)
                val address = getAddress(location)
                myMap.addMarker(
                    MarkerOptions().position(currentLocation).title(address).icon(
                        BitmapDescriptorFactory.fromResource(R.drawable.locationhome)
                    )
                )
                myMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLocation, 16F))

                val supportMapFragment =
                    checkNotNull(supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?)
                supportMapFragment.getMapAsync(this)
            }
        }
    }

    private fun getAddress(location: Location): String? {
        val geocoder = Geocoder(this)
        val list = geocoder.getFromLocation(location.latitude, location.longitude, 1)
        return list!![0]?.getAddressLine(0)
    }

    fun requestPermission() {
        ActivityCompat.requestPermissions(
            this,
            arrayOf(
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ),
            10
        )
    }
}