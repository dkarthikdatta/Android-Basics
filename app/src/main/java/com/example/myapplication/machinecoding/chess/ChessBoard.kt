package com.example.myapplication.machinecoding.chess

import androidx.databinding.adapters.AutoCompleteTextViewBindingAdapter.IsValid
import com.example.myapplication.dsAlgo.Utility
import com.example.myapplication.machinecoding.chess.Pieces.Piece


class Pair<T, U>(val chessBoard: Array<Array<String>>?, val isValid: Boolean) {
}

class ChessBoard(chessBoard: Array<Array<String>>) {

    private var board: Array<Array<Piece?>> =
        Array(chessBoard.size) { arrayOfNulls<Piece?>(chessBoard[it].size) }
    private val factory = ChessFactory.getInstance()

    // 0 for game in progress, 1 for white win, 2 for black win
    private var gameState = 0

    //1 for white, 2 for black
    private var nextTurn = 1;

    init {
        for (row in 0..chessBoard.size - 1) {
            for (col in 0..chessBoard[row].size - 1) {
                if (chessBoard[row][col].length == 2) {
                    val color: Char = chessBoard[row][col].get(0)
                    val type = chessBoard[row][col].get(1)
                    board[row][col] = factory.createPiece(color, type)
                }
            }
        }
        Utility.print2DArray(board)
    }


    fun getPiece(startRow: Int, startCol: Int): Piece? {
        return board.get(startRow).get(startCol)
    }

    private fun validBounds(endRow: Int, endCol: Int): Boolean {
        return !(endRow >= board.size || endCol >= board[0].size)
    }

    fun move(startRow: Int, startCol: Int, endRow: Int, endCol: Int): String {
        if (gameState != 0) return "Game is done"
        val startPiece: Piece? = getPiece(startRow, startCol)
        val endPiece: Piece? = getPiece(endRow, endCol)
        if (startPiece == null) return "Invalid Move"
        if (endPiece != null && endPiece.color == startPiece.color) return "Invalid Move"
        if (!startPiece.canMove(this, startRow, startCol, endRow, endCol)) return "Invalid Move"
        if (!validBounds(endRow, endCol)) return "Invalid Move"

        board[startRow][startCol] = null
        board[endRow][endCol] = startPiece
        nextTurn = if (nextTurn == 1) 2 else 1

        if (endPiece != null && endPiece.type == 'K') {
            gameState = if (endPiece.color == 'B') 1 else 2
        }

        Utility.print2DArray(board)
        if (endPiece == null) {
            return ""
        }
        return "" + endPiece.color + endPiece.type
    }

    fun moveAndGetBoard(startRow: Int, startCol: Int, endRow: Int, endCol: Int): Pair<ChessBoard, Boolean> {
        if (gameState != 0) return Pair(null, false)
        val startPiece: Piece? = getPiece(startRow, startCol)
        val endPiece: Piece? = getPiece(endRow, endCol)
        if (startPiece == null) return Pair(null, false)
        if (endPiece != null && endPiece.color == startPiece.color) return Pair(null, false)
        if (!startPiece.canMove(this, startRow, startCol, endRow, endCol)) return Pair(null, false)
        if (!validBounds(endRow, endCol)) return Pair(null, false)

        board[startRow][startCol] = null
        board[endRow][endCol] = startPiece
        nextTurn = if (nextTurn == 1) 2 else 1

        if (endPiece != null && endPiece.type == 'K') {
            gameState = if (endPiece.color == 'B') 1 else 2
        }

        Utility.print2DArray(board)
        if (endPiece == null) {
            return Pair(Utility.covertPiecesToArray(board), true)
        }
        return Pair(Utility.covertPiecesToArray(board), true)
    }
}