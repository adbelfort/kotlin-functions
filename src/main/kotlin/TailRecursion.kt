import java.math.BigDecimal
import java.math.BigDecimal.ONE
import java.math.BigDecimal.ZERO

fun factorial(n: Int): Int =
    when (n) {
        0, 1 -> 1
        else -> n * factorial(n - 1)
    }

tailrec fun factorialTR(n: Int, accumulator: Int = 1): Int =
    when (n) {
        0, 1 -> accumulator
        else -> factorialTR(n - 1, n * accumulator)
    }

tailrec fun factorialTR(n: BigDecimal, accumulator: BigDecimal = ONE): BigDecimal =
    when (n) {
        ZERO, ONE -> accumulator
        else -> factorialTR(n - ONE, n * accumulator)
    }

fun main() {
//    println(factorial(5))                                 // 120
//    println(factorial(100000))                            // Stack overflow
    println(factorialTR(BigDecimal.valueOf(100000)))      // 2,82 x 10^(456573)
}