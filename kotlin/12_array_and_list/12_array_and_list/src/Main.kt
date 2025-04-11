//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    fun ar1(){
    //Объявление массива
    var array: Array<Int> = arrayOf(5, 6, 9)

    var array2: IntArray = intArrayOf(5, 6, 9)

    var array3 = intArrayOf(5, 6, 9)

    //Нулевой массив
    var array4 = IntArray(3)

    var array5 = intArrayOf(0, 0, 0)

    var array6 = arrayOf(0, 0, 0)

    //Создали массив внутри 3 ячейки со значением 0
    var array1 = intArrayOf(0, 0, 0)
    //Создали новый массив внутри 5 ячеек с разными значениями
    //прежний массив сотрется и все данные будут потеряны
    array1 = intArrayOf(6, 67, 567, 89, 76)

    //Создаем массив с 3-мя нолями
    val array8 = intArrayOf(0, 0, 0)
    //Записываем на позицию 0 новое значение 43
    array8[0] = 43
    //Теперь в нашем массиве такие значения: (43, 0, 0)

    //Создаем массив с 3-мя нолями
    val array9 = intArrayOf(56, 6, 12)
    //Считываем значение с позиции 1 и записываем
    //в переменную testNumber
    val testNumber = array[1]
    //Теперь в нашей переменной testNumber будет записано значение 6
    //так как на позиции 1 у нас в массиве число 6
    //помните что в массиве позиции начинаются с 0

    //Создаем массив с 3-мя начениями null
    val arrayNull = arrayOfNulls<Int>(3)
    //таким образом у нас будет массив из 3 ячеек
    //в каждой из которых значение null
    //таким образом (null, null, null)

    //Создаем пустой массив
    var arrayEmpty = emptyArray<String>()
    //размер массива равен 0
    //когда наам это будет нужно можем перезаписать
    //данный массив на новый не пустой массив
    arrayEmpty = arrayOf("яблоко", "груша", "апельсин")
    //Теперь на месте старого массива у нас новый массив
    //и он уже не пустой так как содержит 3 элемента
}
    fun ar2() {
        //Создаем массив с 5-ю ячейками
        val array = arrayOf(3, 7, 8, 9, 0)
        val arraySize = array.size
        //Записываем размер массива 5 в переменную arraySize

        //Создаем массив с 5-ю ячейками: (3, 7, 8, 9, 0)
        val arrayOrigin = arrayOf(3, 7, 8, 9, 0)
        //Переворачиваем массив записываем перевернутый
        //массив в новую переменную reversedArray и теперь
        //значения в новом массиве будут на оборот при этом
        //старый массив arrayOrigin остается нетронутым
        val reversedArray = arrayOrigin.reversedArray()
        //Теперь значения в новом массиве выглядят так: (0, 9, 8, 7, 3)

        //Создаем массив с 5-ю ячейками: (3, 7, 8, 9, 0)
        val arrayOrigin2 = arrayOf(3, 7, 8, 9, 0)
        //Сортируем оригинальный массив
        arrayOrigin2.sort()
        //Теперь у нас в массиве элементы будут в таком порядке (0, 3, 7, 8, 9)

        //Создаем массив с 7-ю ячейками: (9, 3, 5, 1, 0, 67, 11)
        val arrayOrigin3 = arrayOf(9, 3, 5, 1, 0, 67, 11)
        //Сортируем оригинальный массив
        arrayOrigin3.sort(0, 3)
        //В таком случе сортируем только первые 3 числа
        //так как мы сортируем от позиции 0 включительно
        //до позиции 3 не включительно
        //Теперь у нас в массиве элементы будут в таком порядке (3, 5, 9, 1, 0, 67, 11)

        //Сортируем оригинальный массив от большего к меньшему
        arrayOrigin3.sortDescending()
        //Результат будет такой (67, 11, 9, 5, 3, 1, 0)

        //Сортируем оригинал создавая новый отсортированный массив
        val sortedArray = arrayOrigin3.sortedArray()//От меньшего к большему
        val sortedDescendingArray = arrayOrigin3.sortedArrayDescending()//От большего к меньшему

        //Проверяем содержит наш массив число 5 или нет.
        //Если содержит то на запишет true в containElement
        //если нет то запишет false
        val containElement = arrayOrigin3.contains(5)

        //Проверяем наибольшее число в массиве.
        val maxNumber = arrayOrigin3.maxOrNull()
        //Проверяем наименьшее число в массиве.
        val minNumber = arrayOrigin3.minOrNull()

        //Сумма всех элементов в массиве
        val sum = arrayOrigin3.sum()

        //Находим среднее значение в массиве
        val average = arrayOrigin3.average()

        //Создаем ервый массив с 7-ю ячейками: (9, 3, 5, 1, 0, 67, 11)
        val arrayOrigin11 = arrayOf(9, 3, 5, 1, 0, 67, 11)
        //Создаем второй массив с 7-ю ячейками: (9, 3, 5, 1, 0, 67, 11)
        val arrayOrigin22 = arrayOf(1, 34, 7, 45, 56, 675, 3)
        //Находим общие элементы, в данном случае это 3 и 1 и создаем новый массив
        //в который записываем общие значения для двух массивов
        //Нам выдает класс Set по этому мы превращаем результат
        //с помощью toIntArray() в массив с типом данных Int
        val resultArray = arrayOrigin11.intersect(arrayOrigin22.toList()).toIntArray()

        //Перемешиваем массив в случайном порядке
        arrayOrigin3.shuffle()
    }
    fun ar3(){
        //Создаем первый массив с 5-ю ячейками: (4, 17, 85, 8, 451)
        val arrayOrigin = listOf(4, 17, 85, 8, 45)
        //Создаем второй массив с 5-ю ячейками: (4, 10, 85, 8, 4)
        val arrayOrigin2 = listOf(4, 10, 85, 8, 4)

        val sortedList = arrayOrigin.sorted()
        val sumList = arrayOrigin.sum()
        val reversedList = arrayOrigin.reversed()
        val containsList = arrayOrigin.contains(5)
        val minList = arrayOrigin.minOrNull()
        val maxList = arrayOrigin.maxOrNull()
        val averageList = arrayOrigin.average()
        val shuffledList = arrayOrigin.shuffled()
        val sortedDescendingList = arrayOrigin.sortedDescending()
        val intersection = arrayOrigin.intersect(arrayOrigin2.toList())

        //Создаем список с 5-ю ячейками: (4, 17, 85, 8, 451)
        val list1 = listOf(4, 17, 85, 8, 45)
        //Создаем список явно указав тип данных с 5-ю ячейками: (4, 17, 85, 8, 451)
        val list2:List<Int> = listOf(4, 17, 85, 8, 45)
        //Создаем список явно указав тип данных с 5-ю ячейками: (4, 17, 85, 8, 451)
        val list3 = listOf<Int>(4, 17, 85, 8, 45)

        //Создаем список с 5-ю ячейками: (4, 17, 85, 8, 451)
        val list4 = arrayListOf(4, 17, 85, 8, 45)
        //Создаем список явно указав тип данных с 5-ю ячейками: (4, 17, 85, 8, 451)
        val list5:ArrayList<Int> = arrayListOf(4, 17, 85, 8, 45)
        //Создаем список явно указав тип данных с 5-ю ячейками: (4, 17, 85, 8, 451)
        val list6 = arrayListOf<Int>(4, 17, 85, 8, 45)
    }
    fun ar4(){
        //Создаем список ArrayList с 5-ю ячейками: (4, 17, 85, 8, 451)
        val list = arrayListOf(4, 17, 85, 8, 45)
//Считываем значение с позиции 2
        val number = list[2]
//Перезаписываем значение на позиции 2
        list[2] = 56
//Добавляем еще один элемент в список это число 23
//значения которые добавляем должны быть
// того же типа что и остальные, в данном случае Int
        list.add(23)
//Удаляем элемент на позиции 2 теперь нет этой ячейки,
// ее место займет ячейка та что была впереди все равно что стопка книг,
//убрали одну нигу из середины,
//верхние книги займут ее место, тут тоже самое
        list.removeAt(2)
//Удаляем все элементы в списке
        list.clear()
//Добавляем не по одному элементу а целый список,
//если уже есть элементы в списке то новый список их дополнит не удаляя
        list.addAll(listOf(35, 78, 89))
//сли так непонятно то можно тоже самое сделать вот так
        val newList = listOf(35, 78, 89)
        list.addAll(newList)
//Мы добавили в ArrayList список List
//К уже добваленному списку можно добавить еще один список
//тогда у нас будет один большой список
//чтобы было понятней мы возмем и добавим в наш
//список не список а массив , в таком случае выйдет ошибка,
        val arrayTest = intArrayOf(34, 67, 89, 89)
        //list.addAll(arrayTest)
//Мы можем воспользоваться методом у массива для превращения
//массива в список вот тогда наш список сможет принять наш массив
        val arrayTest2 = intArrayOf(34, 67, 89, 89)
        list.addAll(arrayTest2.toList())
//Другой вариант просто не указывать что это за массив написав
//просто arrayOf тогда непридется превращать его в List
        val arrayTest3 = arrayOf(34, 67, 89, 89)
        list.addAll(arrayTest3)

        println(arrayTest2)
        println(arrayTest2.joinToString(","))
    }
    ar4()
}