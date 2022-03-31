package fr.iim.myapplication

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.RuntimeException


class HelloFragment : Fragment() {
    private lateinit var listener: HelloFragmentListener

    private var firstName: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HelloFragmentListener){
            listener = context
        } else {
            throw RuntimeException("$context must implement HomeFragment.HomeFragmentInterface")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            firstName = it.getString(ARG_FIRST_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hello, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val editTextCity = view.findViewById<EditText>(R.id.editTextCity)
        val searchButton = view.findViewById<Button>(R.id.searchButton)

        if(firstName != null)
            view.findViewById<TextView>(R.id.fragHelloTextView).text = getString(R.string.hello, firstName)
        else
            view.findViewById<TextView>(R.id.fragHelloTextView).text = "No firstName"

        editTextCity.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                searchButton.isEnabled = editTextCity.text.isNotEmpty()
            }
        })

        searchButton.setOnClickListener {
            listener.OnMapClickListener(editTextCity.text.toString())
        }

    }

    interface HelloFragmentListener {
        fun OnMapClickListener(city: String)
    }

    companion object {
        private const val ARG_FIRST_NAME = "firstName"

        @JvmStatic
        fun newInstance(firstName: String) =
            HelloFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_FIRST_NAME, firstName)
                }
            }
    }
}