package com.example.myapplication.machinecoding.musicsimilarsuggestion.models.normal

import com.example.myapplication.machinecoding.musicsimilarsuggestion.models.Song
import java.util.Scanner
import java.util.TreeMap
import java.util.TreeSet

class MyMain {

    private lateinit var data: List<Song>
    private lateinit var hashData: HashMap<Int, Song>
    private lateinit var playList: ArrayList<Int>
    private var currentlyPlayingSong: Int = 0
    private var suggestedSongs: TreeMap<Int, Int> = TreeMap() // id, freq
    fun start() {
        hashData = HashMap()
        playList = ArrayList()
        data = DataSource().getData()
        for (i in data.indices) {
            hashData[data[i].id] = data[i]
        }
    }

    fun playSong(currentSongId: Int) {
        currentlyPlayingSong = currentSongId
        hashData[currentSongId]?.name?.let {
            println("Playing song: " + hashData[currentSongId]?.name)
        } ?: println("Invalid Song")
    }

    fun suggestSongsIds(currentSongId: Int): List<Int> {
        val suggestedSongs: ArrayList<Int> = ArrayList()
        hashData.get(currentSongId)?.similarSongs?.let { similarIds ->
            for (i in similarIds.indices) {
                suggestedSongs.add(similarIds[i])
            }
            //println("Suggested song ids: " + suggestedSongs)
        }

        return suggestedSongs
    }

    fun addSongToPlayList(currentSongId: Int) {
        playList.add(currentSongId)
    }

    /**
     * suggest top 5 songs based on playlist
     * all playlist most repeated suggested
     * Treemap -> 1st sort by frequency of suggested repeated
     *            2nd if same frequency, whichever is added latest to map
     */

    fun suggestTopFiveSongs() {
//        suggestedSongs.clear()
        for (i in playList.size - 1 downTo 0) {
            val suggestedSongsForEachId = suggestSongsIds(playList[i])
            for (j in suggestedSongsForEachId.indices) {
                suggestedSongs[suggestedSongsForEachId[j]] =
                    suggestedSongs.getOrDefault(suggestedSongsForEachId[j], 0) + 1
            }
        }

        val suggestedSongsOrder: TreeMap<Int, Int> = TreeMap(
            Comparator { song1, song2 ->
                val frequencyComparison =
                    suggestedSongs[song2]!!.compareTo(suggestedSongs[song1]!!)
                if (frequencyComparison != 0) {
                    frequencyComparison
                } else {
                    song1.compareTo(song2)
                }
            }
        )
        suggestedSongsOrder.putAll(suggestedSongs)

        if (suggestedSongsOrder.size < 5) {
            println("Suggested songs are: ")
            for (song in suggestedSongsOrder) {
                print("${song.key} ")
            }
        }
        if (suggestedSongsOrder.size >= 5) {
            var count = 0
            println("Suggested songs are: ")
            val itr = suggestedSongsOrder.iterator()
            while (count < 5) {
                val songId = itr.next()
                print("${songId.key} ")
                count++
            }
        }
    }


}


fun main() {
    val main = MyMain()

    main.start()
    val scan = Scanner(System.`in`)
//    println("Number of songs in current playlist: ")


    println("Enter song id to play: ")
    val currentSongId = scan.nextInt()

    main.playSong(currentSongId)
    main.addSongToPlayList(currentSongId)
    main.suggestTopFiveSongs()

    println("Play another song with id: ")


    while (true) {
        val nextSong = scan.nextInt()

        main.playSong(nextSong)
        main.addSongToPlayList(nextSong)
        main.suggestTopFiveSongs()
    }

}
