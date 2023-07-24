package GenealogicalTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;




public class GenealogyResearchApp {
    public static void main(String[] args) {
        // Создаем людей
        Person john = new Person("John",52, "male");
        Person mary = new Person("Mary",21,"female");
        Person peter = new Person("Peter",24, "male");
        Person alice = new Person("Alice",2,"female");
        Person david = new Person("David",5,"male");

        // Строим генеалогическое древо
        FamilyTree familyTree = new FamilyTree(john);
        john.addChild(mary);
        john.addChild(peter);
        mary.addChild(alice);
        peter.addChild(david);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            // Выводим меню
            System.out.println("Выберите действие:");
            System.out.println("1. Изучить детей выбранного человека");
            System.out.println("2. Добавить нового человека с детьми");
            System.out.println("3. Вывести список объектов");
            System.out.println("4. Выйти");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Изучаем детей выбранного человека
                    System.out.print("Введите имя человека для изучения: ");
                    String name = scanner.next();
                    Person person = findPerson(familyTree.getRoot(), name);
                    if (person != null) {
                        List<Person> children = person.getChildren();
                        if (children.isEmpty()) {
                            System.out.println("У выбранного человека нет детей.");
                        } else {
                            System.out.println("Дети выбранного человека:");
                            for (Person child : children) {
                                System.out.println(child.getName());
                            }
                        }
                    } else {
                        System.out.println("Человек с таким именем не найден.");
                    }
                    break;
                case 2:
                    // Добавляем нового человека с детьми
                    System.out.print("Введите имя нового человека: ");
                    String newName = scanner.next();
                    Integer newAge = Integer.valueOf(scanner.next());
                    String newGender = scanner.next();
                    Person newPerson = new Person(newName, newAge, newGender);
                    System.out.print("Введите количество детей у нового человека: ");
                    int numChildren = scanner.nextInt();
                    for (int i = 0; i < numChildren; i++) {
                        System.out.print("Введите имя ребенка " + (i + 1) + ": ");
                        String childName = scanner.next();
                        Integer childAge = Integer.valueOf(scanner.next());
                        String childGender = scanner.next();
                        Person child = new Person(childName,childAge, childGender);
                        newPerson.addChild(child);
                    }
                    familyTree.getRoot().addChild(newPerson);
                    System.out.println("Новый человек успешно добавлен.");
                    break;
                case 3:
                    // Выводим список объектов
                    System.out.println("Список объектов в генеалогическом древе:");
                    printPerson(familyTree.getRoot());
                    break;
                case 4:
                    // Выходим из программы
                    System.out.println("Программа завершена.");
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
                    break;
            }
        } while (choice != 4);
    }

    public static Person findPerson(Person person, String name) {
        if (person.getName().equals(name)) {
            return person;
        } else {
            List<Person> children = person.getChildren();
            for (Person child : children) {
                Person foundPerson = findPerson(child, name);
                if (foundPerson != null) {
                    return foundPerson;
                }
            }
        }
        return null;
    }

    public static void printPerson(Person person) {
        System.out.println(person.getName());
        List<Person> children = person.getChildren();
        for (Person child : children) {
            printPerson(child);
        }
    }
}
