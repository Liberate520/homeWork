package GenealogicalTree;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private final String name;
    private final Integer age;
    private final String gender;
    private final List<GenealogicalTree.Person> children;

    public Person(String name, Integer age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name+ ", " + age + " years, " + gender;
    }

    public void addChild(GenealogicalTree.Person child) {
        children.add(child);
    }

    public List<GenealogicalTree.Person> getChildren() {
        return children;
    }
}

