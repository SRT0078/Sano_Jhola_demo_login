
/**
 * Write a description of class Vehicle here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Vehicle
{
    String vehicleNumber;
    String vehicleName;
    int sitNumber;
    String color;
    int price;
    String engine;
    int weight;
    
    public static void start(boolean st)
    {
        if(st)
        {
            System.out.println("The Vehicle is start.");
        }else
        {
            System.out.println("The vehilce is't start.");
        }
    }
    
    public void run(int sd)
    {
        System.out.println("The vechile is fast running.");
    }
    
    public void stop(boolean sp)
    {
        System.out.println("The vehicle is stop.");
    }
    
    public static void main(String[] args)
    {
        Vehicle vss = new Vehicle();
        vss.start(false);
        vss.run(12);
        vss.stop(true);
    }
}
