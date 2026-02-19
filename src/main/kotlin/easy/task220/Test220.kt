package easy.task220

import kotlin.math.pow
import kotlin.system.measureTimeMillis

private val tests = listOf(
    // Public tests
    Test(
        "Test 1",
        Input(
            6,
            listOf(-7, 3, 8, 12, -3, -10),
            7,
            listOf(-12, 13, -5, -3, 5, -2, 0)
        ),
        "-10\n12\n-3\n-3\n3\n-3\n3"
    ),
    Test(
        "Test 2",
        Input(
            16,
            listOf(20, -27, 12, 21, -7),
            12,
            listOf(
                -18,
                19,
                -27,
                -9,
                -26,
                -6,
                -2,
                -20,
                0,
                -3,
                16,
                -12
            )
        ),
        "-27\n" +
                "20\n" +
                "-27\n" +
                "-7\n" +
                "-27\n" +
                "-7\n" +
                "-7\n" +
                "-27\n" +
                "-7\n" +
                "-7\n" +
                "20\n" +
                "-7"
    ),
    Test(
        "Test 3",
        Input(
            16,
            listOf(-1, -20, -17, 25, 24, 18, -12, -11, 14, 9, 7, -2, -29, -13, 29, 6),
            7,
            listOf(
                -25,
                -14,
                20,
                -23,
                24,
                26,
                18
            )
        ),
        "-29\n" +
                "-13\n" +
                "18\n" +
                "-20\n" +
                "24\n" +
                "25\n" +
                "18"
    ),

    // My test
//    createLongTest()
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
    val n = 50_000
    val a = List(n) {
        val ai = (0..10.0.pow(6).toInt()).random()
        val r = listOf(true, false).random()
        if (r) ai else -ai
    }
    val m = 50_000
    val j = List(m) {
        val ai = (0..10.0.pow(6).toInt()).random()
        val r = listOf(true, false).random()
        if (r) ai else -ai
    }
    return Test(
        title = "LOOONG TEST",
        input = Input(
            n = n,
            a = a,
            m = m,
            j = j,
        ),
        answer = "i don't know"
    )
}

data class Test(
    val title: String,
    val input: Input,
    val answer: String
)