fun main(args: Array<String>) {
    //Диапазоны, или интервалы, и прогрессии в Kotlin
    val a =1..4
    val b=1 until 4
    for(i in a){
        print("$i ")
    }//1234
    println()
    for(i in b){
        print("$i ")
    }//123
    println()


    val s="String"
    val cs=if (s[3] !in 'k'..'z')
        "Yes"
    else
        s[3].toString()
    println(cs)


    val s2="String"
    val cs2=when(s2[3])
        {in 'k'..'z'->"Yes"
        else -> s2[3].toString()}
    println(cs2)


    val a3 = 1..3
    val b3 = 1
    println(b3 !in a3) // false


    val q=1..9 step 3
    val w=1 until 10 step 2
    val e=0 downTo -4
    val r='z' downTo 'a' step 5
    for(i in q) print("$i ")
    println()
    for(i in w) print("$i ")
    println()
    for(i in e) print("$i ")
    println()
    for(i in r) print("$i ")
    println()

    val z=1..3
    val x=1 until 3
    val v=3 downTo 1
    println(z.toList())
    println(x.toList())
    println(v.toList())
}