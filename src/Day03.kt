val Char.priority
    get(): Int = when (this) {
        in 'a'..'z' -> this - 'a' + 1
        in 'A'..'Z' -> this - 'A' + 27
        else -> error("Wrong input! $this")
    }

inline infix fun String.singleIntersect(other: String) = (toSet() intersect other.toSet()).single()
inline infix fun Char.singleIntersect(other: String) = (setOf(this) intersect other.toSet()).single()

fun part1(input: List<String>): Int = input.sumOf { items ->
    val first = items.substring(0 until items.length / 2)
    val second = items.substring(items.length / 2)
    val common = first singleIntersect second
    common.priority
}

fun part2(input: List<String>): Int = input.chunked(3).sumOf { elfGroup ->
    val (first, second, third) = elfGroup
    val common = first singleIntersect second singleIntersect third
    common.priority
}

fun main() {
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
