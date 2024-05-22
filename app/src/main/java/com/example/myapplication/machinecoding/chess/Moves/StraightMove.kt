package com.example.myapplication.machinecoding.chess.Moves

import com.example.myapplication.machinecoding.chess.ChessBoard

class StraightMove : Move {
    override fun canMove(
        chessBoard: ChessBoard,
        _startRow: Int,
        _startCol: Int,
        _endRow: Int,
        _endCol: Int
    ): Boolean {
        var startRow = _startRow
        var startCol = _startCol
        var endRow = _endRow
        var endCol = _endCol

        if (startRow != endRow && startCol != endCol) {
            return false
        }

        var rowDelta = endRow - startRow
        var colDelta = endCol - startCol

        if (startRow == endRow) {
            colDelta = if (colDelta > 0) 1 else -1
            while (startCol != endCol) {
                if (chessBoard.getPiece(startRow, startCol) != null) {
                    return false
                }
                startCol += colDelta
            }
        }

        if (startCol == endCol) {
            rowDelta = if (rowDelta > 0) 1 else -1
            while (startRow != endRow) {
                if (chessBoard.getPiece(startRow, startCol) != null) {
                    return false
                }
                startRow += rowDelta
            }
        }
        return true
    }
}