package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.tictactoe.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val game: MutableList<MutableList<String>> = mutableListOf(
        mutableListOf("", "", ""),
        mutableListOf("", "", ""),
        mutableListOf("", "", "")
    )

    private var win: Boolean = false
    private var turn: Boolean = true
    private var symbol: String = ""
    private var score1: Int = 0
    private var score2: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        positionGame()
        resetGameButton()
    }

    private fun playerTurn(): Int {
        return if (turn) {
            turn = false
            binding.layoutLay.setBackgroundColor(getColor(R.color.pink))
            symbol = "o"
            1
        } else {
            turn = true
            binding.layoutLay.setBackgroundColor(getColor(R.color.green))
            symbol = "x"
            2
        }
    }

    private fun positionGame() {
        binding.imageButtonFirst.setOnClickListener {
            if (game[0][0] == "" && !win) {
                (it as ImageButton).setImageLevel(playerTurn())
                game[0][0] = symbol
                winCondition()
            }
        }
        binding.imageButtonSecond.setOnClickListener {
            if (game[0][1] == "" && !win) {
                (it as ImageButton).setImageLevel(playerTurn())
                game[0][1] = symbol
                winCondition()
            }
        }
        binding.imageButtonThird.setOnClickListener {
            if (game[0][2] == "" && !win) {
                (it as ImageButton).setImageLevel(playerTurn())
                game[0][2] = symbol
                winCondition()
            }
        }
        binding.imageButtonFourth.setOnClickListener {
            if (game[1][0] == "" && !win) {
                (it as ImageButton).setImageLevel(playerTurn())
                game[1][0] = symbol
                winCondition()
            }
        }
        binding.imageButtonFifth.setOnClickListener {
            if (game[1][1] == "" && !win) {
                (it as ImageButton).setImageLevel(playerTurn())
                game[1][1] = symbol
                winCondition()
            }
        }
        binding.imageButtonSixth.setOnClickListener {
            if (game[1][2] == "" && !win) {
                (it as ImageButton).setImageLevel(playerTurn())
                game[1][2] = symbol
                winCondition()
            }
        }
        binding.imageButtonSeventh.setOnClickListener {
            if (game[2][0] == "" && !win) {
                (it as ImageButton).setImageLevel(playerTurn())
                game[2][0] = symbol
                winCondition()
            }
        }
        binding.imageButtonEighth.setOnClickListener {
            if (game[2][1] == "" && !win) {
                (it as ImageButton).setImageLevel(playerTurn())
                game[2][1] = symbol
                winCondition()
            }
        }
        binding.imageButtonNineth.setOnClickListener {
            if (game[2][2] == "" && !win) {
                (it as ImageButton).setImageLevel(playerTurn())
                game[2][2] = symbol
                winCondition()
            }
        }
    }

    private fun winCondition() {
        game.map {
            if (it.count { element ->
                    element == "o"
                } == 3) {
                score1++
                binding.textVieuScore.text = "${score1}"
                binding.textViewWinner.text = getString(
                    R.string.win_text,
                    getString(R.string.player_one)
                )
                win = true
                return@map
            }
            if (it.count { element ->
                    element == "x"
                } == 3) {
                score2++
                binding.textVieuScore2.text =
                    "${score2}"
                binding.textViewWinner.text = getString(
                    R.string.win_text,
                    getString(R.string.player_two)
                )
                win = true
                return@map
            }
        }
        if (game[0][0] == "o" && game[1][1] == "o" && game[2][2] == "o") {
            score1++
            binding.textVieuScore.text = "${score1}"
            binding.textViewWinner.text = getString(
                R.string.win_text,
                getString(R.string.player_one)
            )
            win = true
        }
        if (game[0][0] == "x" && game[1][1] == "x" && game[2][2] == "x") {
            score2++
            binding.textVieuScore2.text =
                "${score2}"
            binding.textViewWinner.text = getString(
                R.string.win_text,
                getString(R.string.player_two)
            )
            win = true
        }
        if (game[0][2] == "o" && game[1][1] == "o" && game[2][0] == "o") {
            score1++
            binding.textVieuScore.text = "${score1}"
            binding.textViewWinner.text = getString(
                R.string.win_text,
                getString(R.string.player_one)
            )
            win = true
        }
        if (game[0][2] == "x" && game[1][1] == "x" && game[2][0] == "x") {
            score2++
            binding.textVieuScore2.text =
                "${score2}"
            binding.textViewWinner.text = getString(
                R.string.win_text,
                getString(R.string.player_two)
            )
            win = true
        }
        for (i in 0..2) {
            if (game[0][i] == "o" && game[1][i] == "o" && game[2][i] == "o") {
                score1++
                binding.textVieuScore.text = "${score1}"
                binding.textViewWinner.text = getString(
                    R.string.win_text,
                    getString(R.string.player_one)
                )
                win = true
                break
            }
            if (game[0][i] == "x" && game[1][i] == "x" && game[2][i] == "x") {
                score2++
                binding.textVieuScore2.text = "${score2}"
                binding.textViewWinner.text = getString(
                    R.string.win_text,
                    getString(R.string.player_two)
                )
                win = true
                break
            }
        }

    }

    private fun resetGameButton() {
        binding.buttonRestart.setOnClickListener {
            restart()
        }
    }

    private fun restart() {
        binding.layoutLay.setBackgroundColor(getColor(R.color.white))
        binding.textViewWinner.text = ""
        binding.imageButtonFirst.setImageLevel(0)
        binding.imageButtonSecond.setImageLevel(0)
        binding.imageButtonThird.setImageLevel(0)
        binding.imageButtonFourth.setImageLevel(0)
        binding.imageButtonFifth.setImageLevel(0)
        binding.imageButtonSixth.setImageLevel(0)
        binding.imageButtonSeventh.setImageLevel(0)
        binding.imageButtonEighth.setImageLevel(0)
        binding.imageButtonNineth.setImageLevel(0)
        game.forEachIndexed { index, strings ->
            strings.forEachIndexed { index2, _ ->
                game[index][index2] = ""
            }
        }
        win = false
    }
}
