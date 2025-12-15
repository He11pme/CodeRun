package task164

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
    val s = readln()
    val t = readln()
    return Input(s, t)
}

private fun solution(input: Input): Int {
    var indexMagicSubstring = -1

    val s = input.s
    val t = input.t

    val lengthMagicString = t.length

    if (lengthMagicString == 0 || s.isEmpty() || lengthMagicString > s.length) return indexMagicSubstring

    val countRepeat = input.s.length - lengthMagicString + 1

    var countContinue = 0
    for (index in (0 until countRepeat)) {

        if (countContinue > 0) {
            countContinue -= 1
            continue
        }

        val str = s.slice(index until index + lengthMagicString).toMutableList()
        t.forEach {
            str.remove(it)
        }

        if (str.size == 1) {
            indexMagicSubstring = index
            break
        }

        countContinue = str.size - 2
    }

    return indexMagicSubstring
}

private fun getAnswer(answer: Int): String {
    return answer.toString()
}

data class Input(val s: String, val t: String)