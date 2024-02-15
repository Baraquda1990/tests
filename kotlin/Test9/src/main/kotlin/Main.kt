/*fun main(args: Array<String>) {
//Объектно-ориентированное программирование в Kotlin
}*/

/*fun main() {
    val obj1 = MyClass()
    val obj2 = MyClass(10, 5)
}

class MyClass(var a: Int = 0, var b: Int = 0)*/

/*class MyClass(aa: Int = 0, bb: Int = 0) {
    var a = aa
    var b = bb
}*/

/*class MyClass {
    var a: Int
    var b: Int

    constructor(aa: Int = 0, bb: Int = 0) {
        a = aa
        b = bb
    }
}*/

/*fun main() {
    val obj1 = MyClass()
    println(obj1.d) // true
    val obj2 = MyClass(10, 5)
    println(obj2.d) // false
}

class MyClass(aa: Int, bb: Int) {
    var a = aa
    var b = bb
    var d = false

    constructor(): this(0, 0) {
        d = true
    }
}*/

/*fun main() {
    val obj1 = MyClass()
    println(obj1.d) // true
    val obj2 = MyClass(0, 0)
    println(obj2.d) // true
}

class MyClass(aa: Int = 0, bb: Int = 0) {
    var a = aa
    var b = bb
    var d: Boolean
    init {
        if (aa == 0 && bb == 0)
            d = true
        else d = false
    }
}*/

/*class MyClass(aa: Int, bb: Int) {
    var a = aa
        get() {return field}
        set(value) {field = value}

    var b = bb
        get() {return field}
        set(value) {field = value}
}*/

/*fun main() {
    val obj1 = MyClass(12, 3)
    obj1.a = -5
    println(obj1.a) // 12
    // obj1.b = 9 Error
    println(obj1.b) // Ok 3
}

class MyClass(aa: Int, bb: Int) {
    var a = aa
        set(value) {
            if ((value) > 0)
                field = value
        }

    var b = bb
        private set
}*/

fun main() {
    val obj1 = MyClass(12, 3)
    obj1.member()
    obj1.extension()
}

class MyClass(val a: Int = 0, val b: Int = 0) {

    fun member() {
        println("member-function")
        println(a + b)
    }
}

fun MyClass.extension() {
    println("extension-function")
    println(a - b)
}