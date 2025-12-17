package task375

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
    val k = readln()

    // Количество шуток мне неинтересно
    readln()

    val times = readln()
    return Input(k, times)
}

private fun solution(input: Input): Int {

    val k = input.k.toInt()
    val times = input.times.split(" ").map { it.toInt() }

    // Самый первый вариант с улучшением, когда шутку выгодно поставить в начало
    var lastSum = times.sum() + k

    var result = lastSum

    times.forEach {
        lastSum += k - it
        if (result < lastSum) result = lastSum
    }

    return result
}

private fun getAnswer(answer: Int): String {
    return answer.toString()
}

data class Input(val k: String, val times: String)