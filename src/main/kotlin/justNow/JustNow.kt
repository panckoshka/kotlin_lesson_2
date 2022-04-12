package justNow

val SECOND: UInt = 1u
val MINUTE: UInt = SECOND * 60u
val HOUR = MINUTE * 60u
val DAY = HOUR * 24u


fun main() {
    println("Нужно узнать сколько времени отсутствует пользователь онлайн.")
    println("час = 3_600, сутки = 86_400")
    println()
    print("Введе число (в секндах и не должно быть отрицательным): ")
    val time = readln().toUInt()
    val result = agoToText(time)
    print(result)
}

fun agoToText(time: UInt): String {
    return when {
        time < MINUTE -> "был(а) только что"

        time < HOUR -> {
            val min: UInt = time / MINUTE
            "$min минут(а) назад"
        }
        time < DAY -> {
            val hour: UInt = time / HOUR
            "$hour час(а,ов) назад"
        }
        time < DAY * 2u -> "сегодня"
        time < DAY * 3u -> "вчера"
        time > DAY * 3u -> "давно"

        else -> throw Exception("Ошибка ввода")
//        in 0..60 -> print("был(а) только что")
    }
}
