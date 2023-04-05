abstract class Worker(_FirstName: String, _LastName: String, _Age: Int) {
    protected var FirstName : String
    protected var LastName : String
    protected var Age : Int

    init {
        FirstName = _FirstName
        LastName = _LastName
        Age = _Age
    }
    abstract fun showInfo()
}

class Programmer(_FirstName:String, _LastName:String, _Age:Int, _ProgrammingLanguage:String):Worker(_FirstName, _LastName, _Age),Salaryable{
    private var ProgLanguage : String
    override var Salary: Double = 0.0
    override fun showSalary() {
        println("The salary of $FirstName $LastName is $Salary")
    }
    init {
        ProgLanguage = _ProgrammingLanguage
    }
    constructor(FirstName:String, LastName:String):this(FirstName, LastName, 0, "Undefined"){

    }
    override fun showInfo(){
        println("The name is $FirstName $LastName, the age is $Age, his favorite programming language is $ProgLanguage")
    }
}

class Carpenter(Fn:String, Ln:String, age:Int, furniture:ArrayList<String>):Worker(Fn, Ln, age), Salaryable{
    private var Furniture:ArrayList<String>
    override var Salary: Double = 0.0
    init {
        Furniture = furniture
    }
    override fun showSalary() {
        println("The salary of $FirstName $LastName is $Salary")
    }

    override fun showInfo() {
        println("The name is $FirstName $LastName, the age is $Age")
        for (element in Furniture){
            println("The furniture he makes is $element")
        }
    }
}

interface Salaryable{
    var Salary:Double
    fun SalarySet(sal:Double){
        Salary = sal
    }
    fun showSalary()

}


fun main(){
    val Anton = Programmer("Anton", "Valmer", 32, "C++")
    Anton.showInfo()
    val Jake = Programmer("Jake", "Fooler")
    Jake.showInfo()
    Anton.SalarySet(22000.0)
    Anton.showSalary()
    val Mike = Carpenter("Mike", "Rhodes", 32, arrayListOf("Table", "Chair", "Cupboard"))
    Mike.showInfo()

}