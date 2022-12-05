private fun parse(input: List<String>): Pair<Int, MutableList<MutableList<Char>>> {
    val rawMap = mutableListOf<String>()
    val stations = mutableListOf<MutableList<Char>>()
    var mapIndex = 0

    do {
        rawMap.add(input[mapIndex])
        mapIndex++
    }while ( "[" in input[mapIndex])

    val rowCount = input[mapIndex].trim().split("\\s+".toRegex()).size

    val movementIndex = mapIndex + 2

    repeat(rowCount) {
        stations.add(mutableListOf())
    }

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

private fun part1(input: List<String>): String {
    val (movementIndex, stations) = parse(input)

    for (i in movementIndex until input.size) {
        val movement = input[i]
            .replace("move ", "")
            .replace(" from ", ",")
            .replace(" to ", ",")
            .trim()
        val (number, source, destination) = movement.split(",").map { it.toInt() }

        repeat(number) {
            val new = stations[source - 1].removeFirst()
            stations[destination - 1].add(0, new)
        }
    }

    val result = mutableListOf<Char>()

    stations.forEach {
        result.add(
            it.first()
        )
    }
    return String(result.toCharArray())
}

private fun part2(input: List<String>): String {
    val (movementIndex, stations) = parse(input)

    for (i in movementIndex until input.size) {
        val movement = input[i]
            .replace("move ", "")
            .replace(" from ", ",")
            .replace(" to ", ",")
            .trim()

        val (number, source, destination) = movement.split(",").map { it.toInt() }

        val subItem = stations[source - 1].subList(0, number).reversed()

        subItem.forEach {
            stations[destination - 1].add(0, it)
            stations[source - 1].removeAt(0)
        }

    }

    val result = mutableListOf<Char>()

    stations.forEach {
        result.add(
            it.first()
        )
    }
    return String(result.toCharArray())
}

fun main() {
    val testInput = readInput("Day05_test")
    check(part1(testInput) == "CMZ")
    check(part2(testInput) == "MCD")

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
