package task168

fun main() {
    // Для решения знать количество предметов нет необходимости
    // Поэтому просто читаем в пустоту первую строчку
    readln()
    printAnswer(solution())
}

private fun solution(): Int {
    // Для решения необходимы только граничные значения положительных (только минимальное значение)
    // и отрицательных чисел (обе границы)
    var minPositiveNumber: Int = Int.MAX_VALUE

    var minNegativeNumber: Int = Int.MAX_VALUE
    var maxNegativeNumber: Int = Int.MIN_VALUE


    // Также необходимо знать четное или нечетное количество отрицательных чисел
    // Если количество четное то число точно >=0
    // Ну и наоборот
    var isNegativeNumbersEven = true

    // От количества нулей зависит ранний ответ
    // если их больше одного, то не имеет смысла идти дальше
    // все равно я получу БП == 0
    var numberZero = 0

    readln().split(" ").forEach {
        it.toInt().let { number ->
            when {
                (number > 0) -> {
                    if (minPositiveNumber > number) minPositiveNumber = number
                }

                (number < 0) -> {
                    if (minNegativeNumber > number) minNegativeNumber = number
                    if (maxNegativeNumber < number) maxNegativeNumber = number
                    isNegativeNumbersEven = !isNegativeNumbersEven
                }

                else -> {
                    numberZero += 1
                    // Сразу же возвращаем ноль, если их стало больше 1
                    if (numberZero > 1) return 0
                }
            }
        }
    }

    // Суть выбора ответа:
    //
    // Если текущий БП положительный, также есть вещи и для наступления и для колдовства --> отдаем вещь для колдовства (0);
    // [0 1 2 3] или [0 1 -2 -3] --> отдаем в любом случае 0 (так сделаем БП положительным)
    //
    // Если текущий БП положительный, также есть вещи для наступления, но нет вещей для колдовства --> отдаем вещь для наступления с минимальным БП;
    // [3 4 -1 -5] --> отдаем 3 (иначе БП станет отрицательным)
    //
    // Если текущий БП положительный, но есть вещи только для обороны --> отдаем вещь для обороны с минимальным БП (дальше от 0);
    // [-1 -2 -3 -4] --> отдаем -4 (так приблизим БП к нулю)
    //
    // Если текущий БП отрицателен (не важно есть вещи для колдовства или нет) --> отдаем вещь для обороны с максимальным БП (ближе к 0).
    // [-1 -2 -3 -4 -5] --> отдаем -1 (так сделаем БП положительным и максимально большим)
    // [0 -1 -2 -3 -4 -5] --> отдаем любое отрицательное число (в моем случае для того, чтобы избавиться от проверки на ноль, отдаю -1)

    return if (isNegativeNumbersEven) {
        when {
            (numberZero == 1) -> 0
            (minPositiveNumber != Int.MAX_VALUE) -> minPositiveNumber
            else -> minNegativeNumber
        }
    } else maxNegativeNumber

}

private fun printAnswer(answer: Int) {
    println(answer)
}