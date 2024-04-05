/*fun main(args: Array<String>) {
//Класс данных – data class
}*/

/*class Book(val title: String,
           val author: String,
           val year: Int)
fun main() {
    val a = Book("ABC", "Tom", 2015)
    val b = Book("River", "Sam", 2007)
}*/

/*data class Book(val title: String,
                val author: String,
                val year: Int)*/

/*data class Book(val title: String,
                val author: String,
                val year: Int) {

    override fun toString(): String {
        return "$title, $author, $year"
    }
}*/

/*override fun toString(): String {
    return super.toString()
}*/

/*fun main() {
    val a = Book("ABC", "Tom", 2015)
    val c = Book("ABC", "Tom", 2015)
    val b = Book("River", "Sam", 2007)
    println(a == c) // true
    println(a == b) // false
}*/

/*fun main() {
    val a = Book("ABC", "Tom", 2015)
    val b = a.copy()
    val c = a.copy(title="River", year=2007)
    println(a)
    println(b)
    println(c)
}*/

/*Book(title=ABC, author=Tom, year=2015)
Book(title=ABC, author=Tom, year=2015)
Book(title=River, author=Tom, year=2007)*/

/*fun main() {
    val book1 = Book("ABC", "Tom", 2015)
    val (a, b, c) = book1 // мультидекларация!
    println(a) // ABC
    println(b) // Tom
    println(c) // 2015
}*/

/*class Book(val title: String,
           val author: String,
           val year: Int) {
    operator fun component1() = title
    operator fun component2() = author
    operator fun component3() = year
}*/

/*fun main() {
    val books = ArrayList<Book>()
    books.add(Book("ABC", "Tom", 2015))
    books.add(Book("What", "Tom", 2016))
    books.add(Book("River", "Sam", 2007))

    for ((t, a, y) in books) {
        println("$y, $t")
    }
}*/

/*data class Book(val title: String,
                val author: String,
                val year: Int) {
    val pages: Int = 0
}*/

/*fun main() {
    val t = Triple(1, "First", "Один")
    val t2 = t.copy(third = "Первый")
}*/

//Классы перечислений - enum

/*enum class Fruits {
    BANANA, APPLE, ORANGE, KIWI
}
fun main() {
    val orange: Fruits = Fruits.ORANGE
    println(orange) // ORANGE
    println(orange.name) // ORANGE
    println(orange.ordinal) // 2
}
 */

/*enum class Fruits {
    BANANA(10, 0.9), APPLE(12, 1.1),
    ORANGE(5, 1.5), KIWI(15, 1.8);

    var qty: Int
    var price: Double

    constructor(q: Int, p: Double) {
        qty = q
        price = p
    }
}
fun main() {
    println(Fruits.ORANGE.qty) // 5
}*/

/*enum class Fruits(
    var qty: Int,
    var price: Double) {

    BANANA(10, 0.9),
    APPLE(12, 1.1),
    ORANGE(5, 1.5),
    KIWI(15, 1.8);
}*/

/*enum class Fruits(
    var qty: Int,
    var price: Double) {

    BANANA(10, 0.9),
    APPLE(12, 1.1),
    ORANGE(5, 1.5),
    KIWI(15, 1.8);

    fun sell(n: Int) {qty -= n}

    fun changePrice(newPrice: Double) {
        price = newPrice
    }
}
fun main() {
    val o = Fruits.ORANGE
    println("${o.qty}, ${o.price}") // 5, 1.5
    o.sell(3)
    o.changePrice(1.3)
    println("${o.qty}, ${o.price}") // 2, 1.3
} */

/*fun main() {
    for (i in Fruits.values())
        i.changePrice(0.2)
}
import Fruits.*

fun main() {
    println(ORANGE.qty)
}

 */
