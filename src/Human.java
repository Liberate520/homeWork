import java.util.ArrayList;
import java.util.List;

public class Human {
    private String name;
    private String dateOfBirth;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;


    public Human(String name, String dateOfBirth, Gender gender, Human father, Human mother, List<Human> children){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }

    public Human(String name, String dateOfBirth, Gender gender){

        this(name, dateOfBirth, gender, null, null, new ArrayList<Human>());

    }

    public Human(){

        this("Unknown", "Unknown", Gender.UNKNOWN, null, null, new ArrayList<Human>());

    }

    public void addChild(Human human){
        this.children.add(human);
    }


    @Override
    public String toString() {

        String f1 = "UNKNOWN";
        String m1 = "UNKNOWN";
        String c1 = "|";

        if(father != null) f1 = father.getName();
        if(mother != null) m1 = mother.getName();
        for(Human item : children){
            c1 += item.getName() + " | ";
        }

        return  "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", gender=" + gender +
                ", father=" + f1 +
                ", mother=" + m1 +
                ", children=" + c1;
    }

    public String getName(){
        return name;
    }

    public Human getFather() {
        return father;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public Gender getGender() {
        return gender;
    }
}
