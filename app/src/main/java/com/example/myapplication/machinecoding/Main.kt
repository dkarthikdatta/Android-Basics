package com.example.myapplication.machinecoding

import com.example.myapplication.machinecoding.snakeandladder.models.Dice
import com.example.myapplication.machinecoding.snakeandladder.models.Ladder
import com.example.myapplication.machinecoding.snakeandladder.models.Player
import com.example.myapplication.machinecoding.snakeandladder.models.Snake
import com.example.myapplication.machinecoding.snakeandladder.models.viewmodel.Board
import java.util.Scanner


fun main() {
    val scan = Scanner(System.`in`)
    var noOfSnakes = scan.nextInt()
    println("Enter Number of snakes: ")
    println("Number of snakes: "+ noOfSnakes)
    val snakeData: MutableList<Snake> = mutableListOf()
    val ladderData: MutableList<Ladder> = mutableListOf()
    val playerData: MutableList<Player> = mutableListOf()
    println("Enter snakes: ")

    while (noOfSnakes > 0) {
        val startPosition = scan.nextInt()
        val endPosition = scan.nextInt()
        val snake = Snake(startPosition,endPosition)
        snakeData.add(snake)
        noOfSnakes--
    }
    println("Snakes successfully loaded")
    println("Enter Number of ladders: ")

    var noOfLadders = scan.nextInt()
    println("Number of ladders: "+ noOfLadders)
    println("Enter ladders: ")

    while (noOfLadders > 0) {
        val startPosition = scan.nextInt()
        val endPosition = scan.nextInt()
        val ladder = Ladder(startPosition, endPosition)
        ladderData.add(ladder)
        noOfLadders--
    }
    println("Ladders successfully loaded")
    println("Enter Number of players: ")

    var noOfPlayers = scan.nextInt()
    println("Number of players: "+ noOfPlayers)
    println("Enter players: ")
    var id = 0
    while (noOfPlayers > 0) {
        val playerName = scan.next()
        val player = Player(id, playerName)
        playerData.add(player)
        id++
        noOfPlayers--
    }
    println("Players successfully entered")
    val board = Board(Dice(), snakeData, ladderData, playerData)
    board.startGame()
}



