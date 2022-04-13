package justNow

val SECOND: UInt = 1u
val MINUTE: UInt = SECOND * 60u
val HOUR = MINUTE * 60u
val DAY = HOUR * 24u


fun main() {
//    println("Нужно узнать сколько времени отсутствует пользователь онлайн.")
//    println("час = 3_600, сутки = 86_400")
//    println()
//    print("Введе число (в секндах и не должно быть отрицательным): ")
//    val time = readln().toUInt()
//    val result = agoToText(time)
//    print(result)
    println("Кейс 1. Пользовватель отсутствует ${agoToText(time = 1u)}. Ожидаем: \"был(а) только что\"")
    println("Кейс 2. Пользовватель отсутствует ${agoToText(time = 60u)}. Ожидаем: \"1 минуту назад\"")
    println("Кейс 3. Пользовватель отсутствует ${agoToText(time = 120u)}. Ожидаем: \"2 минуты назад\"")
    println("Кейс 4. Пользовватель отсутствует ${agoToText(time = 240u)}. Ожидаем: \"4 минуты назад\"")
    println("Кейс 5_1. Пользовватель отсутствует ${agoToText(time = 660u)}. Ожидаем: \"11 минут назад\"")
    println("Кейс 5_2. Пользовватель отсутствует ${agoToText(time = 720u)}. Ожидаем: \"12 минут назад\"")
    println("Кейс 5_3. Пользовватель отсутствует ${agoToText(time = 780u)}. Ожидаем: \"13 минут назад\"")
    println("Кейс 5_4. Пользовватель отсутствует ${agoToText(time = 840u)}. Ожидаем: \"14 минут назад\"")
    println("Кейс 6. Пользовватель отсутствует ${agoToText(time = 3_600u)}. Ожидаем: \"1 чac назад\"")
    println("Кейс 7. Пользовватель отсутствует ${agoToText(time = 7_200u)}. Ожидаем: \"2 часа назад\"")
    println("Кейс 8. Пользовватель отсутствует ${agoToText(time = 18_000u)}. Ожидаем: \"5 часов назад\"")
    println()
    println("Кейс 5_5. Пользовватель отсутствует ${agoToText(time = 39_660u)}. Ожидаем: \"11 часов назад\"")
    println("Кейс 5_6. Пользовватель отсутствует ${agoToText(time = 43_200u)}. Ожидаем: \"12 часов назад\"")
    println("Кейс 5_7. Пользовватель отсутствует ${agoToText(time = 46_800u)}. Ожидаем: \"13 часов назад\"")
    println("Кейс 5_8. Пользовватель отсутствует ${agoToText(time = 50_400u)}. Ожидаем: \"14 часов назад\"")
    println("Кейс 9. Пользовватель отсутствует ${agoToText(time = 86_400u)}. Ожидаем: \"сегодня\"")
    println("Кейс 9. Пользовватель отсутствует ${agoToText(time = 172_800u)}. Ожидаем: \"вчера\"")
    println("Кейс 9. Пользовватель отсутствует ${agoToText(time = 259_200u)}. Ожидаем: \"давно\"")
}

fun minRemainder(time: UInt): String {
    val min: UInt = time / MINUTE
    if (min >= 11u && min <= 14u) {
        return "$min минут назад"
    }
    val remainder: UInt = min % 10u
    return when {
        remainder == 1u -> "$min минуту назад."
        remainder <= 4u -> "$min минуты назад."
        else -> "$min минут назад"
    }
}

fun hourRemainder(time: UInt): String {
    val hour: UInt = time / HOUR
    if (hour >= 11u && hour <= 14u) {
        return "$hour часов назад"
    }
    val remainder: UInt = hour % 10u
    return when {
        remainder == 1u -> "$hour чac назад."
        remainder <= 4u -> "$hour часа назад."
        else -> "$hour часов назад"
    }
}

fun agoToText(time: UInt): String {
    return when {
        time < MINUTE -> "был(а) только что"

        time < HOUR -> minRemainder(time)
        time < DAY -> hourRemainder(time)

        time < DAY * 2u -> "сегодня"
        time < DAY * 3u -> "вчера"
        time >= DAY * 3u -> "давно"

        else -> throw Exception("Ошибка ввода")
//        in 0..60 -> print("был(а) только что")
    }
}