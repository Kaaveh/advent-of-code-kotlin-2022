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

        elfList.sortDescending()

        var total = 0
        repeat(3) {
            if (elfList.isNotEmpty()){
                total += elfList[0]
                elfList.removeAt(0)
            }
        }


        return total
    }

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
