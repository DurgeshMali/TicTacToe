package com.example.tictactoe

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.tictactoe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    private var combinationList: List<IntArray> = ArrayList()
    private var boxPositions = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0) //9 zero
    private var playerTurn = 1
    private var totalSelectedBoxes = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding!!.getRoot());

        combinationList.toMutableList().add(intArrayOf(0,1,2))
        combinationList.toMutableList().add(intArrayOf(3,4,5))
        combinationList.toMutableList().add(intArrayOf(6,7,8))
        combinationList.toMutableList().add(intArrayOf(0,3,6))
        combinationList.toMutableList().add(intArrayOf(1,4,7))
        combinationList.toMutableList().add(intArrayOf(2,5,8))
        combinationList.toMutableList().add(intArrayOf(2,4,6))
        combinationList.toMutableList().add(intArrayOf(0,4,8))

        var getPlayerOneName = intent.getStringExtra("playerOne")
        var getPlayerTwoName = intent.getStringExtra("playerTwo")

        binding!!.playerOneName.setText(getPlayerOneName)
        binding!!.playerTwoName.setText(getPlayerTwoName)


    }

    private fun performAction(imageView: ImageView, selectedBoxPosition:Int) {
        boxPositions[selectedBoxPosition] = playerTurn

        if(playerTurn == 1) {
            imageView.setImageResource(R.drawable.ximage)
            if(checkResults()) {
                var resultDialog = ResultDialog(this@MainActivity, binding!!.playerOneName.text.toString() + " is a Winner!", this@MainActivity)
                resultDialog.setCancelable(false)
                resultDialog.show()
            }
            else if(totalSelectedBoxes == 9) {
                val resultDialog = ResultDialog(this@MainActivity, "Match Draw", this@MainActivity)
                resultDialog.setCancelable(false)
                resultDialog.show()
            }
            else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        }
        else {
            imageView.setImageResource(R.drawable.ximage)
            if(checkResults()) {
                var resultDialog = ResultDialog(this@MainActivity, binding!!.playerTwoName.text.toString() + " is a Winner!", this@MainActivity)
                resultDialog.setCancelable(false)
                resultDialog.show()
            }
            else if(totalSelectedBoxes == 9) {
                val resultDialog = ResultDialog(this@MainActivity, "Match Draw", this@MainActivity)
                resultDialog.setCancelable(false)
                resultDialog.show()
            }
            else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        }
    }

    private fun changePlayerTurn(currentPlayerTurn:Int) {
        playerTurn = currentPlayerTurn
        if(playerTurn == 1) {
            binding?.playerOneLayout?.setBackgroundResource(R.drawable.black_border)
            binding?.playerTwoLayout?.setBackgroundResource(R.drawable.white_box)
        }
        else {
            binding?.playerTwoLayout?.setBackgroundResource(R.drawable.black_border)
            binding?.playerOneLayout?.setBackgroundResource(R.drawable.white_box)
        }
    }

    private fun checkResults(): Boolean {
        var response = false
        for (i in combinationList.indices) {
            val combination = combinationList[i]
            if (boxPositions[combination[0]] === playerTurn && boxPositions[combination[1]] === playerTurn && boxPositions[combination[2]] === playerTurn) {
                response = true
            }
        }
        return response
    }

    private fun isBoxSelectable(boxPosition: Int): Boolean {
        var response = false
        if (boxPositions[boxPosition] === 0) {
            response = true
        }
        return response
    }

    public fun restartMatch() {
        boxPositions = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0, 0) //9 zero
        playerTurn = 1
        totalSelectedBoxes = 1

        binding?.image1?.setImageResource(R.drawable.white_box)
        binding?.image2?.setImageResource(R.drawable.white_box)
        binding?.image3?.setImageResource(R.drawable.white_box)
        binding?.image4?.setImageResource(R.drawable.white_box)
        binding?.image5?.setImageResource(R.drawable.white_box)
        binding?.image6?.setImageResource(R.drawable.white_box)
        binding?.image7?.setImageResource(R.drawable.white_box)
        binding?.image8?.setImageResource(R.drawable.white_box)
        binding?.image9?.setImageResource(R.drawable.white_box)
    }

}