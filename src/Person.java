import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private int age;
    private List<Person> children;

    // Конструктор класса Person
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.children = new ArrayList<>();
    }

    // Геттеры и сеттеры для полей класса Person
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }
}
