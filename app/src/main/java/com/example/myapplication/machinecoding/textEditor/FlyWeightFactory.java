package com.example.myapplication.machinecoding.textEditor;

import java.util.HashMap;

public class FlyWeightFactory {

    // adding instrinsic data.
    private HashMap<String, CharFlyWeight> map = new HashMap<>();


    CharFlyWeight createStyle(char ch, String fontName, int fontSize, boolean isBold, boolean isItalic) {
        StringBuilder sb = new StringBuilder();
        sb.append(ch).append('-').append(fontName).append('-').append(fontSize);
        if (isBold) sb.append('-').append('b');
        if (isItalic) sb.append('-').append('i');

        String key = sb.toString();
        if (!map.containsKey(key)) {
            map.put(key, new CharFlyWeight(ch, fontName, fontSize, isBold, isItalic));
        }
        return map.get(key);
    }

}
