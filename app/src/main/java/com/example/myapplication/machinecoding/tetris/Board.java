package com.example.myapplication.machinecoding.tetris;

public class Board {
    private static final int WIDTH = 10;
    private static final int HEIGHT = 20;
    private Block[][] grid;

    public Board() {
        grid = new Block[HEIGHT][WIDTH];
    }

    public boolean canPlacePiece(Piece piece) {
        for (Block block : piece.getBlocks()) {
            int x = piece.getX() + block.getX();
            int y = piece.getY() + block.getY();
            if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT || grid[y][x] != null) {
                return false;
            }
        }
        return true;
    }

    public boolean movePieceDown(Piece piece) {
        piece.moveDown();
        if (!canPlacePiece(piece)) {
//            piece.moveUp();
            return false;
        }
        return true;
    }

    public void placePiece(Piece piece) {
        for (Block block : piece.getBlocks()) {
            int x = piece.getX() + block.getX();
            int y = piece.getY() + block.getY();
            grid[y][x] = new Block(x, y, block.getColor());
        }
    }

    public void clearFullLines() {
        for (int y = HEIGHT - 1; y >= 0; y--) {
            boolean isFull = true;
            for (int x = 0; x < WIDTH; x++) {
                if (grid[y][x] == null) {
                    isFull = false;
                    break;
                }
            }
            if (isFull) {
                clearLine(y);
                y++;
            }
        }
    }

    private void clearLine(int line) {
        for (int y = line; y > 0; y--) {
            for (int x = 0; x < WIDTH; x++) {
                grid[y][x] = grid[y - 1][x];
                if (grid[y][x] != null) {
                    grid[y][x].setY(y);
                }
            }
        }
        for (int x = 0; x < WIDTH; x++) {
            grid[0][x] = null;
        }
    }

    public int calculateScore() {
        // Simple scoring system: 100 points per line cleared
        return 100;
    }

    public void movePieceLeft(Piece piece) {
        piece.moveLeft();
        if (!canPlacePiece(piece)) {
            piece.moveRight();
        }
    }

    public void movePieceRight(Piece piece) {
        piece.moveRight();
        if (!canPlacePiece(piece)) {
            piece.moveLeft();
        }
    }

    public void rotatePiece(Piece piece) {
        piece.rotate();
        if (!canPlacePiece(piece)) {
//            piece.rotateBack();
        }
    }

    public Block[][] getGrid() {
        return grid;
    }
}
