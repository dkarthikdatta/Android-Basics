package com.example.myapplication.machinecoding.tetris;

import java.util.Random;

public class PieceFactory {
    private Random random;

    public PieceFactory() {
        random = new Random();
    }

    public Piece generateRandomPiece() {
        int pieceType = random.nextInt(2); // 0 for SquarePiece, 1 for LPiece

        switch (pieceType) {
            case 0:
                return new SquarePiece();
            case 1:
                return new LPiece();
            default:
                throw new IllegalArgumentException("Unknown piece type");
        }
    }
}

