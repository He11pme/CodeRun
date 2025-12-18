package normal.task242

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

private fun solution(input: String): StringBuilder {
    val blocks = mutableSetOf<String>()
    val answer = StringBuilder()
    var lastBlock = ""
    input.forEachIndexed { index, it ->
        lastBlock += it
        if (blocks.add(lastBlock)) {
            answer.append(lastBlock).append(" ")
            lastBlock = ""
            return@forEachIndexed
        } else if (index == input.lastIndex) {
            answer.append(lastBlock)
        }
    }
    return answer
}

private fun getAnswer(blocks: StringBuilder): String {
    return blocks.toString().trimEnd()
}