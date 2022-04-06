package net.nathan.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
// import android.widget.TextView

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
        val diceImage: ImageView = findViewById(R.id.myimage)
        val dice = Dice(side).roll()

        val draw = when(dice){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        diceImage.setImageResource(draw)
        diceImage.contentDescription = dice.toString()

    }

}

class Dice(private val side: Int){
    fun roll() : Int{
        return (1..side).random()
    }
}