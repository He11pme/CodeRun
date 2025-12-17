package task375

import kotlin.math.pow
import kotlin.system.measureTimeMillis

private val tests = listOf(
    // Public tests
    Test(
        "Test 1",
        Input("4","1 2 3"),
        "16"
    ),
    Test(
        "Test 2",
        Input("2","1 4 3"),
        "11"),

    // My test
    Test(
        "My Test 1",
        Input("1","4 4 4"),
        "13"),
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
    val k = "${(0..10.0.pow(4).toInt()).random()}"
    val n = 10.0.pow(5).toInt()
    val ai = StringBuilder().apply {
        (1..n).forEach {
            val a = (0..10.0.pow(4).toInt()).random()
            append("$a")
            append(" ")
        }
    }.toString().trimEnd()
    return Test(
        title = "LOOONG TEST",
        input = Input(k, ai),
        answer = "I don't know"
    )
}

data class Test(
    val title: String,
    val input: Input,
    val answer: String
)