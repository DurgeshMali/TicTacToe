package com.example.tictactoe

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    private val combinationList: List<IntArray> = ArrayList()
    private val boxPositions = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0) //9 zero
    private val playerTurn = 1
    private val totalSelectedBoxes = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }
}