package com.example.tictactoe

import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.Button
import android.widget.TextView

class ResultDialog(
    context: Context,
    private val message: String,
    private val mainActivity: MainActivity
) : Dialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_dialog)

        var messageText = findViewById<TextView>(R.id.messageText)
        val startAgainButton = findViewById<Button>(R.id.startAgainButton)

        messageText.text = message

        startAgainButton.setOnClickListener {
            mainActivity.restartMatch()
            dismiss()
        }
    }
}