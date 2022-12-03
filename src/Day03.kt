fun main() {
    fun part1(input: List<String>): Int {
        val priorityScore = mutableListOf<Int>()

        input.forEach { items ->
            val first = items.substring(0 until items.length / 2)
            val second = items.substring(items.length / 2 until items.length)

            val common = first.first { it in second }

            if (common.isLowerCase()) {
                priorityScore.add(
                    common - 'a' + 1
                )
            } else {
                priorityScore.add(
                    common - 'A' + 27
                )
            }
        }

        return priorityScore.sum()
    }

    fun part2(input: List<String>): Int {

        val priorityScore = mutableListOf<Int>()

        for (x in 0 until input.size / 3) {
            val first = input[3 * x]
            val second = input[3 * x + 1]
            val third = input[3 * x + 2]

            val common = first.first { it in second && it in third }

            if (common.isLowerCase()) {
                priorityScore.add(
                    common - 'a' + 1
                )
            } else {
                priorityScore.add(
                    common - 'A' + 27
                )
            }
        }

        return priorityScore.sum()
    }

    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
