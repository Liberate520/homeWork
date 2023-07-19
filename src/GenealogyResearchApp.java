import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private List<Person> children;

    public Person(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    public List<Person> getChildren() {
        return children;
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

public class GenealogyResearchApp {
    public static void main(String[] args) {
        // Создаем людей
        Person john = new Person("John");
        Person mary = new Person("Mary");
        Person peter = new Person("Peter");
        Person alice = new Person("Alice");
        Person david = new Person("David");

        // Строим генеалогическое древо
        FamilyTree familyTree = new FamilyTree(john);
        john.addChild(mary);
        john.addChild(peter);
        mary.addChild(alice);
        peter.addChild(david);

        // Проводим исследование, получаем всех детей выбранного человека
        List<Person> children = familyTree.getRoot().getChildren();

        // Выводим результат исследования
        System.out.println("Дети выбранного человека:");
        for (Person child : children) {
            System.out.println(child.getName());
        }
    }
}