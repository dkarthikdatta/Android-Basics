package com.example.myapplication.machinecoding.googleSheet;

import java.util.ArrayList;
import java.util.List;

public class Sheet {
    private List<Row> rows;

    public Sheet() {
        this.rows = new ArrayList<>();
    }

    public void addRow(Row row) {
        rows.add(row);
    }

    public List<Row> getRows() {
        return rows;
    }
}
