package com.example.myapplication.machinecoding.chess.Moves

import com.example.myapplication.machinecoding.chess.ChessBoard

interface Move {
    fun canMove(chessBoard: ChessBoard, _startRow: Int, _startCol: Int, _endRow: Int, _endCol: Int) : Boolean
}