package net.nathan.learndebeging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.widget.TextView

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val text: TextView = findViewById(R.id.text)
        val citations = arrayOf(
            "Toute notre vie se passe à errer autour de notre tombe.",
            "L'homme qui pratique la lucidité pendant toute sa vie devient un classique du désespoir.",
            "Que c'est bon d'aimer la vie et de la risquer sans cesse.",
            "Une vie vécue dans le bonheur est une vie vécue dans le silence.",
            "La vie ne vaut pas la peine qu’on la quitte.",
            "La vie est un message griffonné dans le noir.",
            "La vie est plus belle que la prudence.",
            "J'ai gâché ma vie par dissipation morale seul dans mon coin.",
            "Je fais du théâtre pour ressentir les sensations que la vie ne m'apporte pas...",
            "Lorsqu'on sourit à la vie, elle vous rend ses sourires.",
            "Philosopher, c'est penser sa vie et vivre sa pensée.",
            "Toute vie est une manifestation de l'esprit, la manifestation de l'amour.",
            "La voie de l'immortalité est déjà d'avoir une vie digne de s'en souvenir.",
            "Si vous voulez que la vie vous sourie, apportez-lui d'abord votre bonne humeur.",
            "Il est temps de vivre la vie que tu t'es imaginée.",
            "Ne pas estimer la vie, toute la vie, ce n'est pas la mériter.",
            "Ce que j'ai cherché toute ma vie, c'est à comprendre le mystère de la nature humaine.",
            "Ne pas estimer la vie, toute la vie, c'est ne pas la mériter.",
            "La vertu publique est le seul esprit de vie des états.",
            "Les hommes passent leur vie à regarder les femmes et les femmes à se regarder...",
            "Vivre plus d’une vie induit de mourir plus d’une mort.",
            "Ni sa santé, ni son amour, ni sa raison ne parvenaient à la convaincre de vivre.",
            "Notre amour est beau parce qu'il est impossible.",
            "Notre amour était devenu une liaison avec un commencement et une fin.",
            "En amour, la patience a ses vertus.",
            "Un livre est toujours peu ou prou, un amour enterré."
        )
        text.text = citations[0]
        logging()
        // division()
        startTimeCounter(text, citations)
    }
    fun startTimeCounter(text : TextView, citations : Array<String>) {
        val randIndex = 0..(citations.size)
        object : CountDownTimer(50000, 10000) {
            override fun onTick(millisUntilFinished: Long) {
                val randCitations : String = citations[randIndex.random()]
                text.text = randCitations

            }
            override fun onFinish() {
                startTimeCounter(text, citations)
            }
        }.start()

    }

    fun logging() {
        Log.e(TAG, "ERROR: a serious error like an app crash")
        Log.w(TAG, "WARN: warns about the potential for serious errors")
        Log.i(TAG, "INFO: reporting technical information, such as an operation succeeding")
        Log.d(TAG, "DEBUG: reporting technical information useful for debugging")
        Log.v(TAG, "VERBOSE: more verbose than DEBUG logs")

    }
    fun division() {
        val numerator = 60
        var denominator = 4
        repeat(5) {
            Log.v(TAG, "${numerator / denominator} | ${numerator} / ${denominator}")
            denominator--
        }
    }
}
