import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FamilyTree implements Serializable {
    // класс где будут храниться и обрабатываться созданные объекты
    private List<Person> personList;
    FamilyTree(){
        personList = new ArrayList<>();
    }
    void setPerson(Person... person) {
        Collections.addAll(personList, person);
    }

    public List<Person> showAllTree() {
        return this.personList;
    }

    public String getParents(Person person) {
        if (personList.contains(person)) {
            return String.format(
                    "Parents %s - Father: %s, Mother: %s",person.getName(),
                    person.getFather(), person.getMother());
        } else return "Person not found";
    }

    public List<Person> getBrothersAndSisters(Person person) {
        List<Person> printList = new ArrayList<>();
        for (Person p : personList) {
            if (person.getFather().equals(p.getFather())
                    & person.getMother().equals(p.getMother())
            ) {
                printList.add(p);
            }
        }
        printList.remove(person);
        return printList;
    }

    public List<Person> getChildren(Person person) {
        List<Person> printList = new ArrayList<>();
        for (Person p : personList) {
            if (p.getMother() != null || p.getFather() != null) {
                if (p.getMother().equals(person)
                        | p.getFather().equals(person)) {
                    printList.add(p);
                }
            }
        }
        return printList;
    }
}