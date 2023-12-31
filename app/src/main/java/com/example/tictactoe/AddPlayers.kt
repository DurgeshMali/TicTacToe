package com.example.tictactoe

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class AddPlayers : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_players)

        var playerOne = findViewById<EditText>(R.id.playerOne)
        var playerTwo = findViewById<EditText>(R.id.playerTwo)
        var startGameButton = findViewById<Button>(R.id.startGameButton)

        startGameButton.setOnClickListener {
            var getPlayerOneName = playerOne.text.toString()
            var getPlayerTwoName = playerTwo.text.toString()
            if (getPlayerOneName.isEmpty() || getPlayerTwoName.isEmpty()) {
                Toast.makeText(this@AddPlayers, "Please enter player name", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val intent = Intent(this@AddPlayers, MainActivity::class.java)
                intent.putExtra("playerOne", getPlayerOneName)
                intent.putExtra("playerTwo", getPlayerTwoName)
                startActivity(intent)
            }
        }
    }
}