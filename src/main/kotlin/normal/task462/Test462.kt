package normal.task462

import kotlin.math.pow
import kotlin.system.measureTimeMillis

private val tests = listOf(
    // Public tests
    Test(
        "Test 1",
        Input("5","1 0 4 5 100"),
        "2"
    ),
    Test(
        "Test 2",
        Input("3","0 0 0"),
        "0"),
    Test(
        "Test 3",
        Input("4","25 50 100 75"),
        "4"),

    // My test
    Test(
        "My Test 1",
        Input("1","2"),
        "1"),
    Test(
        "My test 2",
        Input("8","1 0 4 5 25 28 36 27"),
        "4"
    ),
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
    val n = 10.0.pow(7).toInt()
    val ai = StringBuilder().apply {
        (0 until n).forEach {
            val a = (0..10.0.pow(5).toInt()).random()
            append("$a")
            append(" ")
        }
    }.toString().trimEnd()
    return Test(
        title = "LOOONG TEST",
        input = Input(n.toString(), ai),
        answer = "I don't know"
    )
}

data class Test(
    val title: String,
    val input: Input,
    val answer: String
)