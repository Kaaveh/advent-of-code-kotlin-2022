private fun part1(input: List<String>): Int {
    var total = 0
//    val size = 7
    val size = 101
    val array = MutableList(size) { MutableList(size) { 0 } }

    input.forEachIndexed { indexX: Int, row: String ->
        row.forEachIndexed { indexY, element ->
            array[indexX + 1][indexY + 1] = element.toString().toInt()
        }
    }

    for (i in 2..size - 3) {
        for (j in 2..size - 3) {
            val element = array[i][j]
            val maxRowBefore = array[i].subList(fromIndex = 0, toIndex = j).max()
            val maxRowAfter = array[i].subList(fromIndex = j + 1, toIndex = array[i].size).max()
            val maxColumnBefore = true.let {
                val tmp = mutableListOf<Int>()

                for (k in 0 until i) {
                    tmp.add(
                        array[k][j]
                    )
                }
                tmp
                tmp.max()
            }
            val maxColumnAfter = true.let {
                val tmp = mutableListOf<Int>()

                for (k in i + 1 until array[i].size) {
                    tmp.add(
                        array[k][j]
                    )
                }
                tmp
                tmp.max()

            }
            if (
                element <= maxRowBefore &&
                element <= maxRowAfter &&
                element <= maxColumnBefore &&
                element <= maxColumnAfter
            ) {
                total++
            }
        }
    }

    return (size - 2) * (size - 2) - total
}

private fun part2(input: List<String>): Int {
    var max = 0


//    val size = 5
    val size = 99
    val array = MutableList(size) { MutableList(size) { 0 } }

    input.forEachIndexed { indexX: Int, row: String ->
        row.forEachIndexed { indexY, element ->
            array[indexX][indexY] = element.toString().toInt()
        }
    }

    for (i in 1 until size - 1) {
        for (j in 1 until size - 1) {
            val element = array[i][j]
            val scoreRowBefore = array[i].subList(fromIndex = 0, toIndex = j).reversed().let {
                var index = 0

                for (k in it.indices) {
                    if (it[k] < element) {
                        index++
                    } else if (it[k] >= element) {
                        index++
                        break
                    } else {
                        break
                    }
                }

                index
            }
            val scoreRowAfter = array[i].subList(fromIndex = j + 1, toIndex = array[i].size).let {
                var index = 0

                for (k in it.indices) {
                    if (it[k] < element) {
                        index++
                    } else if (it[k] >= element) {
                        index++
                        break
                    } else {
                        break
                    }
                }

                index
            }

            val scoreColumnBefore = true.let {
                var index = 0

                for (k in i-1 downTo 0) {
                    if (array[k][j] < element) {
                        index++
                    } else if (array[k][j] >= element) {
                        index++
                        break
                    } else {
                        break
                    }
                }

                index
            }

            val scoreColumnAfter = true.let {
                var index = 0

                for (k in i + 1 until array[i].size) {
                    if (array[k][j] < element) {
                        index++
                    } else if (array[k][j] >= element) {
                        index++
                        break
                    } else {
                        break
                    }
                }
                index
            }
            val maxTmp = scoreRowBefore * scoreRowAfter * scoreColumnBefore * scoreColumnAfter
            if (maxTmp > max)
                max = maxTmp
        }
    }

    return max
}

fun main() {
    val testInput = readInput("Day08_test")
//    check(part1(testInput) == 21)
//    check(part2(testInput) == 8)

    val input = readInput("Day08")
//    println(part1(input))
    println(part2(input))
}
