private fun parse(input: List<String>, size: Int): MutableList<MutableList<Int>> {
    val array = MutableList(size) { MutableList(size) { 0 } }

    input.forEachIndexed { indexX: Int, row: String ->
        row.forEachIndexed { indexY, element ->
            array[indexX][indexY] = element.digitToInt()
        }
    }
    return array
}

private fun part1(input: List<String>): Int {
    var total = 0
    val size = input.size
    val array = parse(input, size)

    for (i in 0 until size) {
        for (j in 0 until size) {
            val element = array[i][j]
            val leftVisible = (0 until j).all { array[i][it] < element }
            val rightVisible = (j + 1 until array[i].size).all { array[i][it] < element }
            val topVisible = (0 until i).all { k -> array[k][j] < element }
            val bottomVisible = (i + 1 until array[i].size).all { k -> array[k][j] < element }
            if (
                leftVisible || rightVisible || topVisible || bottomVisible ||
                i == 0 || j == 0 || i == size - 1 || j == size - 1
            ) {
                total++
            }
        }
    }

    return total
}

private fun part2(input: List<String>): Int {
    var max = 0
    val size = input.size
    val array = parse(input, size)

    for (i in 1 until size - 1) {
        for (j in 1 until size - 1) {
            val element = array[i][j]
            val scoreRowBefore = array[i].subList(fromIndex = 0, toIndex = j).reversed().let {
                var index = it.size
                for (k in it.indices) {
                    if (it[k] >= element){
                        index = k + 1
                        break
                    }
                }
                index
            }
            val scoreRowAfter = array[i].subList(fromIndex = j + 1, toIndex = array[i].size).let {
                var index = it.size

                for (k in it.indices) {
                    if (it[k] >= element){
                        index = k + 1
                        break
                    }
                }

                index
            }

            val scoreColumnBefore = (i - 1 downTo 0).let {
                var index = 0

                for (k in i - 1 downTo 0) {
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
    check(part1(testInput) == 21)
    check(part2(testInput) == 8)

    val input = readInput("Day08")
//    println(part1(input))
//    println(part2(input))
}
