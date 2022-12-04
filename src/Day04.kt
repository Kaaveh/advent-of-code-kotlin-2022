infix fun IntRange.subrange(other: IntRange): Boolean =
    (this.first in other && this.last in other) || other.first in this && other.last in this

private fun parse(row: String): Pair<IntRange, IntRange> {
    val (section1Start, section1End) = row.substringBefore(",").split("-").map { it.toInt() }
    val (section2Start, section2End) = row.substringAfter(",").split("-").map { it.toInt() }
    return section1Start..section1End to section2Start..section2End
}

private fun part1(input: List<String>): Long = input.sumOf { row ->
    val (section1, section2) = parse(row = row)
    when {
        section1 subrange section2 -> 1L
        else -> 0L
    }
}

private fun part2(input: List<String>): Long = input.sumOf { row ->
    val (section1, section2) = parse(row = row)
    when {
        (section1 intersect section2).isNotEmpty() -> 1
        else -> 0L
    }
}

fun main() {
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2L)
    check(part2(testInput) == 4L)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
