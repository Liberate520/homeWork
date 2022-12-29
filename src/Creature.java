import java.util.ArrayList;
import java.util.List;

public abstract class Creature<T extends Creature> {

    private String fullName;
    private Cat.Gender gender;
    private int age;
    private T mother, father;
    private List<T> children = new ArrayList<>();

    public String getFullName() {
        return fullName;
    }

    public Cat.Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public Creature getMother() {
        return mother;
    }

    public Creature getFather() {
        return father;
    }

    public List<T> getChildren() {
        return children;
    }
}
