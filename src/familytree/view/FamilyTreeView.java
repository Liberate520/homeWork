package familytree.view;

//import familytree.model.Familytree;
import familytree.model.Person;

import java.util.*;

public class FamilyTreeView implements Iterator<Person> {
    private List<Person> people;
    private int currentIndex;
    private static Scanner scanner = new Scanner(System.in);
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
//--------------------------------------------------------------

    public void addPeople(List<Person> people) {
        System.out.println("Хотите добавить людей? (да/нет)");
        // Scanner scanner;
        String choice = scanner.nextLine();

        while (choice.equalsIgnoreCase("да")) {
            Person person = createPerson();
            people.add(person);
            addChildren(person);
            addParents(person);

            System.out.println("Хотите добавить еще людей? (да/нет)");
            choice = scanner.nextLine();
        }
    }

    public Person createPerson() {
        System.out.println("Введите имя:");
        String name = scanner.nextLine();

        System.out.println("Введите фамилию:");
        String surname = scanner.nextLine();

        System.out.println("Введите дату рождения:");
        String dateOfBirth = scanner.nextLine();

        System.out.println("Введите пол:");
        String gender = scanner.nextLine();

        // Создаем объект класса Person
        return new Person(name, surname, dateOfBirth, "", gender, "");
    }

    public void addChildren(Person person) {
        System.out.println("Хотите добавить детей для " + person.getName() + "? (да/нет)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("да")) {
            List<Person> children = new ArrayList<>();

            System.out.println("Сколько детей вы хотите добавить?");
            int count = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < count; i++) {
                System.out.println("Введите имя ребенка " + (i + 1) + ":");
                String childName = scanner.nextLine();

                System.out.println("Введите фамилию ребенка " + (i + 1) + ":");
                String childSurname = scanner.nextLine();

                System.out.println("Введите дату рождения ребенка " + (i + 1) + ":");
                String childDateOfBirth = scanner.nextLine();

                // Создаем объект класса Person для ребенка
                Person child = new Person(childName, childSurname, childDateOfBirth, "", "", "");
                children.add(child);
            }
            // Устанавливаем список детей для родительского объекта Person
            person.setChildren(children);
        }
    }

    public void addParents(Person person) {
        System.out.println("Хотите добавить родителей для " + person.getName() + "? (да/нет)");
        String choice = scanner.nextLine();

        if (choice.equalsIgnoreCase("да")) {
            List<Person> parents = new ArrayList<>();

            System.out.println("Сколько родителей вы хотите добавить?");
            int count = Integer.parseInt(scanner.nextLine());

            for (int i = 0; i < count; i++) {
                System.out.println("Введите имя родителя " + (i + 1) + ":");
                String parentName = scanner.nextLine();

                System.out.println("Введите фамилию родителя " + (i + 1) + ":");
                String parentSurname = scanner.nextLine();

                System.out.println("Введите дату рождения родителя " + (i + 1) + ":");
                String parentDateOfBirth = scanner.nextLine();

                // Создаем объект класса Person для родителя
                Person parent = new Person(parentName, parentSurname, parentDateOfBirth, "", "", "");
                parents.add(parent);
            }
            // Устанавливаем список родителей для объекта Person
            person.setParents(parents);
        }


    }
}
