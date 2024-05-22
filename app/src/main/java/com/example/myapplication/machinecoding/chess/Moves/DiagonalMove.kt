package com.example.myapplication.machinecoding.chess.Moves

import com.example.myapplication.machinecoding.chess.ChessBoard

class DiagonalMove : Move {
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
        var rowDelta = endRow - startRow
        var colDelta = endCol - startCol

        if (Math.abs(rowDelta) != Math.abs(colDelta)) {
            return false;
        }

        rowDelta = if (rowDelta > 0) 1 else -1
        colDelta = if (colDelta > 0) 1 else -1

        while (startRow != endRow) {
            if (chessBoard.getPiece(startRow, startCol) != null) {
                return false
            }
            startRow += rowDelta;
            startCol += colDelta
        }
        return true
    }
}