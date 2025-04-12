package com.example.appjogodavelha

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.appjogodavelha.R

class MainActivity : AppCompatActivity() {

    var isPlayer1 = true
    var gameEnd = false
    private lateinit var top : ImageView
    private lateinit var topStart : ImageView
    private lateinit var topEnd : ImageView

    private lateinit var center : ImageView
    private lateinit var centerStart : ImageView
    private lateinit var centerEnd : ImageView

    private lateinit var bottom : ImageView
    private lateinit var bottomStart : ImageView
    private lateinit var bottomEnd : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        top = findViewById(R.id.top)
        topStart = findViewById(R.id.topStart)
        topEnd = findViewById(R.id.topEnd)

        center = findViewById(R.id.center)
        centerStart = findViewById(R.id.centerStart)
        centerEnd = findViewById(R.id.centerEnd)

        bottom = findViewById(R.id.bottom)
        bottomStart = findViewById(R.id.bottomStart)
        bottomEnd = findViewById(R.id.bottomEnd)

        val reset: Button = findViewById(R.id.buttom_reset)
        reset.setOnClickListener{
            resetBox(top)
            resetBox(topStart)
            resetBox(topEnd)

            resetBox(center)
            resetBox(centerStart)
            resetBox(centerEnd)

            resetBox(bottom)
            resetBox(bottomStart)
            resetBox(bottomEnd)

        }

        configureBox(top)
        configureBox(topStart)
        configureBox(topEnd)

        configureBox(center)
        configureBox(centerStart)
        configureBox(centerEnd)

        configureBox(bottom)
        configureBox(bottomStart)
        configureBox(bottomEnd)


    }

    private fun resetBox(box: ImageView) {
        box.setImageDrawable(null)
        box.tag = null
        isPlayer1 = true
        gameEnd= false
    }

    private fun configureBox(box: ImageView) {
        box.setOnClickListener{
            if (box.tag == null && !gameEnd) {
                if (isPlayer1) {
                    box.setImageResource(R.drawable.xxx)
                    isPlayer1 = false
                    box.tag = 1
                } else {
                    box.setImageResource(R.drawable.bolinha)
                    isPlayer1 = true
                    box.tag = 2

                }

                if (playerWin(1)) {
                    Toast.makeText(this@MainActivity, "Player 1 Venceu", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                } else if (playerWin(2)) {
                    Toast.makeText(this@MainActivity, "PLayer 2 Venceu", Toast.LENGTH_SHORT).show()
                    gameEnd = true
                }
            }
        }
    }
    private fun playerWin(value: Int): Boolean {
        return (top.tag == value && center.tag == value && bottom.tag == value) ||
                (topStart.tag == value && centerStart.tag == value && bottomStart.tag == value) ||
                (topEnd.tag == value && centerEnd.tag == value && bottomEnd.tag == value) ||

                (topStart.tag == value && top.tag == value && topEnd.tag == value) ||
                (centerStart.tag == value && center.tag == value && centerEnd.tag == value) ||
                (bottomStart.tag == value && bottom.tag == value && bottomEnd.tag == value) ||

                (topStart.tag == value && center.tag == value && bottomEnd.tag == value) ||
                (topEnd.tag == value && center.tag == value && bottomStart.tag == value)
    }

}
