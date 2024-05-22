package com.example.myapplication.machinecoding.textEditor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextRow {
    private ArrayList<CharFlyWeight> data = new ArrayList<>();

    public void addCharacter(CharFlyWeight ch, int col) {
        data.add(ch);
        int currCol = data.size() - 1;
        while (currCol > 0 && currCol > col) {
            CharFlyWeight temp = data.get(currCol - 1);
            data.set(currCol - 1, data.get(currCol));
            data.set(currCol, temp);
            currCol--;
        }
    }

    public CharFlyWeight getFlyWeight(int col) {
        if (col < 0 || col >= data.size()) {
            return null;
        }
        return data.get(col);
    }

    public List<CharFlyWeight> readLine() {
        return data;
    }

    public boolean deleteCharacter(int col) {
        if (col < 0 || col >= data.size()) {
            return false;
        }

        data.remove(col);
        return true;
    }

    public char readCharacter(int col) {
        if (col < 0 || col >= data.size()) {
            return 0;
        }
        return data.get(col).getChar();
    }
}
