fun main() {
    println(" Практическая работа ")
    println("1. Задание 1")
    println("2. Задание 2")
    println("3. Задание 3")
    println("4. Задание 4")
    println("5. Задание 5")
    println("6. Задание 6")
    println("0. Выход")
    print("Выберите задание: ")

    when (readLine()) {
        "1" -> task1()
        "2" -> task2()
        "3" -> task3()
        "4" -> task4()
        "5" -> task5()
        "6" -> task6()
        "0" -> println("Программа завершена.")
        else -> println("Ошибка: выберите 0 до 6.")
    }
}

// Задание 1
fun task1() {
    println("Задание 1. Введите строку:")
    val input = readLine()

    if (input.isNullOrEmpty()) {
        println("Ошибка: строка не должна быть пустой.")
        return
    }

    val result = StringBuilder()
    var currentChar = input[0]
    var count = 1

    for (i in 1 until input.length) {
        if (input[i] == currentChar) {
            count++
        } else {
            result.append(currentChar)
            if (count > 1) result.append(count)

            currentChar = input[i]
            count = 1
        }
    }

    result.append(currentChar)
    if (count > 1) result.append(count)

    println("Результат: $result")
}

// Задание 2
fun task2() {
    println("Задание 2. Введите строку:")
    val input = readLine()

    if (input.isNullOrEmpty()) {
        println("Ошибка: строка не должна быть пустой.")
        return
    }

    val symbols = sortedMapOf<Char, Int>()

    for (char in input) {
        symbols[char] = symbols.getOrDefault(char, 0) + 1
    }

    println("Количество символов:")
    for ((char, count) in symbols) {
        println("$char - $count")
    }
}

fun task3() {
    println("Задание 3. Перевод в двоичную систему")
    print("Введите натуральное число: ")

    val input = readLine()

    if (input.isNullOrBlank()) {
        println("Ошибка: вы ничего не ввели.")
        return
    }

    val number = input.toLongOrNull()

    if (number == null) {
        println("Ошибка: необходимо ввести целое число.")
        return
    }

    if (number <= 0) {
        println("Ошибка: число должно быть натуральным (больше нуля).")
        return
    }

    val binary = number.toString(2)

    println("Число $number в двоичной системе: $binary")
}
fun task4() {
    println("Задание 4. Калькулятор")
    println("Введите два числа и операцию через пробел.")
    println("Формат: ЧИСЛО1 ЧИСЛО2 ОПЕРАЦИЯ")
    println("Пример: 10 5 +")
    print("> ")

    val input = readLine()

    if (input.isNullOrBlank()) {
        println("Ошибка: ввод не должен быть пустым.")
        return
    }

    val parts = input.trim().split(Regex("\\s+"))

    if (parts.size != 3) {
        println("Ошибка: необходимо ввести ровно два числа и один знак операции.")
        return
    }

    val number1 = parts[0].toDoubleOrNull()
    val number2 = parts[1].toDoubleOrNull()
    val operation = parts[2]

    if (number1 == null || number2 == null) {
        println("Ошибка: первые два значения должны быть числами.")
        return
    }

    if (operation.length != 1 || operation !in listOf("+", "-", "*", "/")) {
        println("Ошибка: допустимые операции: +, -, *, /.")
        return
    }

    if (operation == "/" && number2 == 0.0) {
        println("Ошибка: делить на ноль нельзя.")
        return
    }

    val result = when (operation) {
        "+" -> number1 + number2
        "-" -> number1 - number2
        "*" -> number1 * number2
        "/" -> number1 / number2
        else -> return
    }

    if (!result.isFinite()) {
        println("Ошибка: результат слишком велик или не может быть представлен числом.")
        return
    }

    println("Результат: $result")
}

fun task5() {
    println("Задание 5. Поиск целочисленного показателя степени")
    println("Введите целое число n:")
    val nInput = readLine()

    val n = nInput?.trim()?.toLongOrNull()

    if (n == null) {
        println("Ошибка: n должно быть целым числом.")
        return
    }

    println("Введите целое основание степени x:")
    val xInput = readLine()


    val x = xInput?.trim()?.toLongOrNull()

    if (x == null) {
        println("Ошибка: x должно быть целым числом.")
        return
    }

    if (x == 0L || x == 1L || x == -1L) {
        when {
            x == 0L && n == 0L ->
                println("Показатель существует: любое положительное целое y подходит.")

            x == 0L ->
                println("Целочисленный показатель не существует.")

            x == 1L && n == 1L ->
                println("Показатель существует: любое целое y подходит.")

            x == -1L && (n == 1L || n == -1L) ->
                println("Показатель существует: например, y = ${if (n == 1L) 0 else 1}.")

            else ->
                println("Целочисленный показатель не существует.")
        }
        return
    }

    var found = false
    var power = 1L
    var y = 0

    while (y <= 63) {
        if (power == n) {
            println("Показатель существует: y = $y")
            found = true
            break
        }

        if (power > Long.MAX_VALUE / x && x > 1L) break
        if (power < Long.MIN_VALUE / x && x < -1L) break

        val next = power * x

        if (x < -1L && next / x != power) break
        if (x > 1L && next / x != power) break

        power = next
        y++
    }

    if (!found) {
        println("Целочисленный показатель не существует.")
    }
}

fun task6() {
    println("Задание 6. Создание нечётного числа")
    println("Введите первую цифру (0–9):")

    val firstInput = readLine()
    val first = firstInput?.trim()?.toIntOrNull()

    if (first == null || first !in 0..9) {
        println("Ошибка: необходимо ввести одну цифру от 0 до 9.")
        return
    }

    println("Введите вторую цифру (0–9):")

    val secondInput = readLine()
    val second = secondInput?.trim()?.toIntOrNull()

    if (second == null || second !in 0..9) {
        println("Ошибка: необходимо ввести одну цифру от 0 до 9.")
        return
    }

    if (first == second) {
        println("Ошибка: цифры должны быть различными.")
        return
    }

    // Последняя цифра нечётного числа должна быть нечётной.
    if (first % 2 == 1) {
        println("Полученное нечётное число: ${first}${second}")
    } else if (second % 2 == 1 && second != 0) {
        println("Полученное нечётное число: ${second}${first}")
    } else {
        println("Создать нечетное число невозможно.")
    }
}