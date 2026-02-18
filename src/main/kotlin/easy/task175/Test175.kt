package easy.task175

import kotlin.math.pow
import kotlin.system.measureTimeMillis

private val tests = listOf(
    // Public tests
    Test(
        "Test 1",
        Input(2,listOf("s.t.a.l.k.e.r.@yandex.ru", "stalker-winner@yandex.com")),
        "1"
    ),
    Test(
        "Test 2",
        Input(2,listOf("user@yandex.ru", "user@ya.ru")),
        "2"),
    Test(
        "Test 3",
        Input(4,listOf("s.t.a.l.k.e.r.@yandex.ru", "stalker-winner@yandex.com", "user@yandex.ru", "user@mail.yandex.ru")),
        "3"),

    // My test
    Test(
        "Test 4",
        Input(1,listOf("@yandex.ru")),
        "1"),
    createLongTest()
)

fun main() {

    tests.forEach { startWithTime(it) }

}

private fun startWithTime(test: Test) {
    println("start ${test.title}")
    val time = measureTimeMillis { start(test.input) }
    println("answer is ${if (answer == test.answer) "correct" else "incorrect"}!")
    println("${test.title}: lead time = $time ms")
    println()
}

private fun createLongTest(): Test {
    val stEmails = listOf("s.t.a.l.k.e.r.@yandex.ru", "stalker-winner@yandex.com", "user@yandex.ru", "user@mail.yandex.ru")
    val n = 10.0.pow(5).toInt()
    val emails = List(n) {
        stEmails[it % stEmails.size]
    }
    return Test(
        title = "LOOONG TEST",
        input = Input(n, emails),
        answer = "3"
    )
}

data class Test(
    val title: String,
    val input: Input,
    val answer: String
)