private fun parse(input: List<String>): Pair<Int, MutableList<MutableList<Char>>> {
    val rawMap = mutableListOf<String>()
    var mapIndex = 0

    do {
        rawMap.add(input[mapIndex])
        mapIndex++
    } while ("[" in input[mapIndex])

    val rowCount = input[mapIndex].trim().split("\\s+".toRegex()).size

    val movementIndex = mapIndex + 2
    val stations = MutableList<MutableList<Char>>(rowCount) { mutableListOf() }

    rawMap.forEach { row ->
        val elements = row.chunked(4).map { it.trim() }
        elements.forEachIndexed { index, element ->
            if (element.isNotEmpty()) {
                val new = element.replace("[", "").replace("]", "")[0]
                stations[index].add(new)
            }
        }
    }

    return Pair(movementIndex, stations)
}

private fun String.toMovement(): Triple<Int, Int, Int> {
    val movement = this
        .replace("move ", "")
        .replace(" from ", ",")
        .replace(" to ", ",")
        .trim()
    val (number, source, destination) = movement.split(",").map { it.toInt() }
    return Triple(number, source, destination)
}

private fun part1(input: List<String>): String {
    val (movementIndex, stations) = parse(input)

    for (i in movementIndex until input.size) {
        val (number, source, destination) = input[i].toMovement()

        repeat(number) {
            stations[destination - 1].add(0, stations[source - 1].removeFirst())
        }
    }

    return stations.map { it.first() }.joinToString("")
}

private fun part2(input: List<String>): String {
    val (movementIndex, stations) = parse(input)

    for (i in movementIndex until input.size) {
        val (number, source, destination) = input[i].toMovement()
        stations[source - 1]
            .subList(0, number)
            .reversed()
            .forEach {
                stations[destination - 1].add(0, it)
                stations[source - 1].removeFirst()
            }
    }

    return stations.map { it.first() }.joinToString("")
}

fun main() {
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
