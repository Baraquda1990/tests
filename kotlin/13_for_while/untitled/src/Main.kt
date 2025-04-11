//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    fun fun1(){
        val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
        for(fruit in fruitArray){
            //Начало цикла
            println("Fruit: $fruit")
            // Конец цикла если цикл уже запустился
            // столько раз сколько элементов в массиве
            // если нет то запускается снова взяв
            // следующий элемент из массива
        }
        // fruit это один элемент массива который нам выдает цикл
        // цикл достает по очереди элементы из массива
        // и записывает их в переменную fruit

        // in проверяет берет элемент из массива и присваивает его переменной fruit
        // fruitArray это массив который содержит название фруктов
    }
    fun fun2() {
        val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
        println("Range: ${fruitArray.indices}")
    }
    fun fun3(){
        val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
        for(index in fruitArray.indices){
            //Начало цикла
            println("Fruit: ${fruitArray[index]} | Fruit position: $index")
            // Конец цикла если цикл уже запустился
            // столько раз сколько элементов в массиве
            // если нет то запускается снова взяв
            // следующий элемент из массива
        }
        // index позиция которую нам выдает цикл
        // цикл запускает столько раз сколько элементов в массиве
        // меняя каждый раз index на новую позицию
        // используя index берем с этой позиции
        // из массива fruitArray, элемент по его позиции
    }
    fun fun4(){
        val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
        for((index, fruit) in fruitArray.withIndex()) {
            println("Fruit: $fruit | Index: $index ")
        }
    }
    fun fun5(){
        for(index in 0..10){
            println("Index: $index")
        }
    }
    fun fun6(){
        for(index in 10 downTo 3){
            println("Index: $index ")
        }
    }
    fun fun8(){
        for(letter in 'Z' downTo 'A'){
            println( "Index: $letter ")
        }
    }
    fun fun9(){
    val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
    for(index in 1..fruitArray.size){
        println( "Fruit: ${fruitArray[index]} ")
    }
    }
    fun fun10(){
        val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
        for(index in 1..fruitArray.size - 1){
            println(  "Fruit: ${fruitArray[index]} ")
        }
    }
    fun fun11(){
        val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
        for(index in 1 until fruitArray.size){
            println( "Fruit: ${fruitArray[index]} ")
        }
    }
    fun fun12(){
        val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
        for(fruit in fruitArray){
            if(fruit == "Апельсин") break
            println( "Fruit: $fruit")
        }
    }
    fun fun13(){
        val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
        for(fruit in fruitArray){
            if(fruit == "Апельсин") continue
            println(  "Fruit: $fruit")
        }
    }
    fun fun14(){
        val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
        fruitArray.forEach {
            println(  "Fruit: $it")
        }
    }
    fun fun15(){
        val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
        var index = 0
        while (index < fruitArray.size){
            println( "Fruit: ${fruitArray[index]}")
            index++
        }
    }
    fun fun16(){
        val fruitArray = listOf("Яблоко", "Апельсин", "Груша")
        var index = 0
        do {
            println( "Fruit: ${fruitArray[index]}")
            index++
        } while (index < fruitArray.size)
    }
    fun16()
}