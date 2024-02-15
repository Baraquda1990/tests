import kotlin.random.Random
fun main(args: Array<String>) {
    //Коллекции в Kotlin - списки, словари и множества
    /*val a:List<Int>
    val b:Map<String,Int>
    val c:Set<Byte>*/

    val a= listOf(1,2,3,4)//[1, 2, 3, 4]
    val b= mapOf("green" to 5,"black" to 13)//{green=5, black=13}
    val c= setOf(1,3,5,7,9)//[1, 3, 5, 7, 9]
    val d=List(10){0}//[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
    val e=List(10){Random.nextInt(100)}//[1, 92, 55, 49, 8, 47, 26, 48, 99, 48]
    val f=List(10){it*2+1}//[1, 3, 5, 7, 9, 11, 13, 15, 17, 19]
    println(a)
    println(b)
    println(c)
    println(d)
    println(e)
    println(f)


    val g = MutableList(10){0}
    g[0] = 109

    val h = mutableListOf<Int>()
    h.add(40)

    val j = mutableMapOf('a' to 10, 'b' to 5)
    j['c'] = 12

    for ((key, value) in j)
        println("$key = $value")


    val i = ArrayList<String>()
    i.add("Hello")
    i.add("World")

    val o = setOf("hi", "oh")
    val p = ArrayList(o)

}