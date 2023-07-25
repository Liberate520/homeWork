package homeWork_oop.familytree.model;

import java.io.*;
import java.util.*;

public class FamilyTree {
    private List<Person> people;
    private Set<String> parentNames;

    public FamilyTree() {
        people = new ArrayList<>();
        parentNames = new HashSet<>();

    }

    public void addPerson(Person person) {
        people.add(person);
        parentNames.add(person.getFatherFirstName() + person.getFatherLastName());
        parentNames.add(person.getMotherFirstName() + person.getMotherLastName());
    }

    public void saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (Person person : people) {
                writer.print(person.getFirstName() + " ");
                writer.print(person.getLastName() + " ");
                writer.print(person.getDateBirthday() + " ");
                writer.print(person.getFatherFirstName() + " ");
                writer.print(person.getFatherLastName() + " ");
                writer.print(person.getMotherFirstName() + " ");
                writer.println(person.getMotherLastName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadFromFile(String filename) {
        people.clear();
        parentNames.clear();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] tokens = line.split(" ");
                Person person = new Person();
                person.setFirstName(tokens[0]);
                person.setLastName(tokens[1]);
                person.setBirthday(tokens[2]);
                person.setFatherFirstName(tokens[3]);
                person.setFatherLastName(tokens[4]);
                person.setMotherFirstName(tokens[5]);
                person.setMotherLastName(tokens[6]);
                addPerson(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sortByName() {
        Collections.sort(people, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                if (p1.getFirstName().equals(p2.getFirstName())) {
                    return p1.getLastName().compareTo(p2.getLastName());
                } else {
                    return p1.getFirstName().compareTo(p2.getFirstName());
                }
            }
        });
    }

    public void sortByAge() {
        Collections.sort(people, new Comparator<Person>() {
            public int compare(Person p1, Person p2) {
                return Integer.compare(p1.getAge(), p2.getAge());
            }
        });
    }

    public void printChildren(String firstName, String lastName) {
        System.out.println("Дети " + firstName + " " + lastName + ":");

        for (Person person : people) {
            if (person.getFatherFirstName().equalsIgnoreCase(firstName) && person.getFatherLastName().equalsIgnoreCase(lastName)) {
                System.out.println(person.getFirstName() + " " + person.getLastName());
            } else if (person.getMotherFirstName().equalsIgnoreCase(firstName) && person.getMotherLastName().equalsIgnoreCase(lastName)) {
                System.out.println(person.getFirstName() + " " + person.getLastName());
            }
        }

        System.out.println();
    }

    public List<Person> getPeople() {
        return people;
    }

}
