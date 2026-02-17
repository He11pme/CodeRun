package easy.task467

import kotlin.system.measureTimeMillis

private val tests = listOf(
    // Public tests
    Test("Test 1", "165901", "165903"),
    Test("Test 2", "100000", "100001"),
    Test("Test 3", "201110", "201111"),

    // My test
    Test("My test 1", "222700", "223007"),
)

fun main() {

    tests.forEach { startWithTime(it) }

}

private fun startWithTime(test: Test) {
    val time = measureTimeMillis { start(test.input) }
    println("answer is ${if (answer == test.answer) "correct" else "incorrect"}!")
    println("${test.title}: lead time = $time ms")
}

data class Test(
    val title: String,
    val input: String,
    val answer: String
)