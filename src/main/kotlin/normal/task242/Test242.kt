package normal.task242

import kotlin.system.measureTimeMillis

private val tests = listOf(
    // Public tests
    Test("Test 1", "11001110011", "1 10 0 11 100 11"),
    Test("Test 2", "1111111", "1 11 111 1"),
    Test("Test 3", "10101010111110000101010010", "1 0 10 101 01 11 110 00 010 1010 010"),
    Test("Test 4", "000001111110000001111110000110", "0 00 001 1 11 110 000 0011 111 10 0001 10"),

    // My test
    createLongTest()
)

fun main() {

    tests.forEach { startWithTime(it) }

}

private fun startWithTime(test: Test) {
    val time = measureTimeMillis { start(test.input) }
    println("answer is ${if (answer == test.answer) "correct" else "incorrect"}!")
    println("${test.title}: lead time = $time ms")
}

private fun createLongTest(): Test {
    val variants = listOf('0', '1')
    val longInput = StringBuilder().apply {
        (1..1000000).forEach {
            append(variants.random())
        }
    }.toString()
    return Test(
        title = "LONG TEST",
        input = longInput,
        answer = ""
    )
}

data class Test(
    val title: String,
    val input: String,
    val answer: String
)