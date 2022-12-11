private fun part1(input: List<String>): Int {
    var total = 0
    var x = 1
    var clock = 0
    var iteration = 20

    input.forEach { command ->
        clock++
        if (clock == iteration) {
            total += iteration * x
            iteration += 40
        }

        if (command != "noop") {
            val newValue = command.substringAfter(" ").toInt()
            clock++
            if (clock == iteration) {
                total += iteration * x
                iteration += 40
            }
            x += newValue
        }
    }

    return total
}

private fun part2(input: List<String>) {
    var x = 1
    var clock = 1

    input.forEach { command ->
        printPixel(index = clock - 1, x = x)
        clock++

        if (command != "noop") {
            printPixel(index = clock - 1, x = x)
            clock++
            val newValue = command.substringAfter(" ").toInt()
            x += newValue
        }
    }

}

private fun printPixel(index: Int, x: Int) {
    val adjustedIndex: Int = index % 40
    if (adjustedIndex == 0) {
        println()
    }
    if (adjustedIndex in x - 1..x + 1) {
        print("#")
    } else {
        print(".")
    }
}

fun main() {
    val testInput = readInput("Day10_test")
    check(part1(testInput) == 13140)

    val input = readInput("Day10")
    println(part1(input))
    println(part2(input))
}
