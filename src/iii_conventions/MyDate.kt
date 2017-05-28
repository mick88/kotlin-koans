package iii_conventions

import java.lang.Comparable

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : kotlin.Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return (dayOfMonth - other.dayOfMonth) + (month - other.month) * 31 + (year - other.year) * 366;
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = todoTask27()

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate)
