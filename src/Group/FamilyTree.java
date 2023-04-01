package Group;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Person.Person;

public class FamilyTree extends Group implements Serializable{

    private List<Person> famyliTree = new ArrayList<Person>();

    public void addPerson(Person person) {
        famyliTree.add(person);
        if (person.getMother() != null)
            person.getMother().addChild(person);

        if (person.getFather() != null)
            person.getFather().addChild(person);
    }

    @Override
    public String toString() {
        return famyliTree.toString();
    }

    public Person getPersonByName(String name) {
        Person findPerson = null;
        for (int i = 0; i < famyliTree.size(); i++) {
            if (famyliTree.get(i).getName().equals(name)) {
                findPerson = famyliTree.get(i);
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
        for (int i = 0; i < famyliTree.size(); i++) {
            if (famyliTree.get(i).getName().contains(findName)) {
                System.out.println(famyliTree.get(i));
                find = true;
            }
        }
        if (!find)
            System.out.println("Такой человек не найден.");
        iScanner.close();
        
    }
}
