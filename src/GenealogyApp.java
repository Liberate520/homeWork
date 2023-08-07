import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int age;
    private List<Person> children;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.children = new ArrayList<>();
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


class FamilyTree {
    private Person root;

    public FamilyTree(Person root) {
        this.root = root;
    }

    public Person getRoot() {
        return root;
    }
}

public class GenealogyApp {
    public static void main(String[] args) {
        Person person1 = new Person("John", 40);
        Person person2 = new Person("Alice", 35);
        Person person3 = new Person("Bob", 20);

        person1.addChild(person2);
        person1.addChild(person3);

        FamilyTree familyTree = new FamilyTree(person1);

        // Получение всех детей выбранного человека
        List<Person> children = familyTree.getRoot().getChildren();
        System.out.println("Дети " + familyTree.getRoot().getName() + ":");
        for (Person child : children) {
            System.out.println(child.getName());
        }
    }
}