package normal.task462

import kotlin.math.sqrt

var answer: String = ""
    private set

fun main() {
    val input = readInput()
    start(input)
}

fun start(input: Input) {
    answer = getAnswer(solution(input))
    println(answer)
}

private fun readInput(): Input {
    val n = readln()

    val seventhChord = readln()
    return Input(n, seventhChord)
}

private fun solution(input: Input): Int {

    val seventhChord = input.seventhChord.split(" ").map { it.toInt() }
    // корень(септакордов) to количество произведений
    val associate = mutableMapOf<Int, Int>()

    seventhChord.forEach {
        associate[sqrt(it.toFloat()).toInt()] = associate.getOrDefault(sqrt(it.toFloat()).toInt(), 0) + 1
    }

    var lastSize = 0

    (associate.keys.sortedDescending()).forEach { k ->
        lastSize += associate.getOrDefault(k, 0)
        if (k <= lastSize) return k
    }

    return 0
}

private fun getAnswer(answer: Int): String {
    return answer.toString()
}

data class Input(val n: String, val seventhChord: String)
