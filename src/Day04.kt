fun main() {
    fun part1(input: List<String>): Int {
        var common = 0

        input.forEach { row ->
            val (section1, section2) = row.split(",")

            val (section1First, section1Second) = section1.split("-").map { it.toInt() }
            val (section2First, section2Second) = section2.split("-").map { it.toInt() }

            common += when {
                (section1First <= section2First && section1Second >= section2Second) ||
                        section2First <= section1First && section2Second >= section1Second
                -> 1

                else -> 0
            }

        }

        return common
    }

    fun part2(input: List<String>): Int {
        var common = 0

        input.forEach { row ->
            val (section1, section2) = row.split(",")

            val (section1Start, section1End) = section1.split("-").map { it.toInt() }
            val (section2Start, section2End) = section2.split("-").map { it.toInt() }

            common += when {
                (section1Start <= section2Start && section1End >= section2End) ||
                        (section2Start <= section1Start && section2End >= section1End) ||
                        section1Start in section2Start..section2End ||
                        section2Start in section1Start..section1End ||
                        section2End in section1Start..section1End
                -> 1

                else -> 0
            }

        }

        return common
    }

    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
