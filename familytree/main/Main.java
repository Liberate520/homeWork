package homeWork_oop.familytree.main;

import java.util.Scanner;
import homeWork_oop.familytree.model.*;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить человека");
            System.out.println("2. Сохранить в файл");
            System.out.println("3. Загрузить из файла");
            System.out.println("4. Отсортировать по имени");
            System.out.println("5. Отсортировать по возрасту");
            System.out.println("6. Вывести детей");
            System.out.println("0. Для выхода из программы");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Person person = new Person();
                    System.out.println("Введите имя:");
                    person.setFirstName(scanner.next());
                    System.out.println("Введите фамилию:");
                    person.setLastName(scanner.next());
                    System.out.println("Введите дату рождения в формате 2016-08-16:");
                    person.setBirthday (scanner.next());
                    System.out.println("Введите имя отца:");
                    person.setFatherFirstName(scanner.next());
                    System.out.println("Введите фамилию отца:");
                    person.setFatherLastName(scanner.next());
                    System.out.println("Введите имя матери:");
                    person.setMotherFirstName(scanner.next());

                    System.out.println("Введите фамилию матери:");
                    person.setMotherLastName(scanner.next());
                    familyTree.addPerson(person);
                    break;

                case 2:
                    System.out.println("Введите имя файла:");
                    String filename = scanner.next();
                    familyTree.saveToFile(filename);
                    break;

                case 3:
                    System.out.println("Введите имя файла:");
                    filename = scanner.next();
                    familyTree.loadFromFile(filename);
                    break;

                case 4:
                    familyTree.sortByName();
                    break;

                case 5:
                    familyTree.sortByAge();
                    break;

                case 6:
                    System.out.println("Введите имя:");
                    String firstName = scanner.next();
                    System.out.println("Введите фамилию:");
                    String lastName = scanner.next();
                    familyTree.printChildren(firstName, lastName);
                    break;
                case 0:
                    System.exit(0);
                        break;

                default:
                    System.out.println("Неверный выбор");
                    break;
            }
        }
    }
}
