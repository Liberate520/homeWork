import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private Human father;
    private Human mother;
    private List<Human> children;


    public Human(String name, LocalDate dateOfBirth, Gender gender, Human father, Human mother){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<Human>();
    }

    public Human(String name, LocalDate dateOfBirth, Gender gender){

        this(name, dateOfBirth, gender, null, null);

    }

    public Human(){

        this("Unknown", LocalDate.of(00,00,00), Gender.UNKNOWN, null, null);

    }

    public void addChild(Human human){
        if(!children.contains(human)) {
            this.children.add(human);
        }
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

    public LocalDate getDateOfBirth() {
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
