package com.example.myapplication.machinecoding.textEditor;

public class CharFlyWeight {
    private char ch;
    private String fontName;
    private int fontSize;
    private boolean isBold, isItalic;


    public CharFlyWeight(char ch, String fontName, int fontSize, boolean isBold, boolean isItalic) {
        this.ch = ch;
        this.fontName = fontName;
        this.fontSize = fontSize;
        this.isBold = isBold;
        this.isItalic = isItalic;
    }

    char getChar() {
        return ch;
    }

    String getCharAndStyle() {
        StringBuilder sb = new StringBuilder();
        sb.append(ch).append('-').append(fontName).append('-').append(fontSize);
        if (isBold) sb.append('-').append('b');
        if (isItalic) sb.append('-').append('i');
        return sb.toString();
    }
}
