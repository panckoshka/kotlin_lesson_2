package justNow

val SECOND = 1
val MINUTE = SECOND * 60
val HOUR = MINUTE * 60
val DAY = HOUR * 24


fun main() {
    println("Нужно узнать сколько времени отсутствует пользователь онлайн.")
    println("час = 3_600, сутки = 86_400")
    println()
    print("Введе число (в секндах и не должно быть отрицательным): ")
    val text = readln().toInt()
    val result = agoToText(text)
    print(result)
}

fun agoToText(text: Int): String {
    return when {
        text >= SECOND && text <= MINUTE -> "был(а) только что"

        text > MINUTE && text <= HOUR -> {
            val min: Int = text / MINUTE
            "$min минут(а) назад"
        }
        text > HOUR && text <= DAY -> {
            val hour: Int = text / HOUR
            "$hour час(а,ов) назад"
        }
        text > DAY && text < DAY * 2 -> "сегодня"
        text > DAY * 2 && text < DAY * 3 -> "вчера"
        text > DAY * 3 -> "давно"

        else -> throw Exception("Ошибка ввода")
//        in 0..60 -> print("был(а) только что")
    }
}
