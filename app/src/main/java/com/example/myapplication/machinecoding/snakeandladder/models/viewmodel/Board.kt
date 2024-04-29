package com.example.myapplication.machinecoding.snakeandladder.models.viewmodel

import com.example.myapplication.machinecoding.snakeandladder.models.Dice
import com.example.myapplication.machinecoding.snakeandladder.models.Ladder
import com.example.myapplication.machinecoding.snakeandladder.models.Player
import com.example.myapplication.machinecoding.snakeandladder.models.Snake

class Board(val dice: Dice, val snakes: List<Snake>, val ladders: List<Ladder>, val players: List<Player>){

    private var snakeData: HashMap<Int, Int> = hashMapOf()
    private var ladderData: HashMap<Int, Int> = hashMapOf()
    private var playersData: List<Player>
    private val rollingString: String = "Player x is rolling"
    private var playersIdPosition: HashMap<Int, Int> = hashMapOf()
    private var playerCount = 0;
//    private val dice: Dice = Dice()
    init {
        for(item in snakes){
            snakeData.put(item.start, item.end)
        }
        for(item in ladders){
            ladderData.put(item.start, item.end)
        }
        for(item in players){
            playersIdPosition.put(item.id, 0)
        }
        playersData = players
    }

    fun startGame(){
        println("Starting game")
        while (playersIdPosition.get(playerCount) != 100){
            println("" + playersData.get(playerCount).name + " is rolling dice")
            val roll: Int = dice.rollDice()
            println("" + playersData.get(playerCount).name + " rolled: " + roll)
            var currentPlayerPosition : Int = playersIdPosition.get(playerCount) ?: 0
            if(currentPlayerPosition.plus(roll) > 100){
                println("roll a smaller dice")
            } else {
                currentPlayerPosition = currentPlayerPosition.plus(roll)
                val updatedPlayerPosition: Int= checkForSnakeOrLadder(currentPlayerPosition)
                playersIdPosition.put(playerCount, updatedPlayerPosition)
                println("" + playersData.get(playerCount).name +  " is now at: " + updatedPlayerPosition)
                if(updatedPlayerPosition == 100){
                    break
                }
            }
            playerCount++
            playerCount = playerCount % players.size
        }
        println("Congratulations, player " + playersData.get(playerCount).name + " won the game" )
    }

    private fun checkForSnakeOrLadder(currentPlayerPosition: Int): Int {
        var updatedPosition: Int = currentPlayerPosition
        snakeData.let {data ->
            data.containsKey(currentPlayerPosition).let {
                data.get(currentPlayerPosition)?.let {
                    println("oops!! caught by snake going from: " + currentPlayerPosition + " to " + it)
                    updatedPosition = it
                }
            }
        }
        ladderData.let {data ->
            data.containsKey(currentPlayerPosition).let {
                data.get(currentPlayerPosition)?.let {
                    println("yeahh!! climbing ladder going from: " + currentPlayerPosition + " to " + it)
                    updatedPosition = it
                }
            }
        }
//        checkForSnakeOrLadder(updatedPosition)
        return updatedPosition
    }

}



