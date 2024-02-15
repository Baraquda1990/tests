fun main(args: Array<String>) {

    //Переменные и базовые классы данных в Kotlin
    println("Hello World!")
    println("Program arguments: ${args.joinToString()}")

    var a:Int
    a=5
    println(a)

    a=a+10
    println(a)

    var aa:Int=8
    println(aa)

    var b=15
    println(b)

    b+=5
    println(b)

    val abc=3.4
    println(abc)

    val q=true
    val w=false
    var e:Boolean=q>w
    println(e)
    e=q<=w
    println(e)

    val s="Hello"
    val s2:String
    val c="W"
    val c2:Char=s[0]
    s2=s+c
    println(s2)
    println(c2)

    //print("Введите что-нибуть: ")
    //val inp:String=readln()
    //println(inp)

    //Операторы ?., ?: и !! языка Kotlin
    //print("Введите что-нибуть: ")
    //val inp2:String?=readlnOrNull()
    //if(inp2!=null) {
    //    println(inp2.length)
    //}
    //else{
    //    println(-1)
    //}

    /*val bb: String? = "World"
    val cc: String? = null
    val bL: Int? = bb?.length
    val cL: Int? = cc?.length
    println(bL)
    println(cL)

    val bbb: String? = readlnOrNull()
    val ccc: String = bbb ?: ""
    println(ccc.length)

    val bbbb: String = readlnOrNull() ?: ""
    println(bbbb.length)*/

    val b2: String? =
        if ((0..1).random() == 1)
            "World"
        else
            null
    val c3: Int = b2?.length ?: -1
    println(c3)

    val b5: String? = readlnOrNull()
    val c5: String = b5!!
    val d5: String = readlnOrNull()!!
    val e5: String? = readlnOrNull()
    println(c5)
    println(d5)
    println(e5!!.length)
}