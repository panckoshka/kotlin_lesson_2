package differentCommission

fun main() {
    print("Введите название карты(MasterCard, Maestro, Мир, Visa, VK Pay): ")
    val nameCard = readln()
    print("Ведите сумму перевода(в рублях): ")
    val payment = readln().toInt()
    val commission = commission(nameCard, payment)
    print("Комиссия составит $commission руб.")
}

fun commissionMasterCardMaestro(payment: Int): Int {
    return (payment.toDouble() * 0.006 + 20).toInt()
}

fun commissioMirVisa(payment: Int): Int {
    return (payment.toDouble() * 0.0075).toInt()
}

fun commission(nameCard: String, payment: Int): Int {
    return when {
        nameCard == "Мир" && commissioMirVisa(payment) > 35 ->
            commissioMirVisa(payment)
        nameCard == "Мир" && commissioMirVisa(payment) > 35 -> 35

        nameCard == "Visa" && commissioMirVisa(payment) > 35 ->
            commissioMirVisa(payment)
        nameCard == "Visa" && commissioMirVisa(payment) > 35 -> 35

        nameCard == "VK Pay" -> 0

        else -> commissionMasterCardMaestro(payment)
    }
}
