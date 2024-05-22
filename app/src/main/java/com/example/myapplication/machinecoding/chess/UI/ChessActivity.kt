package com.example.myapplication.machinecoding.chess.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityChessBinding
import com.example.myapplication.machinecoding.chess.ChessBoard

class ChessActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChessBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityChessBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val board: Array<Array<String>> = arrayOf(
            arrayOf("WE", "WH", "WC", "WQ", "WK", "WC", "WH", "WE"),
            arrayOf("WP", "WP", "WP", "WP", "WP", "WP", "WP", "WP"),
            arrayOf("    ", "    ", "    ", "    ", "    ", "    ", "    ", "    "),
            arrayOf("    ", "    ", "    ", "    ", "    ", "    ", "    ", "    "),
            arrayOf("    ", "    ", "    ", "    ", "    ", "    ", "    ", "    "),
            arrayOf("    ", "    ", "    ", "    ", "    ", "    ", "    ", "    "),
            arrayOf("BP", "BP", "BP", "BP", "BP", "BP", "BP", "BP"),
            arrayOf("BE", "BH", "BC", "BQ", "BK", "BC", "BH", "BE"),
        )


        val boardInArray: ArrayList<String?> = ArrayList()

        for (row in board) {
            for (cell in row) {
                boardInArray.add(cell)
            }
        }
        val adapter = GridAdapter(this, boardInArray)
        binding.gridView.adapter = adapter

        var startRow = 0;
        var startCol = 0
        var endRow = 0
        var endCol = 0
        var isStart = true
        val chessBoard = ChessBoard(board)
        var startPiece : String?= null
        var startPosition = 0

        binding.gridView.onItemClickListener =
            AdapterView.OnItemClickListener { parent, view, position, id ->
                val item = parent.getItemAtPosition(position) as String?
                System.out.println("position = " + position + " Item = " + item)
                if (isStart) {
                    startRow = position / 8
                    startCol = position % 8
                    startPosition = position
                    startPiece = adapter.getItem(position);
                } else {
                    endRow = position / 8
                    endCol = position % 8
                    val move = chessBoard.moveAndGetBoard(startRow, startCol, endRow, endCol)
                    if (move.isValid) {
                        adapter.remove(startPiece)
                        adapter.insert("    ", startPosition)
                        adapter.remove(adapter.getItem(position))
                        adapter.insert(move.chessBoard?.get(endRow)?.get(endCol), position)
                        adapter.notifyDataSetChanged()


//
//                        val boardInArray: ArrayList<String?> = ArrayList()
//
//                        for (row in move.chessBoard!!) {
//                            for (cell in row) {
//                                boardInArray.add(cell)
//                            }
//                        }
//                        binding.gridView.adapter = GridAdapter(this, boardInArray)
                    }
                }
                isStart = !isStart
            }
    }
}