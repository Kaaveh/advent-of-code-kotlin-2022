private fun part1(input: List<String>): Int {
    var total = 0
    var x = 1
    var clock = 0
    var iteration = 20

    input.forEach { command ->
        when (command) {
            "noop" -> {
                clock++
                if (clock == iteration) {
                    total += iteration * x
                    iteration += 40
                }
            }

            else -> {
                val newValue = command.substringAfter(" ").toInt()
                clock++
                if (clock == iteration) {
                    total += iteration * x
                    iteration += 40
                }
                clock++
                if (clock == iteration) {
                    total += iteration * x
                    iteration += 40
                }
                x += newValue
            }
        }
    }

    return total
}

private fun part2(input: List<String>): Int {
    var max = 0

    return max
}

fun main() {
    val testInput = readInput("Day10_test")
    check(part1(testInput) == 13140)
//    check(part2(testInput) == 8)

    val input = readInput("Day10")
    println(part1(input))
//    println(part2(input))
}
