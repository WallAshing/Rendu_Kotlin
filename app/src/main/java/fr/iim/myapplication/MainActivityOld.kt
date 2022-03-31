package fr.iim.myapplication

import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivityOld : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

//        findViewById<TextView>(R.id.main_content).setText(R.string.hello_b_bou)
//        findViewById<TextView>(R.id.main_content).text = getString(R.string.hello_b_bou)
//        val textFirstName: TextView = findViewById(R.id.helloFirstName)
//        val editTextFirstName: EditText = findViewById(R.id.editTextFirstName)
//        val edittextButton: Button = findViewById(R.id.editTextButton)



//        textFirstName.visibility = View.INVISIBLE

//        edittextButton.setOnClickListener {
//
//            Toast.makeText(applicationContext, getString(R.string.hello, editTextFirstName.text) , Toast.LENGTH_SHORT).show()
//
//            startActivity(HelloActivity.newInstance(this, editTextFirstName.text.toString()))
//        }

    }
}
