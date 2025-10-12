// 1. Getting Started
// Define a function and call it
fun printHello() {
    println("Hello Kotlin World!")
}
printHello()
println()

// 2. Operators and Types

// Practice basic numeric operators and infix notation
println("Operators:")
println(10 + 5)
println(10.5 / 2.0)
println(4.times(5)) // Infix function 'times'
println(15.0.plus(2.5)) // Infix function 'plus'
println()

// Practice type conversion
val myInt: Int = 100
val myByte: Byte = myInt.toByte() // Convert Int to Byte
println("Int: $myInt, Converted to Byte: $myByte")

val myDouble: Double = myByte.toDouble() // Convert Byte to Double
println("Converted to Double: $myDouble")

// Practice large number literals (using underscores)
val largeNumber = 1_234_567
println("Large number literal: $largeNumber")
println()

// 3. Strings and Characters

// Use string templates for variable insertion
val apples = 8
val oranges = 3
println("I have $apples apples and $oranges oranges.")

// Use expression in string template
println("Total fruit: ${apples + oranges}")
println()

// 4. Compare Conditions and Booleans

// Simple if/else
val temperature = 25
if (temperature > 30) {
    println("It's a hot day!")
} else {
    println("The weather is pleasant.")
}

// if/else if/else
val score = 85
if (score == 100) {
    println("Perfect score!")
} else if (score >= 80) {
    println("Great job!")
} else {
    println("Keep practicing.")
}

// when expression
val day = "Sunday"
when (day) {
    "Saturday", "Sunday" -> println("It's the weekend!")
    else -> println("It's a weekday.")
}

// Range check
val x = 15
if (x in 10..20) {
    println("$x is between 10 and 20.")
}
println()

// 5. Learn about Nullability

// Declare a nullable variable
var itemPrice: Double? = 50.0

// Use the safe call operator (?.)
itemPrice = itemPrice?.dec() // Decrease by 1, or remains null if itemPrice was null
println("Updated price: $itemPrice")

// Use the Elvis operator (?:) for a non-null default value
var discount: Int? = null
val finalDiscount = discount ?: 10 // Uses 10 as the default if discount is null
println("Final discount is: $finalDiscount")
println()

// 6. Explore Arrays, Lists, and Loops

// Create a mutable list and modify it
val shoppingList = mutableListOf("milk", "bread")
shoppingList.add("cheese")
shoppingList.remove("milk")
println("Shopping List: ${shoppingList.joinToString()}")

// Create an array and use java.util.Arrays.toString() to print
val rainbowColors = arrayOf("Red", "Orange", "Yellow", "Green", "Blue", "Violet")
println("Rainbow Array: ${java.util.Arrays.toString(rainbowColors)}")

// Use a for loop with indices
for ((index, color) in rainbowColors.withIndex()) {
    println("Color at index $index is $color")
}
println()

// Use a while loop
var countdown = 3
while (countdown > 0) {
    println("T-minus $countdown...")
    countdown--
}

// Use a downTo loop
for (i in 5 downTo 1 step 1) {
    print("$i ")
}
println("\n")

// Use the repeat function
repeat(2) {
    println("Practicing loops!")
}