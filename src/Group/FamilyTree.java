package Group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import Group.Comparators.PersonComparatorByAge;
import Group.Comparators.PersonComparatorByGender;
import Group.Comparators.PersonComparatorById;
import Group.Comparators.PersonComparatorByName;
import Person.Person;

public class FamilyTree implements Groupable, Serializable {

    private List<Person> familyTree;

    public FamilyTree() {
        familyTree = new ArrayList<>();
    }

    int id = 0;

    public void addPerson(Person person) {
        familyTree.add(person);
        if (person.getMother() != null)
            person.getMother().addChild(person);

        if (person.getFather() != null)
            person.getFather().addChild(person);
    }

    @Override
    public String toString() {
        return familyTree.toString();
    }

    public Person getPersonByName(String name) {
        Person findPerson = null;
        for (int i = 0; i < familyTree.size(); i++) {
            if (familyTree.get(i).getName().equals(name)) {
                findPerson = familyTree.get(i);
            }
        }
        if (findPerson == null)
            System.out.println("Такой человек не найден.");
        return findPerson;
    }

    public void findPerson() {
        System.out.println("Введите имя или фамилию для поиска:");
        Scanner iScanner = new Scanner(System.in, "cp866");
        String findName = iScanner.nextLine();
        boolean find = false;
        for (int i = 0; i < familyTree.size(); i++) {
            if (familyTree.get(i).getName().contains(findName)) {
                System.out.println(familyTree.get(i));
                find = true;
            }
        }
        if (!find)
            System.out.println("Такой человек не найден.");
        iScanner.close();
    }

    public List<Person> getPersonList() {
        return familyTree;
    }

    public void sortByName() {
        familyTree.sort(new PersonComparatorByName());
        ;
    }

    public void sortByAge() {
        familyTree.sort(new PersonComparatorByAge());
    }

    public void sortByGenderd() {
        familyTree.sort(new PersonComparatorByGender());
        ;
    }

    public void sortById() {
        familyTree.sort(new PersonComparatorById());
    }

    @Override
    public Iterator<Person> iterator() {
        return new PersonIterator(familyTree);
    }
}
