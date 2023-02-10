
/**
 * This is the InheritanceApply class where are create a CalculationThird class's object and inherit the all classes methods.
 *
 * @author (Sitaram Thing)
 * @version (19.1.3 & 2022/11/07)
 */
public class InheritanceApply
{    
    //create an main methods and call the all of methods by Calculation, CalculationSecond & CalculationThird classes
    public static void main(String[] args){
        // create an object of InheritanceApply class the call the Calculation class's methods...
        CalculationThird classThird = new CalculationThird();
        classThird.add(10,20);
        classThird.substract(100,50);
        classThird.multiply(10,2);

        // Display the factorial values by call the factorial methods
        System.out.println("The factorial is: "+classThird.factorial(5));
        
        classThird.Fibonacci(); //call the factorial methods
    }
}
