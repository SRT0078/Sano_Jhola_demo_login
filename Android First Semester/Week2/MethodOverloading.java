
/**
 * Write a description of class k here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */ //Polymorephism
public class MethodOverloading
{
    public static int add(int a, int b){
        return a+b;
    }
    
    static int add(int a, int b, int c){
        return a+b+c;
    }
    
    public static void main(String[] args){
        System.out.println(add(10,20));
    }
}//Same methods but different parameters/arguments type, size etc
