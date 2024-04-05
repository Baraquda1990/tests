fun main(args: Array<String>) {
    //Условные выражения в Kotlin. Операторы if и when
    /*val a = "String"
    if (a[3] == 'r') {
        println("Yes")
    }
    else {
        println(a[3]) // i
    }*/

    /*val a = "String"
    val b = if (a[3] == 'r') {
        println("Yes")
    }
    else {
        println(a[3]) // i
    }
    println(b) // kotlin.Unit*/

    /*val a = "String"
    val b = if (a[3] == 'r') {
        "Yes"
    }
    else {
        a[3].toString()
    }
    println(b) // i*/

    /*val a = "String"

    val b = if (a[3] == 'r')
        "Yes"
    else
        a[3].toString()

    println(b) // i*/

    /*val a = Math.random()
    val b = Math.random()

    val c = if (a > b) {
        println("a > b")
        a + 1
    }
    else {
        println("b > a")
        b + 1
    }

    println(c)*/

    /*val a = "String"

    when (a[2]) {
        'r' -> println("Yes")
        'i' -> println("Not 'r'")
    }*/

    /*val a = "String"

    val b = when (a[3]) {
        'r' -> "Yes"
        else -> "Not 'r'"
    }

    println(b)*/

    /*val a = (Math.random() * 3).toInt()

    println(a)

    val b = when(a) {
        0 -> "Zero"
        1 -> "One"
        else -> "Two"
    }

    println(b)*/

    /*val c = Numbers.ONE

    val d = when(c) {
        Numbers.ZERO -> 0
        Numbers.ONE -> 1
        Numbers.TWO -> 2
    }

    println(d)*/

    /*when (readln()) {
        "Hello" -> {
            println("Hello")
            println("World")
            println("!!!")
        }
        else -> {
            println("Hi")
            println("?")
        }
    }*/

    /*when ((Math.random() * 100).toInt()) {
        in 0..10, in 90..99 -> println("Bad")
        in 11..50, in 60..89 -> println("Good")
        in 51..59 -> println("Excellent")
    }*/

    /*val a = (Math.random() * 100).toInt()

    when {
        a < 10 || a > 90 -> println("Bad")
        a in 51..59 -> println("Excellent")
        else -> println("Good")
    }*/

}

enum class Numbers {
    ZERO, ONE, TWO
}