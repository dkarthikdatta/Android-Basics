package com.example.myapplication.machinecoding.googleSheet.hashMap;

import java.util.HashMap;
import java.util.Map;


public class HashMapType {
}

class Cell {
    private String value;

    public Cell(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}

class Row {
    private HashMap<Integer, Cell> cells;

    public Row() {
        cells = new HashMap<>();
    }

    public void addCell(int columnIndex, Cell cell) {
        cells.put(columnIndex, cell);
    }

    public Cell getCell(int columnIndex) {
        return cells.get(columnIndex);
    }

    public Map<Integer, Cell> getCells() {
        return cells;
    }

    @Override
    public String toString() {
        StringBuilder rowStr = new StringBuilder();
        for (int i = 0; i < cells.size(); i++) {
            Cell cell = cells.get(i);
            rowStr.append(cell != null ? cell.toString() : "").append("\t");
        }
        return rowStr.toString().trim();
    }
}

class Sheet {
    private Map<Integer, Row> rows;

    public Sheet() {
        rows = new HashMap<>();
    }

    public void addRow(int rowIndex, Row row) {
        rows.put(rowIndex, row);
    }

    public Row getRow(int rowIndex) {
        return rows.get(rowIndex);
    }

    public Map<Integer, Row> getRows() {
        return rows;
    }

    @Override
    public String toString() {
        StringBuilder sheetStr = new StringBuilder();
        for (int i = 0; i < rows.size(); i++) {
            Row row = rows.get(i);
            sheetStr.append(row != null ? row.toString() : "").append("\n");
        }
        return sheetStr.toString().trim();
    }
}



class GoogleSheetMock {
    public static void main(String[] args) {
        // Create a new sheet
        Sheet sheet = new Sheet();

        // Create and populate the first row (header)
        Row headerRow = new Row();
        headerRow.addCell(0, new Cell("Name"));
        headerRow.addCell(1, new Cell("Age"));
        headerRow.addCell(2, new Cell("City"));
        sheet.addRow(0, headerRow);

        // Create and populate the second row
        Row row1 = new Row();
        row1.addCell(0, new Cell("Alice"));
        row1.addCell(1, new Cell("30"));
        row1.addCell(2, new Cell("New York"));
        sheet.addRow(1, row1);

        // Create and populate the third row
        Row row2 = new Row();
        row2.addCell(0, new Cell("Bob"));
        row2.addCell(1, new Cell("25"));
        row2.addCell(2, new Cell("San Francisco"));
        sheet.addRow(2, row2);

        // Print the sheet
        System.out.println(sheet);
    }
}
