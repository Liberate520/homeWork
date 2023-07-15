import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FamilyTree {
    // класс где будут храниться и обрабатываться созданные объекты
    private List<Person> personList = new ArrayList<>();

    void setPerson(Person... person) {
        Collections.addAll(personList, person);
    }

    public List<Person> showAllTree() {
        return this.personList;
    }

    public void showParents(Person person) {
        if (personList.contains(person)) {
            System.out.printf("Father is: %s, Mother is: %s\n", person.getFather(), person.getMother());
        } else System.out.println("Person not found");
    }

    public void showBrothersAndSisters(Person person) {
        List<Person> print = new ArrayList<>();
        for (Person p : personList) {
            if (person.getFather().equals(p.getFather()) & person.getMother().equals(p.getMother())
            ) {
                print.add(p);
            }
        }
        System.out.println(print.remove(print.indexOf(person)));
    }
}