package com.example.myapplication.machinecoding.textEditor;

import java.util.ArrayList;
import java.util.List;

public class TextEditor {

    private final FlyWeightFactory flyWeightFactory = new FlyWeightFactory();

    private final ArrayList<TextRow> rows = new ArrayList<>();


    public void addCharacter(int row, int col, char ch, String fontName, int fontSize, boolean isBold, boolean isItalic) {
        while (row >= rows.size()) {
            rows.add(new TextRow());
        }
        CharFlyWeight flyWeight = flyWeightFactory.createStyle(ch, fontName, fontSize, isBold, isItalic);
        rows.get(row).addCharacter(flyWeight, col);
    }

    public String getStyle(int row, int col) {
        if (row < 0 || row >= rows.size()) {
            return "";
        }
        CharFlyWeight flyWeight = rows.get(row).getFlyWeight(col);
        return flyWeight == null ? "" : flyWeight.getCharAndStyle();
    }

    public String readLine(int row) {
        if (row < 0 || row >= rows.size()) {
            return "";
        }
        List<CharFlyWeight> charFlyWeights = rows.get(row).readLine();
        StringBuilder stringBuilder = new StringBuilder();

        for (CharFlyWeight charFlyWeight : charFlyWeights) {
            stringBuilder.append(charFlyWeight.getChar());
        }
        return stringBuilder.toString();
    }


    public boolean deleteCharacter(int row, int col) {
        if (row < 0 || row >= rows.size()) {
            return false;
        }
        return rows.get(row).deleteCharacter(col);
    }

    public char readCharacter(int row, int col) {
        if (row < 0 || row >= rows.size()) {
            return 0;
        }
        return rows.get(row).readCharacter(col);
    }
}
