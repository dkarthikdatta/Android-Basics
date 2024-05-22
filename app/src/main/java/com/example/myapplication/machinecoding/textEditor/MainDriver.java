package com.example.myapplication.machinecoding.textEditor;

import java.util.Random;

public class MainDriver {

    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            textEditor.addCharacter(0, i, (char) (32), "ariel", 16, true, true);
            int lengthOfWord = random.nextInt(10);
//            System.out.println(lengthOfWord);
            for (int j = 0; j < lengthOfWord; j++) {
                textEditor.addCharacter(0, i, (char) (97 + random.nextInt(26)), "ariel", 16, true, true);
            }

        }


        System.out.println(textEditor.readLine(0));

        System.out.println(textEditor.deleteCharacter(0, 2));
        System.out.println(textEditor.readLine(0));
        System.out.println(textEditor.getStyle(0, 5));
        System.out.println(textEditor.readCharacter(0, 5));
    }
}
