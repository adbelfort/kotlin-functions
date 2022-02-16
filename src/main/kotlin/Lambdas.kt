val sum: (Int, Int) -> Int = { a, b -> a + b }
val multiply = { a: Int, b: Int -> a * b }

typealias Operation = (Int, Int) -> Int

val divide: Operation = { a, b -> a / b }

fun compute(a: Int, b: Int, op: Operation) = op(a, b)

fun main() {
    val x = 9
    val y = 3

    println("Sum: ${sum(x, y)}")            // 12
    println("Multiply: ${multiply(x, y)}")  // 27
    println("Divide: ${divide(x, y)}")      // 3

    val result = compute(x, y) { a, b ->
        a * a + b * b
    }

    println("Sum of squares: $result")      // 90

    val doubledNumbers = listOf(1, 2, 3).map { it * 2 }

    println("Doubled numbers: $doubledNumbers")
}