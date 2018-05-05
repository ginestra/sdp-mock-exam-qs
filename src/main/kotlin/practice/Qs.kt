package practice

// q1
fun manyTimesString(s: String, i: Int): String {
  tailrec fun loop(stringSoFar: String, i: Int): String {
    return if (i == 0) stringSoFar else loop(stringSoFar + s, i - 1)
  }
  return loop (s, i - 1)
}

// q2
data class SimpleTime(val hours: Int, val minutes: Int)
val t = SimpleTime(hours=5, minutes=30)

// q3
data class Item(val name: String, val price: Double) {
  fun cost(
    grocery: Boolean = false,
    medication: Boolean = false,
    taxRate: Double = 0.10): Double {
      return if (grocery || medication) price else price * (1 + taxRate)
    }
}

// q4
class ClothesWasher(val modelName: String = "ACME", val capacity: Double = 1.0) {
  constructor (modelName: String) : this(modelName, 1.0)
  constructor (capacity: Double) : this("ACME", capacity)
  override fun toString():String = "$modelName + $capacity"
}

// q5
data class Person(
  val firstName: String, val lastName: String, val email: String)

// q6
val q6func = { temperature: Int, low: Int, high: Int ->
  temperature >= low && temperature <= high }

// q7
fun sumIt(vararg elems: Int): Int =
  elems.reduce{acc, elem -> acc + elem}

// q8
val q8Answer = """
  |The pattern is Adapter - the Complex object's from* methods
  |allow a client using a different coordinate system, to
  |interact with Complex numbers, and the Complex companion
  |object does the job of conversion on behalf of the client.
  |It's not facade as it doesn't simplify the API required from
  |the client.
""".trimMargin()

val q9Answer = """
  Working in kotlin, I would just change the 'class' keyword to 'object.'
  Working in Java, I would a) make the constructor private, b) provide
  a static method getInstance(), c) create a static private field to
  d) hold the singleton instance of the class, e) decide whether to
  eagerly or lazily initialize. If eager, use an init {} block in the
  class, so when the class is initialized, the static private field will
  be populated by constructing an instance. If lazy, place null in the
  field, and construct the object the first time a client calls
  getInstance
  """.trimIndent()

val q10Answer = """
  The Visitor pattern can assign more functionality to elements
  without subclassing them.
  """.trimIndent()

// q10 example
object Q10 {
  interface Visitor {
    fun visit(v: Visitee): Int
  }

  class Visitee(serialNumber: Int) {
    public val serialNumber: Int = serialNumber
    fun double(): Int = serialNumber * 2
    fun accept(v: Visitor) = v.visit(this)
  }

  class TripleVisitor : Visitor {
    override fun visit(v: Visitee): Int = v.serialNumber * 3
  }
}
