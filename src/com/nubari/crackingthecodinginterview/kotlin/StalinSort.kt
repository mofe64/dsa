package com.nubari.crackingthecodinginterview


fun main() {
    println("Hello world!")
    val x: IntArray = intArrayOf(4, 17, 5, 6, 12, 1, 9);
    val result = stalinSort(x);
    println(result)

}

fun stalinSort(unsortedArray: IntArray): ArrayList<Int> {
    val stalinSorted = arrayListOf<Int>()
    stalinSorted.add(unsortedArray[0])
    for (i in unsortedArray.indices) {
        if (unsortedArray[i] > unsortedArray[i - 1]) {
            stalinSorted.add(unsortedArray[i])
        } else {
            val resultSize = stalinSorted.size
            stalinSorted.remove(unsortedArray[i - 1])
            if (resultSize != 0) {
                if (stalinSorted.size == 0) {
                    stalinSorted.add(unsortedArray[i])
                } else if (unsortedArray[i] > stalinSorted[stalinSorted.size - 1]) {
                    stalinSorted.add(unsortedArray[i])
                }
            }
        }
    }
    return stalinSorted
}