package com.example.myapplication.machinecoding.chess

import com.example.myapplication.machinecoding.chess.Moves.DiagonalMove
import com.example.myapplication.machinecoding.chess.Moves.StraightMove
import com.example.myapplication.machinecoding.chess.Pieces.HorsePiece
import com.example.myapplication.machinecoding.chess.Pieces.KingPiece
import com.example.myapplication.machinecoding.chess.Pieces.PawnPiece
import com.example.myapplication.machinecoding.chess.Pieces.Piece
import kotlin.concurrent.Volatile

class ChessFactory {
    private val straightMove = StraightMove()
    private val diagonalMove = DiagonalMove()


    companion object {
        @Volatile
        private var instance: ChessFactory? = null
        public fun getInstance(): ChessFactory {
            if (instance == null) {
                synchronized(ChessFactory::class) {
                    if (instance == null) {
                        instance = ChessFactory()
                    }
                }
            }
            return instance!!
        }
    }

    fun createPiece(color: Char, type: Char): Piece? {
        when (type) {
            'Q' -> {
                return Piece(color, type, arrayOf(diagonalMove, straightMove))
            }

            'E' -> {
                return Piece(color, type, arrayOf(straightMove))
            }

            'C' -> {
                return Piece(color, type, arrayOf(diagonalMove))
            }

            'K' -> {
                return KingPiece(color, type)
            }

            'H' -> {
                return HorsePiece(color, type)
            }

            'P' -> {
                return PawnPiece(color, type)
            }
        }
        return null
    }

}