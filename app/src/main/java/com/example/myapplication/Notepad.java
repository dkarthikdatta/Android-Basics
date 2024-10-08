package com.example.myapplication;

public class Notepad {


    /**
     * Design
     * character, font size, color -> SuperCharacter -> ch+fs+co
     *
     * factory design - hashMap<String, SuperCharacter>
     *
     * flyWeight
     *
     * ref -> type, size ->
     *
     * Columns -> SparseArray<SuperCharacter> addition/deletion of char -> worst case o(n) / best case -> o(1), modification - o(1)
     * Rows -> SparseArray<Columns>
     *
     *     100
     *
     *     abc 90-----
     *     -----------------------
     *     -----------------------
     *     -----------------------
     *     -----------------------
     *
     *
     * Note {
     *     name,
     *     rows,
     *     timeStamps,
     *     undoStack<operations>
     *     redoStack<operations>
     *
     *         Pair<position<row, col>, SuperCharacter>
     *         enums {
     *         Addition,
     *         Deletion,
     *         Modification
     *         }
     *
     * }
     *
     * NotePad {
     *     note
     *     List<Note>
     * }
     *
     * NotePad
     *  1. Todo
     *  2. Workout
     *
     *  {
     *      [Notes]
     *  }
     *
     */
}
