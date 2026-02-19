package easy.task220

import kotlin.math.abs
import kotlin.math.roundToInt

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

        var left = 0
        var right = a.lastIndex
//        println("search number: $j")
        while (left <= right) {
//            println(a.take(right + 1).drop(left))
            val mid = ((left + right) / 2.0).roundToInt()
            val aMid = a[mid]
//            println("mid = $aMid; index = $mid")
            val diff = abs(aMid - j)

            if (diff < minDiff) {
                minDiff = diff
                lastNumber = aMid
            }

            if (j > aMid) left = mid + 1
            else right = mid - 1
        }
//        println("\n")
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