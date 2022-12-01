fun main() {
    fun part1(input: List<String>): Int {
        val elfList = mutableListOf<Int>()
        var tmp = 0

        input.forEach { item ->
            if (item.isEmpty()) {
                elfList.add(tmp)
                tmp = 0
            } else {
                tmp += item.toInt()
            }
        }

        return elfList.max()
    }

    fun part2(input: List<String>): Int {
        val elfList = mutableListOf<Int>()
        var tmp = 0

        input.forEach { item ->
            if (item.isEmpty()) {
                elfList.add(tmp)
                tmp = 0
            } else {
                tmp += item.toInt()
            }
        }

        return elfList.sortedDescending().take(3).sum()
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
