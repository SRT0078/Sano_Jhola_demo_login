
/**
 * Write a description of class Car here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Car extends Vehicle
{
    String carName;
    int sitNumber;
    String color;
    int speed;
    String Weight;
    String fuelCapacity;
    String exitSide;
    
    public static void main(String[] args)
    {
        Vehicle ve = new Vehicle();
        ve.start(true);
    }
}
