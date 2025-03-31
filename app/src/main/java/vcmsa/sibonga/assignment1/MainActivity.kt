package vcmsa.sibonga.assignment1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } //end of ViewCompact

        //code starts here

        //Getting UI components from layout
  
        val inputTime: EditText = findViewById(R.id.editTextText)
        val btnSuggest: Button = findViewById(R.id.btnSuggest)
        val btnReset: Button = findViewById(R.id.btnReset)
        val textSuggestion:TextView=findViewById(R.id.textSuggestion)

        //Button click listener to provide meal suggestions
        btnSuggest.setOnClickListener {
            val timeOfDay = inputTime.text.toString().trim().lowercase()
            val suggestion = getMealSuggestion(timeOfDay)
            textSuggestion.text=suggestion
        }

        //Button click listener to reset input and output fields
        btnReset.setOnClickListener {
            inputTime.text.clear()

        }
    }

    //Function to return meal suggestion based on time of day
    private fun getMealSuggestion(time:String) : String{
        return when (time) {
       "morning"->" Eggs for breakfast"
        "mid-morning"->"Healthy Fruit Snack"
        "afternoon" -> "A PB&J sandwich"
        "mid-afternoon"-> " A slice of cake"
        "dinner" -> "Pasta would be great"
        "after"->"End the day of with some Ice Cream"
        else-> "Please enter a valid time of day(e.g., 'morning','afternoon')."
        }
    }
}
