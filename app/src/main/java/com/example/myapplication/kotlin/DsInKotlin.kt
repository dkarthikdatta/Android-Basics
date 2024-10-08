package com.example.myapplication.kotlin

import com.example.myapplication.Notepad


fun main() {
    val dsInKotlin = DsInKotlin()

}
class DsInKotlin {

    // int normalInt = 2;
    var normalInt = 2

    // int[] integerArray = new int[2];
    var integerArray: IntArray? = IntArray(2)

    // int[] intArrayInitialization = new int[]{1,2};
    var intArrayInitialization = intArrayOf(1, 2)

    // String[] stringArray = new String[2];
    var stringArray: Array<String?>? = arrayOfNulls<String>(2)

    // String[] stringArrayInit = new String[]{"a", "b"};
    var stringArrayInit = arrayOf("a", "b")

    // Notepad[] customObjectArray = new Notepad[2];
    var customObjectArray = arrayOfNulls<Notepad>(2)

    // Notepad[] customObjectArrayInitialization = new Notepad[]{new Notepad(), new Notepad()};
    var customObjectArrayInitialization = arrayOf(Notepad(), Notepad())

    var twoDArray = Array(5) {
        IntArray(
            2
        )
    }


}