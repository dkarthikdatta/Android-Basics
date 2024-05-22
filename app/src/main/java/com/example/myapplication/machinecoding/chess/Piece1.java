package com.example.myapplication.machinecoding.chess;

import com.example.myapplication.machinecoding.chess.Moves.Move;

public class Piece1 {

    private Piece1[][] piece1s;
    private char color, type;
    private Move[] moves;

    public Piece1(char color, char type) {
        this.color = color;
        this.type = type;
    }

    public Piece1(char color, char type, Move[] moves) {
        this.color = color;
        this.type = type;
        this.moves = moves;
    }

    protected boolean canMove(ChessBoard chessBoard, int _startRow, int _startCol, int _endRow, int _endCol) {
        for (Move move : moves) {
            if (!move.canMove(chessBoard, _startRow, _startCol, _endRow, _endCol)) {
                return false;
            }
        }
        return true;
    }
}
