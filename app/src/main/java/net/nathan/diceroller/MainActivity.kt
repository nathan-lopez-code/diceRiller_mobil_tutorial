package net.nathan.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.button)


        rollButton.setOnClickListener{
            //Toast.makeText(this, "roll : ${r}", Toast.LENGTH_SHORT).show()
            roll()
        }
    }
    private fun roll(){
        val side = 6
        val diceText: TextView = findViewById(R.id.mytext)
        val dice = Dice(side)

        diceText.text = dice.roll().toString()
    }
}

class Dice(private val side: Int){
    fun roll() : Int{
        return (1..side).random()
    }
}