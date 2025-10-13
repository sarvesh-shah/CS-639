import kotlin.math.PI 
import java.util.Random


// base class 'open' so other classes can inherit from it
open class Shape(open var sides: Int = 4, open var base: Int = 10, open var height: Int = 5) {
    
    // Primary constructor has default values
    init {
        println("\nShape initializing (Primary Constructor)")
    }
    
    // Secondary constructor
    constructor(area: Int) : this() {
        // Calculate the height based on a desired area
        height = area / base
        println("Secondary constructor used. New height: $height")
    }

    // Custom Getter Property
    open val area: Int
        get() = base * height
        
    // Custom Setter Property 
    open var calculatedArea: Int
        get() = area
        set(value) {
            height = value / base
        }

    fun printDimensions() {
        println("Shape: $sides sides, Base: $base, Height: $height")
        println("Area: $area (or $calculatedArea using the property)")
    }
}

// Inherit from the open base class
class Square(override var base: Int) : Shape(sides = 4, base = base, height = base) {
    // Override the volume property
    override val area: Int
        get() = base * base
}


// Abstract class
abstract class Furniture {
    abstract val material: String
    fun clean() = println("Wiping down the $material furniture.")
}

// Interface 
interface Movable {
    fun move()
}

// Delegation Interface
interface ItemColor {
    val color: String
}

// Singleton Object for Delegation 
object Brown : ItemColor {
    override val color = "brown"
}

// Another Delegation Interface
class MovingAction : Movable {
    override fun move() = println("Moving item carefully.")
}

// Class using Abstract class and Interface Delegation
class Table(
    override val material: String,
    // Delegate the Movable behavior to an instance of MovingAction
    movable: Movable = MovingAction()
) : Furniture(), Movable by movable, ItemColor by Brown {
    
    override fun move() {
        println("Moving the heavy table!") // Override the delegated behavior for fun
    }
    
    // Implement the abstract property from Furniture
    override fun describeStyle() {
        println("This $color table is made of $material.")
    }

    // Required by Furniture 
    fun describeStyle() {
        println("This $color table is made of $material.")
    }
}



// Data class
data class DecorItem(val name: String, val weight: Double, val fragile: Boolean = true)

// Extension function 
fun String.isLong(): Boolean {
    return this.length > 10
}

// Extension property 
val Int.isEven: Boolean
    get() = this % 2 == 0

// Test function for all the practice
fun testAllConcepts() {
    println("\n--- Testing Classes and Inheritance ---")
    val rect = Shape(base = 15, height = 8)
    rect.printDimensions()
    rect.calculatedArea = 300 // Use the setter
    rect.printDimensions() // Height should be recalculated

    val sq = Square(base = 12)
    sq.printDimensions() // Uses the overridden 'area' getter
    
    println("\n--- Testing Delegation, Abstract Class, and Interface ---")
    val myTable = Table(material = "Oak")
    myTable.describeStyle()
    myTable.move() // Calls the overridden move function
    myTable.clean()
    
    println("\n--- Testing Data Class Features ---")
    val lamp = DecorItem("Desk Lamp", 3.5)
    val vase = DecorItem("Ceramic Vase", 1.2)
    val lampCopy = lamp.copy(weight = 4.0)
    
    println("Original Lamp: $lamp")
    println("Lamp Copy: $lampCopy")
    println("Lamp == Vase? ${lamp == vase}") // false, checking contents
    
    // Destructuring 
    val (itemName, _, isFragile) = vase 
    println("Destructured: Item is $itemName, Fragile: $isFragile")
    
    println("\n--- Testing Extensions, Pairs, and Collections ---")
    // Test Extension Function
    val testString = "short"
    println("'$testString' is long? ${testString.isLong()}") // false
    
    // Test Extension Property
    println("14 is even? ${14.isEven}") // true
    
    // Test Pairs and Triples 
    val coordinates = Triple(10, 20, 30)
    val (_, y, _) = coordinates // Destructure with underscore to skip
    println("Y coordinate is: $y")
    
    // Test HashMap
    val priceMap = hashMapOf("coffee" to 3.00, "tea" to 2.50)
    println("Price of coffee: ${priceMap["coffee"]}")
    println("Price of juice (default): ${priceMap.getOrDefault("juice", 4.00)}")
}


main() { testAllConcepts() }