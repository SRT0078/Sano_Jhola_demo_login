
/**
 * Create an calculation calss. It is the parenet class of calculationSecond. In this class have three methods as add, substract & multiplicatio and it is 
 * also know as some of parameter then return type is void.
 *
 * @author (Sitaram Thing)
 * @version (19.1.3/2022/11/07)
 */
public class Calculation
{
    // create the methods which accept infinite integer parameter
    public void add(int ...num){
        int number = 0;
        for(int i: num){
            number = number + i;
        }
        // display the values
        System.out.println("The sum of number is: "+(number));
    }
    
    // create the methods which accept integer parameter
    public void substract(int firstNum, int secondNum){
        System.out.println("The substraction is: "+(firstNum-secondNum));
    }
    
    // create the methods which accept integer parameter
    public void multiply(int firstNum, int secondNum){
        System.out.println("The multiplication is: "+(firstNum*secondNum));
    }
}
