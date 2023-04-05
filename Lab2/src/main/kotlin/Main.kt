data class Car(val Speed:Float, val Distance:Float){
    var Time:Float = 0.0f
        get() {
            return this.Distance/this.Speed
        }
        private set(value:Float) {
            field = value
        }

}

sealed class Shape{
    class Rectangle(var a:Double, var b:Double):Shape()
    class Oval(var rad1: Double, var rad2:Double):Shape()
    class Line(var length:Double):Shape()
}


fun main(){
    val car:Car = Car(20f, 300f)
    println(car.Time)
    val car2 = Car(12f, 150f)
    val car3 = Car(50f, 2000f)
    val car4 = Car(60.5f, 300f)
    var listOfCars = arrayListOf<Car>(car, car2, car3, car4)
    var wholeTime:Float = 0f
    for(element in listOfCars){
        println(element.Time)
        wholeTime += element.Time
    }
    println("The sum of times is $wholeTime")
    var rectangle = Shape.Rectangle(20.0,40.0)
    var oval = Shape.Oval(30.2, 54.4)
    var line = Shape.Line(12.5)
    var rectangle1 = Shape.Rectangle(20.0,40.0)
    var rectangle2 = Shape.Rectangle(20.0,40.0)
    var listOfShapes = arrayListOf<Shape>(rectangle, oval, line, rectangle1, rectangle2)
    var sumofRectangles = 0
    var sumofOvals = 0
    var sumofLines = 0
    for (element in listOfShapes){
        when(element){
            is Shape.Rectangle -> sumofRectangles++
            is Shape.Oval -> sumofOvals++
            is Shape.Line -> sumofLines++
        }
    }
    println("Amount of rectangles: $sumofRectangles, amount of ovals $sumofOvals, amount of lines $sumofLines")
    sumofRectangles = 0
    sumofOvals = 0
    sumofLines = 0
    val rectangles = listOfShapes.filter { it is Shape.Rectangle }
    sumofRectangles = rectangles.size
    val ovals = listOfShapes.filter { it is Shape.Oval }
    sumofOvals = ovals.size
    val lines = listOfShapes.filter { it is Shape.Line }
    sumofLines = lines.size
    println("Amount of rectangles: $sumofRectangles, amount of ovals $sumofOvals, amount of lines $sumofLines")
}