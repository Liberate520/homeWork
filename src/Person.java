import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private String gender;
    private String DayOfBirth;
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, String gender, String DayOfBirth) {
        this.name = name;
        this.gender = gender;
        this.DayOfBirth = DayOfBirth;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child){
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDayOfBirth() {
        return DayOfBirth;
    }

    public List<Person> getChildren() {
        return children;
    }
    public  String toString(){
        return name + " (Gender: " + gender + ", DOB: " + ")";
    }
}
