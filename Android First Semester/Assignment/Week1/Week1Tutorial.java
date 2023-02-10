
/**
 * Write a description of class AdWeek1 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.Scanner;
public class Week1Tutorial
{
    /**
     * 1) Program to print half pyramid a using numbers
        A
        B B
        C C C
        D D D D
        E E E E E
     */
    
    public void ABC()
    {
        char alpha = 'A';
        //int rows = 5;
        for(int i = 1; i<=5; i++)
        {
            for(int j=1; j<=i; j++)
            {
                System.out.print(alpha);
            }
            alpha++;
            System.out.println("\n");
        }
    }
    
    /** 
     * 2) Program to print full pyramid a using numbers
     * 
     *               *
     *             * * *
     *           * * * * *
     *         * * * * * * *
     *       * * * * * * * * *        
     */
    public void Star()
    {
        int row=5;
        for(int i=1; i<=row; i++)
        {
            for(int space=i; space<row; space++)
            {
                System.out.print("  ");
            }
            for(int j=1; j<=(i*2)-1; j++)
            {
                System.out.print(" *");
            }
            System.out.print("\n");
        }
    }
    
    /** 
     * 3) Write a non return type static method which display the factorial number of given number which is taken  from parameter. 
     * call that method from another class.
     */
    
    //import java.util.Scanner;
    
    Scanner sc = new Scanner(System.in);
    public void fact()
    {
        int factorial = 1;
        System.out.println("Enter the number to which you need to find the factorial: ");
        int num = sc.nextInt();
        
        for(int i = 1; i<=num; i++) 
        {
            factorial = factorial * i;
        }
        System.out.println("Factorial of the given number is: "+factorial);
    }
    public static void main(String args[])
    {
        Week1Tutorial fac = new Week1Tutorial();
        fac.fact();
    }
}