package differentCommission

fun main() {
//    print("Введите название карты(MasterCard, Maestro, Мир, Visa, VK Pay): ")
//    val nameCard = readln()
//    print("Ведите сумму перевода(минимальный платеж 100 коп): ")
//    val payment = readln().toInt()

//    val nameCard = "Мир"
//    val payment = 76_000
//    val monthPayments = 500
//
//    val commissionMasterCard = calcCommission(nameCard, payment, monthPayments)
//    val commission = calcCommission(nameCard, payment = payment)
//    val commissionVkPay = calcCommission(payment = payment)
//
//    print("Комиссия составит $commissionVkPay коп.")
//    print("Комиссия составит $commission коп.")

    println(
        "Кейс 1. Перевод с маэтро 200 руб. Получили комиссию: " +
                "${calcCommission("Maestro", 200)} коп," +
                " ожидаем: 0 коп."
    )
    println(
        "Кейс 2. Перевод с Маэстро 200 руб, мы уже перевели 1000 за месяц. Получили комиссию: " +
                "${calcCommission("Maestro", 200, 1000)} коп, ожидаем: 0 коп."
    )
    println(
        "Кейс 3. Перевод с Маэстро 200 руб, мы уже перевели 80000 за месяц. Получили комиссию: " +
                "${calcCommission("Maestro", 200, 80000)} коп, ожидаем: 21 руб."
    )

    println(
        "Кейс 4. Перевод с Мир 200 руб. Получили комиссию: " +
                "${calcCommission("Мир", 200)} коп, ожидаем: 35 руб."
    )
    println(
        "Кейс 5. Перевод с Мир 10000 руб. Получили комиссию: " +
                "${calcCommission("Мир", 10_000)} коп, ожидаем: 75 руб."
    )

    println(
        "Кейс 6. Перевод с Vk Pay 200 руб. Получили комиссию: " +
                "${calcCommission(payment = 200)} коп, ожидаем: 0 коп."
    )
    try {
        println(
            "Кейс 7. Перевод с Vk Pay 100_000 руб. Получили комиссию: " +
                    "${calcCommission(payment = 100_000)} коп, ожидаем исключение."
        )

    } catch (e: Exception) {
        println("Получили исключение.")
    }

    try {
        println(
            "Кейс 8. Перевод с Маэстро 151_000 руб, мы уже перевели 601_000 за месяц. Получили комиссию: " +
                    "${calcCommission("Maestro", 151_000, 601_000)} коп," +
                    " ожидаем: ожидаем исключение"
        )

    } catch (e: Exception) {
        println("Получили исключение. Привышены лимиты.")
    }
    try {
        println(
            "Кейс 9. Перевод с Мир 151_000 руб, мы уже перевели 601_000 за месяц. Получили комиссию: " +
                    "${calcCommission("Maestro", 151_000, 601_000)} коп," +
                    " ожидаем: ожидаем исключение"
        )

    } catch (e: Exception) {
        println("Получили исключение. Привышены лимиты.")
    }
}

fun commissionMasterCardMaestro(payment: Int, monthPayments: Int): Int {
    val commissio = ((payment.toDouble() * 0.006 + 20) * 100).toInt()
    val transferAmount = payment + monthPayments
    if (transferAmount > 76_000) {
        return commissio
    }
    return 0
}

fun commissioMirVisa(payment: Int, monthPayments: Int): Int {
    val commissio = ((payment.toDouble() * 0.0075) * 100).toInt()
    if (commissio > 3500) {
        return commissio
    }
    return 3500
}

fun calcCommission(nameCard: String = "VK Pay", payment: Int, monthPayments: Int = 0): Int {

    return when {
        nameCard == "Visa" || nameCard == "Мир" && payment < 150_000 && monthPayments < 600_000 ->
            commissioMirVisa(payment, monthPayments)
        nameCard == "MasterCard" || nameCard == "Maestro" && payment < 150_000 && monthPayments < 600_000 ->
            commissionMasterCardMaestro(payment, monthPayments)
        nameCard == "VK Pay" && payment < 15_000 && monthPayments < 40_000 -> 0

        else -> throw Exception("Что-то пошло не так")
    }
}
