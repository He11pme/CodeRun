package task164

import kotlin.math.pow
import kotlin.system.measureTimeMillis

private val tests = listOf(
    // Public tests
    Test(
        "Test 1",
        Input("abcddc", "ccde"),
        "2"),
    Test(
        "Test 2",
        Input("abcd", "dcba"),
        "-1"),
    Test(
        "Test 3",
        Input("abcd", "abef"),
        "-1"),

    // My test
    Test(
        "My Test 1",
        Input("", "abef"),
        "-1"),
    Test(
        "My Test 2",
        Input("abcd", ""),
        "-1"),
    Test(
        "My Test 3",
        Input("abcd", "a"),
        "1"),
    Test(
        "My Test 4",
        Input("abcd", "afdss"),
        "-1"),
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
    val longS = StringBuilder().apply {
        (1..10.0.pow(8).toInt()).forEach {
            append(('a'..'z').random())
        }
    }.toString()
    val substring = StringBuilder().apply {
        (1..(3..10.0.pow(8).toInt()).random()).forEach {
            append(('a'..'z').random())
        }
    }.toString()

    return Test(
        "LONG test",
        Input(longS, substring),
        "0"
    )
}

data class Test(
    val title: String,
    val input: Input,
    val answer: String
)