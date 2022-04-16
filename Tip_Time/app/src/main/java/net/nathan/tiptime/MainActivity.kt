package net.nathan.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
            calculateTip()
            NumberFormat.getCurrencyInstance()
        }

    }
    private fun calculateTip(){
        val cost = b.firstInput.text.toString().toDoubleOrNull()
        if(cost == null || cost == 0.0){
            b.amount.text = ""
            Toast.makeText(this, R.string.please_enter_value, Toast.LENGTH_SHORT).show()
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
        b.amount.text = getString(R.string.amount, NumberFormat.getInstance().format(tip))

    }
}