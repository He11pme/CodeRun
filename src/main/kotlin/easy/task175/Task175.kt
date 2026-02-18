package easy.task175

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
    val emails = List(n) { readln() }

    return Input(n, emails)
}

private fun solution(input: Input): Int {
    val users = mutableSetOf<String>()
    val symbols = listOf('@', '-')
    input.emails.forEach { email ->
        val login = email.takeWhile { !symbols.contains(it) }.replace(".", "")
        val domain = email.takeLastWhile { it != '@' }.dropLastWhile { it != '.'}
        users.add("$login$domain")
//        println("login: $login; domain: $domain")
    }

    return users.size
}

private fun getAnswer(ans: Int): String {
    return ans.toString()
}

data class Input(
    val n: Int,
    val emails: List<String>
)