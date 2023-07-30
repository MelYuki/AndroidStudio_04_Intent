package be.melyuki.demo04_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    companion object {
        // Champs pour éléments statics
        val ANSWER_COLOR = "ANSWER_COLOR"
    }

    lateinit var btnGreen : Button
    lateinit var btnPurple : Button
    lateinit var btnBlue : Button
    lateinit var btnNone : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        // Binding
        btnGreen = findViewById(R.id.btn_question_green)
        btnPurple = findViewById(R.id.btn_question_purple)
        btnBlue = findViewById(R.id.btn_question_blue)
        btnNone = findViewById(R.id.btn_question_none)

        // Listener
        btnGreen.setOnClickListener(this)
        btnPurple.setOnClickListener(this)
        btnBlue.setOnClickListener(this)
        btnNone.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_question_green -> answerSucess("Vert")
            R.id.btn_question_purple -> answerSucess("Mauve")
            R.id.btn_question_blue -> answerSucess("Bleu")
            R.id.btn_question_none -> answerNone()
        }
    }

    private fun answerSucess(color: String) {
        // Créa d'un Intent pour stocker les data
        val data : Intent = Intent().apply {
            putExtra(ANSWER_COLOR, color)
        }

        setResult(RESULT_OK, data)
        finish()
    }

    private fun answerNone() {
        setResult(RESULT_CANCELED)
        finish()
    }
}