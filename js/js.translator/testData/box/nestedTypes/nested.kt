// IGNORE_BACKEND: JS_IR
// EXPECTED_REACHABLE_NODES: 1117
package foo

open class A(val x: Int) {
    class B : A(5)
}

fun box(): String {
    return if (A(7).x + A.B().x == 12) "OK" else "failed"
}

