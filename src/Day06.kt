private fun part1(input: String): Int {
    for (i in input.indices) {
        val count = input.substring(i, i + 4)
            .toSet()
            .size
        if(count == 4){
            return i + 4
        }
    }

    return 0
}

private fun part2(input:String): Int {
    for (i in input.indices) {
        val count = input.substring(i, i + 14)
            .toSet()
            .size
        if(count == 14){
            return i + 14
        }
    }

    return 0
}

fun main() {
    val testInput = readInput("Day06_test")[0]
    check(part1(testInput) == 7)
    check(part2(testInput) == 19)

    val input = readInput("Day06")[0]
    println(part1(input))
    println(part2(input))
}
