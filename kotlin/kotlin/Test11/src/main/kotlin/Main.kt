//Введение в дженерики – обобщенные классы и функции

/*fun main() {
    val a: Int = 10
    val b: Double = 1.5
    fraction(a) // 2.0
    fraction(b) // 0.3
}
fun fraction(n: Number) {
    println(n.toDouble() / 5)
}*/

/*fun main() {
    val a: Int = 10
    val b: String = "Hello"
    val c: List<Int> = listOf(1, 5)

    val aa: List<Int> = doTwo(a)
    val bb: List<String> = doTwo(b)
    val cc: List<List<Int>> = doTwo(c)

    println(aa) // [10, 10]
    println(bb) // [Hello, Hello]
    println(cc) // [[1, 5], [1, 5]]
}
fun <T> doTwo(obj: T): List<T> {
    val list: List<T> = listOf(obj, obj)
    return list
}*/

/*fun main() {
    val a: Int = 10
    val b: String = "Hello"
    val c: List<Int> = listOf(10, 16, 3)
    parePrint(a, '{') // {10}
    parePrint(b, '[') // [Hello]
    parePrint(c, '"') // "[10, 16, 3]"
}
fun <T> parePrint(obj: T, p: Char) {
    when(p) {
        '(', ')' -> println("($obj)")
        '[', ']' -> println("[$obj]")
        '{', '}' -> println("{$obj}")
        else -> println("$p$obj$p")
    }
}*/

/*fun main() {
    val a: Int = 10
    val b: Double = 1.5
    println(fraction(a, 5)) // 2.0
    println(fraction(b, 3)) // 0.5
}
fun <T: Number> fraction(n: T, f: Int): Double {
    return n.toDouble() / f
}*/

/*class Something<T> {
    val prop: T

    constructor(p: T) {
        prop = p
    }
}
fun main() {
    val a: Something<Int> = Something(10)
    val b: Something<String> = Something("Hello")
    println(a.prop) // 10
    println(b.prop) // Hello
}*/

/*class Something<T>(p: T) {
    val prop: T = p
}
class Something<T>(val prop: T)
 */

/*fun main() {
    val a: List<Int> = listOf(4, 5)
    val b: Map<Char, Int> =
        mapOf('a' to 2, 'b' to 10)
}
class Something<T, V>(p: T, q: V) {
    val prop: T = p
    val qty: V = q
}
fun main() {
    val a: Something<String, Int>
    a = Something("Hello", 5)
}

 */

//Лямбда-выражения в Kotlin

/*fun main() {
    {println(1)}()
}

 */

/*fun main() {
    {n: Int -> println(n)}(10)
}

 */

/*fun main() {

    // выведет: 10
    val a = {n: Int -> println(n)}(10)

    // выведет: kotlin.Unit
    println(a)
} */

/*fun main() {
    val a = {n: Int, m: Int ->
        println(n + m)
        n + m
    }(10, 20)

    println(a)
}*/

/*fun main() {
    val a = {n: Int, m: Int -> n + m}
    val b = a(10, 20)
    val c = a(30, 40)

    println(a)
    println(b)
    println(c)
}*/

//Функции высшего порядка

/*fun main() {
    val firstList = listOf(1, 4, 10)
    val mult2: (Int) -> Int = {it * 2}
    val add2: (Int) -> Int = {it + 2}

    val multList = mathWithList(firstList, mult2)
    val addList = mathWithList(firstList, add2)

    println(multList)  // [2, 8, 20]
    println(addList)   // [3, 6, 12]
}

fun mathWithList(yourList: List<Int>, math: (Int) -> Int): List<Int> {
    val newList = mutableListOf<Int>()
    for (i in yourList) {
        newList.add(math(i))
    }
    return newList
}*/

fun main() {
    val firstList = listOf(1, 4, 10)

    val multList = firstList.mathWithList {it * 2}
    val addList = firstList.mathWithList {it + 2}

    println(multList)
    println(addList)
}

fun List<Int>.mathWithList(math: (Int) -> Int): List<Int> {
    val newList = mutableListOf<Int>()
    for (i in this) {
        newList.add(math(i))
    }
    return newList
}