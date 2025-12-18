package normal.task279

import kotlin.math.pow
import kotlin.system.measureTimeMillis

private val tests = listOf(
    // Public tests
    Test(
        "Test 1",
        Input(listOf(1, 2, 3), listOf(Room(2, 3))),
        "No"
    ),
    Test(
        "Test 2",
        Input(listOf(1, 2, 3), listOf(Room(3, 2))),
        "No"
    ),
    Test(
        "Test 3",
        Input(listOf(1, 2, 3), listOf(Room(3, 3))),
        "Yes"
    ),
    Test(
        "Test 4",
        Input(
            listOf(1, 2, 3), listOf(
                Room(1, 1),
                Room(2, 1),
                Room(3, 1),
                Room(4, 1)
            )
        ),
        "Yes"
    ),
    Test(
        "Test 5",
        Input(
            listOf(1, 1, 1, 1, 1), listOf(
                Room(1, 1),
                Room(1, 1),
                Room(1, 1),
                Room(1, 1),
                Room(1, 1)
            )
        ),
        "Yes"
    ),

    // My test
    Test(
        "My test 1",
        Input(
            listOf(1, 2, 3), listOf(
                Room(1, 3),
                Room(2, 2)
            )
        ),
        "No"
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
    val numberAthletes = (0..10.0.pow(4).toInt()).map {
        (0..10.0.pow(4).toInt()).random()
    }

    val rooms = (0..10.0.pow(4).toInt()).map {
        Room(
            (0..10.0.pow(4).toInt()).random(),
            (0..10.0.pow(4).toInt()).random()
        )
    }

    return Test(
        "LOOOONG TEST",
        Input(numberAthletes, rooms),
        "I don't know"
    )
}

data class Test(
    val title: String,
    val input: Input,
    val answer: String
)