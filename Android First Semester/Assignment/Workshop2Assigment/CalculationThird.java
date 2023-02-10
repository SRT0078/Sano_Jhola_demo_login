
/**
 * This is the child class which is extends by CalculationSecond class. In this class have calculation the fibonacci series.
 *
 * @author (Sitaram Thing)
 * @version (19.1.3 & 2022/11/07)
 */
public class CalculationThird extends CalculationSecond
{
    //initialize the integer global variable
    int firstNum=0, secondNum=1, thirdNum=0;
    //create an motheds with parameter
    public void Fibo(int count)
    {
        //using if statement
        if(count>0)
        {
            thirdNum = firstNum + secondNum;
            firstNum = secondNum;
            secondNum = thirdNum;
            System.out.print(" "+thirdNum);
            Fibo(count-1);//call the recursion methods
        }
    }
    
    // crete an fibonacci method and call the fibo method
    public void Fibonacci()
    {
        // initialize the local variable then print the first and second number
        int count  = 10;
        System.out.print(firstNum+" "+secondNum);
        Fibo(count-2); //call the fibo method.
    }
}
