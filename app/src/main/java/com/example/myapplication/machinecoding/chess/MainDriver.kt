package com.example.myapplication.machinecoding.chess

fun main() {

    val board: Array<Array<String>> = arrayOf(
        arrayOf("WE", "WH", "WC", "WQ", "WK", "WC", "WH", "WE"),
        arrayOf("WP", "WP", "WP", "WP", "WP", "WP", "WP", "WP"),
        arrayOf("", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", ""),
        arrayOf("", "", "", "", "", "", "", ""),
        arrayOf("BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP"),
        arrayOf("BE", "BH", "BC", "BQ", "BK", "BC", "BH", "BE"),
    )

    val chessBoard: ChessBoard = ChessBoard(board)

    val move1 = chessBoard.move(1, 1, 2, 1)
    println(move1)

    val move2 = chessBoard.move(1, 1, 2, 1)
    println(move2)
}