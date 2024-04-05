fun main(args: Array<String>) {
    //Циклы в Kotlin
    /*print("Введите что-нибуть")
    var a=readln()
    while(a==""){
        println("Введите что-нибуть")
        a=readln()
    }
    println("Вы ввели: $a")*/


    /*var a:String
    do{
        println("Введите что-нибуть")
        a=readln()
    }while(a=="")
    println("Вы ввели: $a")*/


    /*for (i in 0..10){
        print(" $i") // 0 1 2 3 4 5 6 7 8 9 10
    }*/

    /*val a= mutableListOf(3,5,7,9)
    for(i in 0 until a.size){
        a[i]+=2
    }
    println(a)//[5, 7, 9, 11]
    for(i in a.indices){
        a[i]+=2
    }
    println(a)//[7, 9, 11, 13]
    for ((i,item) in a.withIndex()){
        a[i]=item+2
    }
    println(a)//[9, 11, 13, 15]*/

    /*val c= listOf(1,3,5)
    c.forEach{println(it)}*/

    val a = listOf(1,3,5)
    repeat(3){
        print(" $it")
    }
}