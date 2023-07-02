package human;

import java.util.ArrayList;
import java.util.List;

public class GenealogyTree {
    private List<Person> people;

    public GenealogyTree() {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person) {
        people.add(person);
    }

    public void showTree() {
        for (Person p : people){
            System.out.println(p.toString());
        }
    }

    public void findPerson(String name, String lastName) {
        for (Person p : people) {
            if (p.getName().equals(name) && p.getLastName().equals(lastName)) {
                System.out.println("Найден человек:\n" + "\t" + p);
            }
        }
    }

    public void printGenealogyTree(Person person) {
        System.out.print(person.getName() + " " + person.getLastName());
        List<Person> children = person.getChildren();
        for (Person child : children) {
            System.out.print(" -> ");
            printGenealogyTree(child);
        }
    }
}