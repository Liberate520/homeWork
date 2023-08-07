import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

enum Gender {
    MALE,
    FEMALE
}
public class Person {
    private String name;
    private Gender gender;
    private String dateOfBirth; //dob
    private String dateOfDeath; //dod
    private Person father;
    private Person mother;
    private List<Person> children;

    public Person(String name, Gender gender, String dob) {
        this(name, gender, dob, null);
    }
    public Person(String name, Gender gender, String dateOfBirth, String dateOfDeath) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child){
        children.add(child);
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getDayOfBirth() {
        return dateOfBirth;
    }

    public List<Person> getChildren() {
        return children;
    }
    public  String toString(){
        return name + " (Gender: " + gender + ", DOB: " + ")";
    }
}
