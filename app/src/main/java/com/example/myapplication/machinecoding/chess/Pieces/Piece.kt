package com.example.myapplication.machinecoding.chess.Pieces

import com.example.myapplication.machinecoding.chess.ChessBoard
import com.example.myapplication.machinecoding.chess.Moves.Move

open class Piece {
     var color: Char
     var type: Char
    private lateinit var moves: Array<Move>

    constructor(color: Char, type: Char) {
        this.color = color
        this.type = type
        this.moves = arrayOf()
    }

    constructor(color: Char, type: Char, moves: Array<Move>) {
        this.color = color
        this.type = type
        this.moves = moves
    }

    open fun canMove(
        chessBoard: ChessBoard?,
        _startRow: Int,
        _startCol: Int,
        _endRow: Int,
        _endCol: Int
    ): Boolean {
        for (move in moves) {
            if (!move.canMove(chessBoard!!, _startRow, _startCol, _endRow, _endCol)) {
                return false
            }
        }
        return true
    }
}
