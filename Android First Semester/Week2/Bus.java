
/**
 * Write a description of class Bus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bus extends Vehicle
{
    String busNumbe;
    int sitNumber;
    int speed;
    String fuel;
    String weight;
    int window;
    String emergencyExit;
    String enterDoor;
    
    public static void main(String[] args)
    {
        Vehicle ve = new Vehicle();
        ve.run(1);
    }
}
