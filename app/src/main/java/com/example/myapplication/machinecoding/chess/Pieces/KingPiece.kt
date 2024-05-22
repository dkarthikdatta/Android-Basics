package com.example.myapplication.machinecoding.chess.Pieces

import com.example.myapplication.machinecoding.chess.ChessBoard

class KingPiece(color: Char, type: Char) : Piece(color, type) {

    public override fun canMove(
        chessBoard: ChessBoard?,
        _startRow: Int,
        _startCol: Int,
        _endRow: Int,
        _endCol: Int
    ): Boolean {
        val rowDelta = Math.abs(_endRow - _startRow)
        val colDelta = Math.abs(_endCol - _startCol)
        return rowDelta <= 1 && colDelta <= 1
    }
}