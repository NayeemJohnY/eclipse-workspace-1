
* package name format : com.odm.pages.acccounts
* class/interface name format : AccountsPage, DashBoardPage, Employee
* method naming format : getAccountInfo(), Should not use : test_page_select()
* variables format : name, isActive, isFound, temp variables : temp, i, j, rowCount
* Constants format : public static final int MIN_WIDTH = 4, String AMZ_LOG = "Amazon", REQUEST_ERROR = "BAD REQUEST"
* <https://www.oracle.com/java/technologies/javase/codeconventions-namingconventions.html> 







* System - cannot be instantiated, has static final variables - not able to create object (private constructor)
* out is of PrintStream class, out is null in system class, How it is initialized : setIn, setOut() will be called by JVM, when class is loaded; setOut0 - native method- JVM JNI (C \, System.C file



* Static blocks ->set of blocks will be executed once class is loaded before main method
* Run a program without creating an object ? yes using static method and blocks
* How to create Objects of Private constructor class? Add instanceOf or createobject static method to return Object of class
* Run a program without Main Method? Using static blocks in a class
* If we just access the static variable of class : The class will not be loaded until the object is created

JDK 8 - Optional , IsNullable(), iFpresent, isPresent

JDK 9 - jshell  -command line java programming; Factory methods for immutable collections:  List.Of(); 

JDK 10 - Loosly couped datatype : "var" -@runtime will determine at compile time; var keyword

JDK 11 - single source file launch

JDK 12 - new switch case : switch return the value to the variable and use lambda; var x= switch(x){case 1 -> "afdas"}

JDK 13 - multi line String support : use """{ multi line contents}"""

JDK 14 - Data class, record keyword, auto constructor, getters, setters : record Employee(String name, String value){}; instance of keyword  Object instance return the dataype : obj instanceOf String str-  str will give the string value; reference

JDK 15 - sealed classes, sealed keyword : sealed interface using permits classes



Static Code Analysis:
* Analyze the code
* No compilation
* Much Faster then UTs/STs
* Rules/ Best Practices
* Common code
* Quality Gates : code duplication, code smells,  TODO  locating, naming conventions, code complexity, add try-catch-finally, unused imports, method returns, if-else statements merging
* Code coverage
* Where should we fit this in CI/CD? Before building project - e.g: sonar cube or after ITs :sonar lint - plugin
 
