fun main() {
    fun part1(input: List<String>): Int {

        var totalScore = 0

        input.forEach {
            val data = it.split(" ")
            totalScore += when (data[1]) {
                "X" -> 1
                "Y" -> 2
                else -> 3
            }

            totalScore += when (data[0]) {
                "A" -> {
                    when (data[1]) {
                        "X" -> 3
                        "Y" -> 6
                        else -> 0
                    }
                }

                "B" -> {
                    when (data[1]) {
                        "X" -> 0
                        "Y" -> 3
                        else -> 6
                    }
                }

                else -> {
                    when (data[1]) {
                        "X" -> 6
                        "Y" -> 0
                        else -> 3
                    }
                }
            }
        }

        return totalScore
    }

    fun part2(input: List<String>): Int {

        var totalScore = 0

        input.forEach {
            val data = it.split(" ")
            totalScore += when (data[1]) {
                "X" -> 0
                "Y" -> 3
                else -> 6
            }

            totalScore += when (data[0]) {
                "A" -> {
                    when (data[1]) {
                        "X" -> 3
                        "Y" -> 1
                        else -> 2
                    }
                }

                "B" -> {
                    when (data[1]) {
                        "X" -> 1
                        "Y" -> 2
                        else -> 3
                    }
                }

                else -> {
                    when (data[1]) {
                        "X" -> 2
                        "Y" -> 3
                        else -> 1
                    }
                }
            }
        }

        return totalScore
    }

    val testInput = readInput("Day02_test")
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
