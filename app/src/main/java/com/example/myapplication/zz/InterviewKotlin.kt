package com.example.myapplication.zz

fun main() {

    //["paxltbm",
    // "hhbut",
    // "ehqn",
    // "odqetasf",
    // "zt"]

    val arrayList: ArrayList<String> = arrayListOf()
    arrayList.add("paxltbm")
    arrayList.add("hhbut")
    arrayList.add("ehqn")
    arrayList.add("odqetasf")
    arrayList.add("zt")

    //IsValid
    val arrayList2: ArrayList<String> = arrayListOf()
    arrayList2.add("is")
    arrayList2.add("valid")

    println(canFormCamelCaseWord(arrayList2, "IsValid"))
    println(solution(arrayList2, "IsValid"))

//    println(canFormCamelCaseWord(arrayList2, "IsValid"))
//    println(solution(arrayList2, "IsValid"))
}


fun solution(words: MutableList<String>, variableName: String): Boolean {

    if (words.size == 0) {
        return false
    }

    val validSet: HashSet<String> = hashSetOf()

    // val validWords = arrayListOf()

    for (i in words.indices) {
        validSet.add(words[i].makeFirstLetterUpper())
    }

    // isValid
    val probableWords: ArrayList<String> = arrayListOf()
    var startIndex = 0;
    var endIndex = 0;

    variableName.forEachIndexed { index, c ->

        if (index != 0) {
            if (c.isUpperCase()) {
                endIndex = index - 1
                val curString = variableName.substring(startIndex, endIndex + 1)
                probableWords.add(curString)
                startIndex = index
            }
        }
    }

    probableWords.add(variableName.substring(startIndex, variableName.length))
    println(probableWords)
    println(validSet)
    // [it, Valid]
    probableWords.forEachIndexed { index, s ->
        if (index == 0) {
            if (!validSet.contains(s.makeFirstLetterUpper())) {
                return false
            }
        } else {
            if (!validSet.contains(s)) {
                return false
            }
        }
    }

    return true
}

fun String.makeFirstLetterUpper(): String {
    val result = this.replace(this[0], this[0].uppercaseChar())
    println("makeFirstLetterUpper " + result)
    return result
}


fun canFormCamelCaseWord(words: List<String>, camelCaseWord: String): Boolean {
    if (camelCaseWord.isEmpty() || words.isEmpty()) {
        return false
    }

    val splitWords = camelCaseWord.split("/(?=[A-Z])/").map {
        it.lowercase()
    }

    return splitWords.all { word -> words.contains(word) }
}