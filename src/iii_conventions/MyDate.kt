package iii_conventions

import kotlin.coroutines.experimental.EmptyCoroutineContext.plus

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : kotlin.Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        return (dayOfMonth - other.dayOfMonth) + (month - other.month) * 31 + (year - other.year) * 366;
    }

    operator fun plus(interval: TimeInterval): MyDate {
        return addTimeIntervals(interval, 1)
    }

    operator fun plus(interval: TimeIntervalMultiplier): MyDate {
        return addTimeIntervals(interval.interval, interval.times)
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other);

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR,
}

data class TimeIntervalMultiplier(val interval: TimeInterval, val times: Int) {

}

operator fun TimeInterval.times(num: Int): TimeIntervalMultiplier {
    return TimeIntervalMultiplier(this, num)
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>, Iterable<MyDate> {
    override fun iterator(): Iterator<MyDate> {
        var current = start;

        return object : Iterator<MyDate> {
            override fun hasNext(): Boolean {
                return current <= endInclusive
            }

            override fun next(): MyDate {
                val date = current
                current = current.nextDay()
                return date
            }

        }
    }

    override fun contains(value: MyDate): Boolean {
        return value > this.start && value <= this.endInclusive;
    }
}
