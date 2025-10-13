import java.util.Random


// The main() function
fun main() {
    println("--- My Lesson 2 Practice ---")
    
    // Check out if-as-an-expression
    val isRaining = true
    val plan = if (isRaining) "Stay inside and code" else "Go for a walk"
    println("Today's plan: $plan") 
    
    // Function practice
    lunchRoutine() 
    
    // Default and Compact Function practice
    orderCoffee() 
    orderCoffee(size = "large", type = "Latte")
    
    // Filters and Sequences (Lazy vs. Eager)
    doMyFilters()
    
    // Lambdas and Higher-Order Functions
    testHof()
    
    println("--- Practice Complete ---")
}

// Function to pick a random day, need the Random import above
fun randomDay() : String {
    val week = arrayOf ("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
    return week[Random().nextInt(week.size)]
}

// Using 'when' as a compact expression, which means it MUST cover all cases (or use else)
fun getLunchFood (day : String) : String {
    return when (day) {
        "Mon" -> "Salad"
        "Tue" -> "Taco"
        "Wed" -> "Pasta"
        "Thu" -> "Soup"
        "Fri" -> "Pizza"
        "Sat", "Sun" -> "Big Brunch!" 
        else -> "Leftovers" 
    }
}

fun lunchRoutine() {
    val today = randomDay()
    val food = getLunchFood(today)
    println("\nMy Lunch Routine:")
    println("Today is $today and I'm having $food.")
}


// Compact function
fun isSizeLarge(size: String) = size == "large"

// Function with default parameter values
fun orderCoffee(size: String = "medium", type: String = "Black Coffee", shots: Int = 2) {
    println("\nOrdering Coffee:")
    println("A $size $type with $shots shots, please.")
    
    // Using the compact function
    if (isSizeLarge(size)) {
        println("That's a big cup!")
    }
}


fun doMyFilters() {
    val books = listOf("Kotlin in Action", "The Lord of the Rings", "A Study in Scarlet", "Clean Code", "Design Patterns")
    
    // Eager filtering 
    val shortTitles = books.filter { it.length < 20 }
    println("\nEager Filter (Short Titles): $shortTitles")

    // Flattening a List of Lists
    val myFavoriteColors = listOf(listOf("Blue", "Green"), listOf("Red", "Yellow"))
    println("Flattened Colors: ${myFavoriteColors.flatten()}")

    // Lazy filtering (using sequences)
    val lazyTitles = books.asSequence().filter { it[0] == 'C' }
    println("Lazy sequence object: $lazyTitles") // Notice it prints an object reference, not the results
    
    // Force the lazy sequence to evaluate
    val cTitles = lazyTitles.toList()
    println("Lazy Result (after toList): $cTitles")
}


// A Lambda function (takes an Int, returns an Int)
val scoreAdjuster: (Int) -> Int = { currentScore -> 
    currentScore + 10 // Gives a 10 point bonus
}

// A Higher-Order Function (takes an Int and a function)
fun calculateFinalScore(initialScore: Int, operation: (Int) -> Int): Int {
    return operation(initialScore)
}

// A standard function to be used as a function reference
fun doubleScore(start: Int) = start * 2

fun testHof() {
    var myScore = 75
    
    // Using the lambda defined above
    myScore = calculateFinalScore(myScore, scoreAdjuster)
    println("\nLambda/H.O.F Practice:")
    println("Score after 10-point bonus: $myScore") // 85

    // Using a function reference (::)
    val doubledScore = calculateFinalScore(20, ::doubleScore)
    println("Score after doubling: $doubledScore") // 40
    
    // Using a Trailing Lambda directly
    var projectScore = 50
    projectScore = calculateFinalScore(projectScore) { score -> 
        score + 50 + (score / 2) // Huge bonus!
    }
    println("Project score after trailing lambda: $projectScore") // 50 + 50 + 25 = 125
}

// Run the main function to execute the script!
main()