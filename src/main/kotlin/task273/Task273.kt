package task273

import kotlin.apply
import kotlin.math.max
import kotlin.math.min

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

// Если разбирать значения прямо во время ввода,
// то можно ускорить решение задачи.
// Но для тестов мне удобнее так
private fun readInput(): Input {
    val (s, n) = readln().split(" ").map { it.toInt() }
    return Input(s, n).apply {
        // Была ошибка, не прочитал правильно условие задачи
        // Координаты домов приходили не каждая в своей строке, а все в одной
        coordinates.addAll(readln().split(" ").map { it.toInt() })
    }
}

private fun solution(input: Input): Int {
    // Расстояние до самого дальнего дома слева
    var left = 0

    // Расстояние до самого дальнего дома справа
    var right = 0

    input.coordinates.forEach { house ->
        val distance: Int
        when {
            house < input.s -> {
                distance = input.s - house
                if (left < distance) left = distance
            }
            house > input.s -> {
                distance = house - input.s
                if (right < distance) right = distance
            }
        }
    }

    val minDistance = min(left, right) * 2 + max(left, right)
    return minDistance
}

private fun getAnswer(answer: Int): String {
    return answer.toString()
}

data class Input(val s: Int, val n: Int) {
    val coordinates = mutableListOf<Int>()
}