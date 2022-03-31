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
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import java.lang.RuntimeException
import java.util.regex.Pattern

class HomeFragment : Fragment() {
    private lateinit var listener: HomeFragmentListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is HomeFragmentListener){
            listener = context
        } else {
            throw RuntimeException("$context must implement HomeFragment.HomeFragmentInterface")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        fun passwordChecker(password: String): Boolean {
            return Pattern.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@\$!%*#?&])[A-Za-z\\d@\$!%*#?&]{8,}\$", password)
        }

        fun emailChecker(email: String): Boolean {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        }

        super.onViewCreated(view, savedInstanceState)

        val email = view.findViewById<EditText>(R.id.editTextEmail)
        val password = view.findViewById<EditText>(R.id.editTextPassword)
        val checkBox = view.findViewById<CheckBox>(R.id.checkBoxAccept)
        val button = view.findViewById<Button>(R.id.loginButton)

        var isValidEmail = false
        var isValidPassword = false
        var isCheckedBox = false


        email.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isValidEmail = emailChecker(p0.toString())
                button.isEnabled = isValidEmail && isValidPassword && isCheckedBox
            }
        })

        password.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                isValidPassword = passwordChecker(p0.toString())
                button.isEnabled = isValidEmail && isValidPassword && isCheckedBox
            }
        })

        checkBox.setOnClickListener {
            isCheckedBox = checkBox.isChecked
            button.isEnabled = isValidEmail && isValidPassword && isCheckedBox
        }

        view.findViewById<Button>(R.id.loginButton).setOnClickListener {
            listener.OnHelloClickListener(email.text.toString())
        }
    }

    interface HomeFragmentListener {
        fun OnHelloClickListener(email: String)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment().apply{}

    }
}