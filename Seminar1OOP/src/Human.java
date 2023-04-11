import java.util.List;

public class Human {
    Human father;
    Human mother;
    List<Human> children;
    String name;
    int yearOfBirth;
    String gender;
    public Human(String name, int yearOfBirth, String gender) {
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name + ": " + yearOfBirth + ", (" + gender + ")";
    }
}
