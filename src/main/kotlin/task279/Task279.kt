package task279

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
    // Количество команд мне неинтересно
    readln()

    val numberAthletes = readln().split(" ").map { it.toInt() }
    val numberRooms = readln().toInt()
    val rooms = List(numberRooms) {
        val (capacity, number) = readln().split(" ").map { it.toInt() }
        Room(capacity, number)
    }
    return Input(numberAthletes, rooms)
}

private fun solution(input: Input): String {
    input.apply {
        if (numberAthletes.size > rooms.sumOf { it.number }) return "No"
        val sortAthletes = numberAthletes.sortedDescending()
        sortAthletes.forEach { team ->
            val suitableRoom = rooms.filter {
                it.capacity >= team && it.number != 0
            }.minByOrNull { it.capacity } ?: return "No"
            suitableRoom.number -= 1
        }
    }
    return "Yes"
}

private fun getAnswer(answer: String): String {
    return answer
}

data class Input(val numberAthletes: List<Int>, val rooms: List<Room>)
data class Room(
    val capacity: Int,
    var number: Int
)