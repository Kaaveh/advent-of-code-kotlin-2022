private fun part1And2(input: String, size: Int) = input.windowed(size).indexOfFirst { it.toSet().size == size } + size

fun main() {
    val testInput = readInput("Day06_test")[0]
    check(part1And2(testInput, 4) == 7)
    check(part1And2(testInput, 14) == 19)

    val input = readInput("Day06")[0]
    println(part1And2(input, 4))
    println(part1And2(input, 14))
}
