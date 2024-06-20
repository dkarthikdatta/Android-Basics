package com.example.myapplication.machinecoding.tetris;

public class Piece {
    protected Block[] blocks;
    protected int x, y; // Position of the piece on the board

    public Piece(Block[] blocks) {
        this.blocks = blocks;
        this.x = 0; // Initial x position
        this.y = 0; // Initial y position
    }

    public Block[] getBlocks() {
        return blocks;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void rotate() {
        // Rotate the piece (implementation depends on the piece type)
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }

    public void moveDown() {
        y++;
    }
}
