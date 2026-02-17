package easy.task467


var answer: String = ""
    private set

fun main() {
    val input = readInput()
    start(input)
}

fun start(input: String) {
    answer = getAnswer(solution(input))
    println(answer)
}

private fun readInput(): String {
    return readln()
}

private fun solution(input: String): String {
    val firstHalf = input.take(3).toInt()
    var secondHalf = input.takeLast(3).toInt()
    val answer = StringBuilder()

    loop@ for (i in firstHalf..999) {
        val sumFirstHalf = i.sumOfDigit()
        for (k in secondHalf..999) {
            val sumSecondHalf = k.sumOfDigit()

            if (sumFirstHalf != sumSecondHalf) continue

            answer.apply {
                append(i)
                repeat(3 - k.size) { append(0) }
                append(k)
            }
            break@loop
        }
        secondHalf = 0
    }

    return answer.toString()
}

private fun getAnswer(ans: String): String {
    return ans
}

private fun Int.sumOfDigit(): Int {
    return this.toString().sumOf { it.digitToInt() }
}

private val Int.size get() = this.toString().length