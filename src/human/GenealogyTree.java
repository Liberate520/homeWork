package human;

import java.io.Serializable;
import java.util.*;

public class GenealogyTree implements Serializable {
    private List<Person> people;

    public GenealogyTree()
    {
        this.people = new ArrayList<>();
    }

    public void addPerson(Person person)
    {
        people.add(person);
    }

    public void showTree() {
        for (Person p : people){
            System.out.println(p.toString());
        }
        System.out.println();
    }

    public void findPerson(String name, String lastName) {
        for (Person p : people) {
            if (p.getName().equals(name) && p.getLastName().equals(lastName)) {
                System.out.println("Найден человек:\n" + "\t" + p);
            }
        }
        System.out.println();
    }

    public void printGenealogyTree(Person person) {
        System.out.print(person.getName() + " " + person.getLastName());
        List<Person> children = person.getChildren();
        for (Person child : children) {
            System.out.print(" -> ");
            printGenealogyTree(child);
        }
    }

    public Iterator<Person> iterator() {
        return people.iterator();
    }

    public void sortByName() {
        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getName().compareTo(person2.getName());
            }
        });
    }

    public void sortByBirthDate() {
        Collections.sort(people, new Comparator<>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getDateOfBirth().compareTo(person2.getDateOfBirth());
            }
        });
    }
}