
/**
 * Write a description of class Week2Workshop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Week1Workshop
{
    /**
     * Write a description of class Number here.
     *
     * @author (your name)
     * @version (a version number or a date)
     */
    public void Number()
    {
        int num = 1;
        for(int i=1; i<=5; i++)
        {
            for(int j=1; j<=i; j++)
            {
                System.out.print(num);
                num++;
            }
            num = 1;
            System.out.println("\n");
        }
    }
    
    
    //import java.util.Scanner;
    public class Sum
    {
        Scanner sc = new Scanner(System.in);
        public void sumNumber()
        {
            System.out.println("Input the any number more then two digit: ");
            int num = sc.nextInt();
            int sumnumber = 0;
            while(num!=0)
            {
                int div = num%10;
                sumnumber = sumnumber + div;
                num = num/10; 
            }
            System.out.println("The sum number output is: "+sumnumber);
        }
        
        // public static void main(String[] args)
        // {
            // Sum sum = new Sum();
            // sum.sumNumber();
        // }
    }
    
    
    /**
     * Write a non return type static method which display the factorial number of given number which is taken  from parameter. 
     * call that method from main method
     */
    //import java.util.Scanner;
    
    public class Factroial 
    {
        Scanner sc = new Scanner(System.in);
        public void myFact(String sms)
        {
            int factorial = 1;
            System.out.println(sms);
            int num = sc.nextInt();
    
            for(int i = 1; i<=num; i++) 
            {
                factorial = factorial * i;
            }
            System.out.println("Factorial of the given number is: "+factorial);
        }
        
        // public static void main(String args[])
        // {
            // Factroial fact = new Factroial();
            // fact.myFact("Enter the number to which you need to find the factorial: ");
        // }
    }


}
