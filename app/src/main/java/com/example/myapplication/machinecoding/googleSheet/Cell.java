package com.example.myapplication.machinecoding.googleSheet;

public class Cell {
    String value;
    boolean isFormula;

    public Cell(String value){
        this.value = value;
        this.isFormula = value.startsWith("=");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
