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

private fun readInput(): Input {
    // Из первой строки мне нужна только координата офиса
    val s = readln().split(" ")[0]
    val coordinates = readln()

    return Input(s, coordinates)
}

private fun solution(input: Input): Int {
    // Расстояние до самого дальнего дома слева
    var left = 0

    // Расстояние до самого дальнего дома справа
    var right = 0

    input.apply {
        val office = s.toInt()
        coordinates.split(" ").forEach {
            val house = it.toInt()
            val distance: Int
            when {
                house < office -> {
                    distance = office - house
                    if (left < distance) left = distance
                }
                house > office -> {
                    distance = house - office
                    if (right < distance) right = distance
                }
            }
        }
    }

    return min(left, right) * 2 + max(left, right)
}

private fun getAnswer(answer: Int): String {
    return answer.toString()
}

data class Input(val s: String, val coordinates: String)