package com.example.myapplication.machinecoding.snakeandladder.models

class Dice {
    fun rollDice(): Int {
        return (1..6).random()
    }
}