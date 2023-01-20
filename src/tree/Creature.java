package tree;

import java.util.ArrayList;
import java.util.List;

public abstract class Creature<T extends Creature> {

    protected String fullName;
    protected Gender gender;
    protected int age;
    protected T mother, father;
    protected List<T> children = new ArrayList<>();

    public String getFullName() {
        return fullName;
    }

    public Gender getGender() {
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
