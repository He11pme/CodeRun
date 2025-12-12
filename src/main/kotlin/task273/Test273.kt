package task273

import kotlin.math.pow
import kotlin.random.Random
import kotlin.system.measureTimeMillis

private val tests = listOf(
    // Public tests
    Test(
        "Test 1",
        Input("25270880", "-48940870"),
        "74211750"),

    // My test
    Test(
        title = "My test 1",
//        input = Input(1, 3).apply { coordinates.addAll(listOf(-3, 2, -1)) },
        input = Input("1", "-3 2 -1"),
        answer = "6"
    ),
    Test(
        title = "My test 2",
        input = Input("0", "10 -3 -10 3"),
//        input = Input(0, 4).apply { coordinates.addAll(listOf(10, -3, -10, 3)) },
        answer = "30"
    ),
    Test(
        title = "My test 3",
        input = Input("-15", "10 -3 -10 3"),
//        input = Input(-15, 4).apply { coordinates.addAll(listOf(10, -3, -10, 3)) },
        answer = "25"
    ),
    Test(
        title = "My test 4",
        input = Input("-15", "-20 10 -3 -10 3"),
//        input = Input(-15, 4).apply { coordinates.addAll(listOf(-20, 10, -3, -10, 3)) },
        answer = "35"
    ),
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
    val maxDistance = (10.0.pow(8)).toInt()
    val left = -maxDistance
    val right = maxDistance
    val s = Random.nextInt(left, right).toString()
    val longInput = StringBuilder().apply {
        (1..100000).forEach {
            append(Random.nextInt(left, right))
            append(" ")
        }
    }.toString().trimEnd()
    return Test(
        "LONG test",
        Input(s, longInput),
        "0"
    )
}

data class Test(
    val title: String,
    val input: Input,
    val answer: String
)