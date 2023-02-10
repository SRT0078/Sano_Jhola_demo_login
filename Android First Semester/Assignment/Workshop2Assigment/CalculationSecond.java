
/**
 * Write a description of class CalculationnSecond here.
 *
 * @author (Sitaram Thing)
 * @version (19.1.3/2022/11/07)
 */

public class CalculationSecond extends Calculation
{
    // create the return type methods which accept integer number
    public int factorial(int num){
        // initialize the integer variable
        int fact = 1;
        // using the for loop
        for(int i =1; i<=num; i++){
            fact *=i;        
        }
        // return the fact
        return fact;    
    }
}
