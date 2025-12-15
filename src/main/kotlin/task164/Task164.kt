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

    val list = input.s.toList()
    val subList = input.t.toList()

    val lengthSubStr = subList.size

    if (lengthSubStr == 0 || list.isEmpty() || lengthSubStr > list.size) return indexMagicSubstring

    val countRepeat = input.s.length - lengthSubStr + 1

    var countContinue = 0
    for (index in (0 until countRepeat)) {

        if (countContinue > 0) {
            countContinue -= 1
            continue
        }

        val str = list.slice(index until index + lengthSubStr).toMutableList()
        subList.forEach {
            str.remove(it)
        }
        println()

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