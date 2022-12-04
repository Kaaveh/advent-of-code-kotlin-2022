val Char.priority
    get(): Int {
        return if (this.isLowerCase()) {
            this - 'a' + 1

        } else {
            this - 'A' + 27
        }
    }

fun main() {

    fun part1(input: List<String>): Int = input.sumOf { items ->
        val first = items.substring(0 until items.length / 2)
        val second = items.substring(items.length / 2)
        val common = first.first { it in second }
        common.priority
    }

    fun part2(input: List<String>): Int = input.chunked(3).sumOf { elfGroup ->
        val common = elfGroup[0].first { it in elfGroup[1] && it in elfGroup[2] }
        common.priority
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
