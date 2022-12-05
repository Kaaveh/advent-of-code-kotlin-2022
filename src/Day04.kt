infix fun IntRange.fullyOverlap(other: IntRange): Boolean =
    (first in other && last in other) || other.first in this && other.last in this

private fun parse(row: String): Pair<IntRange, IntRange> {
    val (section1Start, section1End) = row.substringBefore(",").split("-").map { it.toInt() }
    val (section2Start, section2End) = row.substringAfter(",").split("-").map { it.toInt() }
    return section1Start..section1End to section2Start..section2End
}

private fun part1(input: List<String>): Int = input.count { row ->
    val (section1, section2) = parse(row = row)
    section1 fullyOverlap section2
}

private fun part2(input: List<String>): Int = input.count { row ->
    val (section1, section2) = parse(row = row)
    section1.any { it in section2 }
}

fun main() {
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
