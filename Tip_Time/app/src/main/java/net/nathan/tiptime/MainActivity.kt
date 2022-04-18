package net.nathan.tiptime

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import net.nathan.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    private lateinit var b : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)      // connexion at the root view of UI

        /* old way
        * val myButton : Button = findViewById(R.id.nom_id)
        * myButton.setOnClickListener{
        *  instructions ...}*/

        // news way
        b.calculate.setOnClickListener{
            calculateTip(it)
            NumberFormat.getCurrencyInstance()
        }
        // hide the keyboard when user pressed enter button
        b.serviceCost.setOnKeyListener{
            view, keyCode, _ -> handleKeyEvnet(view, keyCode)
        }

    }
    private fun calculateTip(view: View){
        val cost = b.firstInputEdit.text.toString().toDoubleOrNull()
        if (cost == null){
            b.amount.text = ""
            Toast.makeText(this, R.string.please_enter_value, Toast.LENGTH_SHORT).show()
            return
        }else if(cost == 0.0){
            b.amount.text = ""
            Toast.makeText(this, R.string.zero_value, Toast.LENGTH_SHORT).show()
            return
        }

        // take the check button of checking button group
        val tipPercentage = when( b.tipOption.checkedRadioButtonId){
            R.id.fifteen_percent -> 0.15
            R.id.twenty_percent -> 0.20
            // R.id.eighteen_percent -> 0.18
            else -> 0.18
        }
        var tip = tipPercentage * cost
        // checking if the radio button is one
        if (b.rounded.isChecked){
            tip = kotlin.math.ceil(tip)
        }
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
        b.amount.text = getString(R.string.amount, NumberFormat.getInstance().format(tip))

    }
    // add an events listener for hid keyboard when the user press enter
    private fun handleKeyEvnet(view : View, keyCode: Int): Boolean{
        if(keyCode == KeyEvent.KEYCODE_ENTER){
            // hide the keyboard
            val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
            return true
        }
        return false
    }
}