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
    println("Кейс 1. Пользовватель отсутствует ${agoToText(time = 1u)}сек. Ожидаем: \"был(а) только что\"")
    println("Кейс 2. Пользовватель отсутствует ${agoToText(time = 60u)}сек. Ожидаем: \"1 минуту назад\"")
    println("Кейс 3. Пользовватель отсутствует ${agoToText(time = 120u)}сек. Ожидаем: \"2 минуты назад\"")
    println("Кейс 4. Пользовватель отсутствует ${agoToText(time = 240u)}сек. Ожидаем: \"4 минуты назад\"")
    println("Кейс 5. Пользовватель отсутствует ${agoToText(time = 660u)}сек. Ожидаем: \"11 минут назад\"")
    println("Кейс 5. Пользовватель отсутствует ${agoToText(time = 720u)}сек. Ожидаем: \"12 минут назад\"")
    println("Кейс 6. Пользовватель отсутствует ${agoToText(time = 3_600u)}сек. Ожидаем: \"1 чac назад\"")
    println("Кейс 7. Пользовватель отсутствует ${agoToText(time = 7_200u)}сек. Ожидаем: \"2 час назад\"")
    println("Кейс 8. Пользовватель отсутствует ${agoToText(time = 18_000u)}сек. Ожидаем: \"5 часов назад\"")
    println("Кейс 9. Пользовватель отсутствует ${agoToText(time = 86_400u)}сек. Ожидаем: \"сегодня\"")
    println("Кейс 9. Пользовватель отсутствует ${agoToText(time = 172_800u)}сек. Ожидаем: \"вчера\"")
    println("Кейс 9. Пользовватель отсутствует ${agoToText(time = 259_200u)}сек. Ожидаем: \"давно\"")
}

fun minRemainder(time: UInt): String {
    val min: UInt = time / MINUTE
    val remainder: UInt = min % 10u
    if (remainder == 1u && remainder != 11u) {            // 1, 21, 31, 41, 51
        return "$min минуту назад."
    } else if (remainder <= 4u) {                        //2..4, 22..24, 32..34, 42..44, 52..54
        return "$min минуты назад."
    } else {
        return "$min минут назад"
    }
}

fun hourRemainder(time: UInt): String {
    val hour: UInt = time / HOUR
    val remainder: UInt = hour % 10u
    if (remainder == 1u && remainder != 11u) {      //1, 21
        return "$hour cac назад."
    } else if (remainder <= 4u) {                   //2..4, 22,23
        return "$hour часа назад."
    } else {
        return "$hour часов назад"
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