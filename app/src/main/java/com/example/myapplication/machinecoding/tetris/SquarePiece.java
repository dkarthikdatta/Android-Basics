package com.example.myapplication.machinecoding.tetris;


public class SquarePiece extends Piece {
    public SquarePiece() {
        super(new Block[]{
                new Block(0, 0, Color.YELLOW),
                new Block(0, 1, Color.YELLOW),
                new Block(1, 0, Color.YELLOW),
                new Block(1, 1, Color.YELLOW)
        });
    }
}
