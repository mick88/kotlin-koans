package iv_properties

import util.TODO
import util.doc34
import kotlin.reflect.KProperty

class Delegate(val initializer: () -> Int) {
    var value : Int? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
        if (value == null) {
            value = initializer()
        }
        return value!!
    }
}

class LazyPropertyUsingDelegates(val initializer: () -> Int) {
    val lazyValue: Int by Delegate(initializer)
}

fun todoTask34(): Lazy<Int> = TODO(
    """
        Task 34.
        Read about delegated properties and make the property lazy by using delegates.
    """,
    documentation = doc34()
)
