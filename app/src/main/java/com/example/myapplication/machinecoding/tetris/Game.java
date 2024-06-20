package com.example.myapplication.machinecoding.tetris;

public class Game {
    private Board board;
    private Piece currentPiece;
    private PieceFactory pieceFactory;
    private int score;
    private boolean isGameOver;

    public Game() {
        board = new Board();
        pieceFactory = new PieceFactory();
        score = 0;
        isGameOver = false;
        spawnPiece();
    }

    private void spawnPiece() {
        currentPiece = pieceFactory.generateRandomPiece();
        if (!board.canPlacePiece(currentPiece)) {
            isGameOver = true;
        }
    }

    public void update() {
        if (!isGameOver) {
            if (!board.movePieceDown(currentPiece)) {
                board.placePiece(currentPiece);
                board.clearFullLines();
                score += board.calculateScore();
                spawnPiece();
            }
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public int getScore() {
        return score;
    }

    public void movePieceLeft() {
        board.movePieceLeft(currentPiece);
    }

    public void movePieceRight() {
        board.movePieceRight(currentPiece);
    }

    public void rotatePiece() {
        board.rotatePiece(currentPiece);
    }

    public Board getBoard() {
        return board;
    }

    public Piece getCurrentPiece() {
        return currentPiece;
    }
}

