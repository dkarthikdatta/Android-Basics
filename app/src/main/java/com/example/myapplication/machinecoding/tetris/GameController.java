package com.example.myapplication.machinecoding.tetris;


public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void handleInput(String input) {
        switch (input) {
            case "left":
                game.movePieceLeft();
                break;
            case "right":
                game.movePieceRight();
                break;
            case "down":
                game.update();
                break;
            case "rotate":
                game.rotatePiece();
                break;
        }
    }
}
