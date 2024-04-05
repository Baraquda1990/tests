/*fun main(args: Array<String>) {
    //Функции в Kotlin
    /*val a=5
    val b=4
    println(avr(a,b))*/

    /*val a = 3
    val b = 5
    val c = abNumber(a, b)
    println(c)*/


    /*val a = hello()
    println(a) // kotlin.Unit*/


    repeatStr("Hi", 3) // HiHiHi
    println()
    repeatStr("Hello") // HelloHello
}*/

/*fun avr(n1:Int,n2:Int):Float{
    return (n1+n2).toFloat()/2
}*/

//fun avr(n1:Int,n2:Int):Float=(n1+n2).toFloat()/2

/*fun abNumber(n1: Int, n2: Int) =
    if (n1 > n2) {
        n1 / n2
    }
    else {
        n2 / n1
    }*/

/*fun hello() {
    println("hi") // hi
}*/

/*fun repeatStr(s: String, n: Int = 2) {
    for(i in 1..n)
        print(s)
}*/

/*fun main() {
    repeatStr(3, "Hi") // HiHiHi
    println()
    repeatStr(s = "Hello") // HelloHello
}

fun repeatStr(n: Int = 2, s: String) {
    for(i in 1..n)
        print(s)
}*/

/*fun main() {
    repeatStr(s = "Hi", n = 3) // HiHiHi
    println()
    repeatStr(n = 2, s = "Hello") // HelloHello
}

fun repeatStr(s: String, n: Int) {
    for(i in 1..n)
        print(s)
}*/


/*fun main() {
    println(avr(0, 1, 8)) // 3.0
    println(avr(-5, 1)) // -2.0
}

fun avr(vararg nums: Int): Float {
    val sum = nums.sum()
    val l = nums.size
    return sum.toFloat() / l
}*/

fun main() {
    val a: IntArray = intArrayOf(0, 1, 8)
    println(avr(*a)) // 3.0
}

fun avr(vararg nums: Int): Float {
    val sum = nums.sum()
    val l = nums.size
    return sum.toFloat() / l
}