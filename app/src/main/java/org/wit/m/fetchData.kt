package org.wit.m


import android.os.AsyncTask
import com.google.android.gms.maps.GoogleMap
import org.json.JSONObject
import org.json.JSONArray
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.gson.JsonArray
import org.json.JSONException
import java.io.IOException



abstract class FetchData : AsyncTask<Any?, String?, String?>() {
    var googleNearByPlacesData: String? = null
    var googleMap: GoogleMap? = null
    var url: String? = null

    override fun onPostExecute(s: String?) {
        try {
            val jsonObject = JSONObject()
            val jsonArray = jsonObject.getJSONArray("results")
            //for (int i=0; i<jsonArray.length();i++)
            val arr = IntArray(0)
            for (i in arr.indices) {
                print(arr[i])

                val jsonObject1 = jsonArray.getJSONObject(i)
                val getLocation = jsonObject1.getJSONObject("geometry")
                    .getJSONObject("location")
                val lat = getLocation.getString("lat")
                val lng = getLocation.getString("lng")
                val getName = jsonArray.getJSONObject(i)
                var name: String
                getName.getString("name")
                val latlng = LatLng(lat.toDouble(), lng.toDouble())
                val markerOptions = MarkerOptions()
                //markerOptions.title(name)
                markerOptions.position(latlng)
                googleMap!!.addMarker(markerOptions)
                googleMap!!.moveCamera(CameraUpdateFactory.newLatLngZoom(latlng, 15f))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        super.onPostExecute(s)
    }

    //override fun doInBackground(vararg objects: Any) {
   //     try {
     //       googleMap = objects[0] as GoogleMap
       //     url = objects[1] as String
         //   val downloaodUrl = DownloadUrl<Any>()
          //  googleNearByPlacesData = downloaodUrl.retrieveUrl(url)
        //} catch (e: IOException) {
          //  e.printStackTrace()
       // }
    //}



}
