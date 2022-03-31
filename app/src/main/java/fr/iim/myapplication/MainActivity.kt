package fr.iim.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.GoogleMap

class MainActivity : AppCompatActivity(), HomeFragment.HomeFragmentListener, HelloFragment.HelloFragmentListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, HomeFragment.newInstance())
            .commitNow()

    }

    override fun OnHelloClickListener(email: String) {
        Log.d(LOG_TAG, "click event sent $email")

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainContainer, HelloFragment.newInstance(email))
            .commitNow()
    }

    override fun OnMapClickListener(city: String){
        val intent = Intent(this, MapsActivity::class.java)
        startActivity(intent)
    }

    companion object {
        private val LOG_TAG = "MainActivity"
    }

}
