import java.io.Serializable;
import java.util.ArrayList;

public class FamilyTree implements Serializable  {
    private ArrayList <Person> Ancestry;

    public FamilyTree() {
        this.Ancestry= new ArrayList<Person>();
    }
    public void add(Person curPer){
        this.Ancestry.add(curPer);
    }
    public Person getByName(String name){
        for (Person human : Ancestry){
            if (human.getName().equals(name)){
                return human;
            }
        }
        return null;
    }
    //печать списка персон
    public void printListPerson(){
        for (Person human : Ancestry){
            System.out.println(human.getName());
        }

    }

}
