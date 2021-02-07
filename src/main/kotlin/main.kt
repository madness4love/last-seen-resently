import kotlin.math.abs

val secondsInMinutes = 60
val minutesInHour = 60
val hoursInDay = 24

fun main() {
    val absentTime : Int = 60
    var text :String

    text = when {
        absentTime <= secondsInMinutes ->
            "Был(а) в сети только что"
        absentTime > secondsInMinutes && absentTime < secondsInMinutes * minutesInHour ->
            agoMinutesToText(absentTime)
        absentTime > minutesInHour && absentTime < secondsInMinutes * minutesInHour * hoursInDay ->
            agoHoursToText(absentTime)
        else ->
            agoDaysToText(absentTime)
    }

    println(text)

}

fun secondsToMinutes(absentTime : Int) : Int  {
    return abs(absentTime / secondsInMinutes)
}

fun minutesToHour(absentTime : Int) : Int {
    return abs(secondsToMinutes(absentTime) / minutesInHour)
}

fun hoursToDays(absentTime : Int) : Int {
    return abs(minutesToHour(absentTime) / hoursInDay)
}

fun agoMinutesToText(absentTime : Int) : String {
    val time : Int = secondsToMinutes(absentTime)
    val n = time % 100
    val n1 = time % 10

    return when {
        (n >= 10 && n <= 20) || n1 >= 5 -> "Был(а) в сети $time минут назад"
        n1 > 1 && n1 < 5 -> "Был(а) в сети $time минуты назад"
        else -> "Был(а) в сети $time минуту назад"
    }
}

fun agoHoursToText(absentTime : Int) : String {
    val time = minutesToHour(absentTime)
    val n = time % 100
    val n1 = time % 10

    return when {
        (n >= 10 && n <= 20) || n1 >= 5 -> "Был(а) в сети $time часов назад"
        n1 >= 2 && n1 <= 4 -> "Был(а) в сети $time часа назад"
        else -> "Был(а) в сети $time час назад"
    }
}

fun agoDaysToText(absentTime : Int) : String {
    val time = hoursToDays(absentTime)

    return when {
        time == 1 -> "Был(а) в сети сегодня"
        time == 2 -> "Был(а) в сети вчера"
        else -> "Был(а) в сети давно"
    }
}
