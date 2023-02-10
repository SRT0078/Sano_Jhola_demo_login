
/**
 * Write a description of class Human here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Human
{
    String name;
    String gender;
    int age;
    String hight;
    String weight;
    int id;
    String bodycolor;
    
    public void eatFood(boolean eat, String food, int pri){
        if(eat){
            System.out.println("They are eating "+ food+" Rs."+pri);
        }else{
            System.out.println("They donesn't eat "+food+" foods "+pri);
        }
        this.play(true);
    }
    
    public void play(boolean st){
        System.out.println("They are playing the games...");
        this.work("fast");
    }
    
    public void work(String dofast){
        System.out.println("They are doing some work."+dofast);
        this.sleep("good night!!");
    }
    
    public void sleep(String slp){
        System.out.println(slp);
    }
}
