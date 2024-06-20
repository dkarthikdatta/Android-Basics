package com.example.myapplication.machinecoding.tetris;



public class LPiece extends Piece {
    public LPiece() {
        super(new Block[]{
                new Block(0, 0, Color.ORANGE),
                new Block(1, 0, Color.ORANGE),
                new Block(2, 0, Color.ORANGE),
                new Block(2, 1, Color.ORANGE)
        });
    }
}
