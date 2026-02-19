package easy.task220

import kotlin.math.abs

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
    val n = readln().toInt()
    val a = readln().split(" ").map { it.toInt() }
    val m = readln().toInt()
    val j = List(m) { readln().toInt() }

    return Input(n, a, m, j)
}

private fun solution(input: Input): String {
    val ans = StringBuilder()

    val a = input.a.sorted()
    input.j.forEachIndexed { index, j ->
        var minDiff = Int.MAX_VALUE
        var lastNumber = j
        for (i in 0 until a.size) {
            val ai = a[i]
            val diff = abs(ai - j)
            if (diff < minDiff) {
                minDiff = diff
                lastNumber = ai
            }
            else break
        }
        ans.append("$lastNumber")
        if (index != input.j.lastIndex) ans.append("\n")
    }

    return ans.toString()
}

private fun getAnswer(ans: String): String {
    return ans
}

data class Input(
    val n: Int,
    val a: List<Int>,
    val m: Int,
    val j: List<Int>
)