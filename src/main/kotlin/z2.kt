fun main() {
    print("Введите сумму перевода: ")
    val sum = readLine()!!.toInt()
    print("Введите сумму предыдущих переводов: ")
    val sumP = readLine()!!.toInt()
    print("Введите тип карты/счета: ")
    val card = readLine()!!.toString()

    fun r(card: String): String {
        val total = sumP + sum

        return when {
            card in listOf("mastercard", "maestro") && total > 600000 ->
                "Вы превысили лимит"

            card in listOf("mastercard", "maestro") ->
                "Комиссия: ${sum * 0.006 + 20} руб."

            card in listOf("visa", "mir") && total > 600000 ->
                "Вы превысили лимит"

            card in listOf("visa", "mir") ->
                "Комиссия: ${sum * 0.0075} руб."

            card == "vk pay" ->
                "Комиссия: 0 руб."

            else -> "Нет"
        }
    }

    println(r(card))
}