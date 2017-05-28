package iii_conventions

import util.TODO


data class Invokable(val times: Int = 0) {
    operator fun invoke() : Invokable {
        return this.copy(this.times + 1)
    }

    fun getNumberOfInvocations(): Int {
        return this.times
    }

}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change class Invokable to count the number of invocations (round brackets).
        Uncomment the commented code - it should return 4.
    """,
    references = { invokable: Invokable -> })

fun task31(invokable: Invokable): Int {
    return invokable()()()().getNumberOfInvocations()
}
