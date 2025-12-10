package task237

import kotlin.system.measureTimeMillis

val employees = mutableMapOf<Int, Employee>()

fun main() {
    startWithTime(readInput())
}

private fun startWithTime(input: String) {

    val time = measureTimeMillis { start(input) }
    println("Lead time: $time ms")

}

private fun start(input: String) {

    solution(input)
    printAnswer(employees.values)

}

private fun readInput(isFake: Boolean = false): String {
    if (isFake) {
        return (0..199999).joinToString(" ")
    } else {
        // Кол-во сотрудников для решения задачи не требуется
        readln()

        // Возврат второй строки ввода
        return readln()
    }
}

private fun solution(input: String) {
    input.split(" ").forEachIndexed { index, manager ->
        employees[index + 1] = Employee(manager.toInt())
    }
}
private fun printAnswer(employees: MutableCollection<Employee>) {
    val answer = employees.joinToString(" ") { it.numberOfManagers.toString() }

    println(answer)
}

data class Employee(
    // Номер непосредственного руководителя
    val numberManager: Int
) {
    val numberOfManagers: Int by lazy {
        if (numberManager == 0) return@lazy 0
        val numbersOfManagerPerManager = employees[numberManager]?.numberOfManagers ?: 0
        return@lazy numbersOfManagerPerManager + 1
    }

}