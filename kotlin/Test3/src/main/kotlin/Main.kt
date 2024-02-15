fun main(args: Array<String>) {
    //Массивы в Kotlin
    /*val a:Array<Int> = arrayOf(9, 15, 4)
    println("Длина массива=${a.size}")
    for(i in a){
        print("$i ")
    }
    a[0]=10
    println("")
    for(i in a){
        print("$i ")
    }*/

    /*val a:Array<Int> = Array(3){0}
    a[1]=2
    for(i in a)
        print("$i ")*/

    //BooleanArray, ByteArray, ShortArray, IntArray, LongArray, CharArray, FloatArray, DoubleArray
    //Для числовых типов также есть варианты беззнаковых массивов – UByteArray, UShortArray, UIntArray, ULongArray
    /*val a:BooleanArray = booleanArrayOf(true,false,true)
    for(i in a)
        print("$i ")*/

    /*val b:IntArray = intArrayOf(10,2,50,3)
    println(2 in b)
    println(2 !in b)
    println(50 !in b)*/

    /*val a: Array<IntArray> = Array(3) {IntArray(4) {0} }

    // количество строк
    val n = a.size
    // количество элементов в строке
    val m = a[0].size

    for (i in 0 until n) {
        for (j in 0 until m) {
            a[i][j] = (Math.random() * 10)
                .toInt()
            print(" ${a[i][j]}")
        }
        println()
    }*/

    val a: Array<IntArray> = Array(2) {IntArray(4) {0} }
    a[0] = intArrayOf(1, 2, 3, 4)
    a[1] = intArrayOf(5, 6, 7, 8)

    for (i in a) {
        for (j in i) {
            print(" $j")
        }
        println()
    }

}