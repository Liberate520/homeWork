package familytree.view;

//import familytree.model.Familytree;
import familytree.model.Person;

import java.util.*;

public class FamilyTreeView implements Iterator<Person> {
    private List<Person> people;
    private int currentIndex;
    public void printPeople(List<Person> people) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Хотите распечатать информацию о людях? (да/нет)");
        String choice = scanner.nextLine();
        if (choice.equalsIgnoreCase("да")) {
            for (Person person : people) {
                person.printInfo();
                System.out.println();
            }
        }
    }

    public void sortPeopleByName(List<Person> people) {
        Collections.sort(people, Comparator.comparing(o->o.getName()));
        Iterator<Person> iteratorName = people.iterator();
        while (iteratorName.hasNext()){
            System.out.println(iteratorName.next());
        }

    }
    public void sortPeopleSurName(List<Person> people) {
        Collections.sort(people, Comparator.comparing(o->o.getSurname()));
        Iterator<Person> iteratorName = people.iterator();
        while (iteratorName.hasNext()){
            System.out.println(iteratorName.next());
        }

    }

    @Override
    public boolean hasNext() {
        return currentIndex < people.size();
    }

    @Override
    public Person next() {
        if (hasNext()) {
            return people.get(currentIndex++);
        } else {
            throw new NoSuchElementException();
        }
    }
}
