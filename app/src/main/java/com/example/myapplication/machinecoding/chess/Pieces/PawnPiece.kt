package com.example.myapplication.machinecoding.chess.Pieces

import com.example.myapplication.machinecoding.chess.ChessBoard
import com.example.myapplication.machinecoding.chess.Piece1

class PawnPiece(color: Char, type: Char) : Piece(color, type) {

    override fun canMove(
        chessBoard: ChessBoard?,
        _startRow: Int,
        _startCol: Int,
        _endRow: Int,
        _endCol: Int
    ): Boolean {
        val pawn: Piece? = chessBoard?.getPiece(_startRow, _startCol)

        if (chessBoard?.getPiece(_endRow, _endCol) == null) {
            return (pawn?.color == 'W' && _endRow - _startRow == 1) || (pawn?.color == 'B' && _endRow - _startRow == -1)
        } else {
            if (Math.abs(_startCol - _endCol) != 1) return false
            return (pawn?.color == 'W' && _endRow - _startRow == 1) || (pawn?.color == 'B' && _endRow - _endCol == -1)
        }
    }
}