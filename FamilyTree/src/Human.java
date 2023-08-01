import java.util.ArrayList;
import java.util.List;

public class Human {
    protected List<Human> children = new ArrayList<>();

    static protected List<Human> persons;
    protected Human parent = null;
    protected String firstName = null;
    protected String secondName = null;



    static {
        persons = new ArrayList<>();
    }

    public Human(String secondName, String firstName){
        this.secondName = secondName;
        this.firstName = firstName;
        this.addPerson(this);
    }

    public Human(String secondName, String firstName, Human parent){
        this.secondName = secondName;
        this.firstName = firstName;
        this.parent = parent;
        parent.addChild(this);
        this.addPerson(this);
    }

    public void addPerson(Human person){
        persons.add(person);
    }

    public static List<Human> getPersons(){
        return persons;
    }

    public List<Human> getChildren(){
        return children;
    }

    public void setParent(Human parent){
        this.parent = parent;
        parent.addChild(this);
    }

    public Human getParent(){
        return this.parent;
    }

    public void addChild(Human child){
        //child.setParent(this);
        this.children.add(child);
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getSecondName(){
        return this.secondName;
    }

//    public Gender getGender(){
//        return this.gender;
//    }

    public void setFirstName(String firstName){
        this.secondName = firstName;
    }

    public void setSecondName(String secondName){
        this.secondName = secondName;
    }


    @Override
    public String toString(){
        return (firstName + " " + secondName);
    }
}
