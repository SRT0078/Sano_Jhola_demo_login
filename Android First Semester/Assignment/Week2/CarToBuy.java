
/**
 *  Create an CarToBuy class where CarToBuy class is child of Car class. In the Car class is 
 *  inherit the car class's proparities.
 *
 * @author (Sitaram Thing)
 * @version (19.1.3 & 2022/11/07)
 */
public class CarToBuy extends Car
{
    //attributes of child class
    int price;
    String registeredYear;
    
    //create a cunstructor and assign the some of parameter
    public CarToBuy(String customerName, String descriptions, int price, String registeredYear){
        //call the super and child class's character assignement
        super.customerName = customerName;
        super.descriptions = descriptions;
        this.price = price;
        this.registeredYear = registeredYear;
    }
    
    // create the  display methods and display all the values
    public void display(){
        System.out.println("Hello!! "+super.customerName);
        System.out.println("This is a new branded car of "+super.descriptions);
        System.out.println("Price is "+this.price+" Lakh");
        System.out.println("The registated years: "+this.registeredYear);
    }
    
    //create an methods and call the display methods
    public static void main(String[] args){
        CarToBuy ctb = new CarToBuy("David","Tesla.",12,"2022");
        ctb.display();
    }
}