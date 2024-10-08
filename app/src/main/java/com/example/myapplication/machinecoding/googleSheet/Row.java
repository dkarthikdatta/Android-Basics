package com.example.myapplication.machinecoding.googleSheet;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<Cell> cells;

    public Row(){
        this.cells = new ArrayList<>();
    }

    public void addCell(Cell cell){
        cells.add(cell);
    }

    public List<Cell> getCells(){
        return cells;
    }
}
