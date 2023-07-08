package ru.gb.family_tree;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static FamilyTree familyTree;
    private static Scanner scanner;

    public static void main(String[] args) {
        familyTree = new FamilyTree();
        scanner = new Scanner(System.in);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить человека");
            System.out.println("2. Вывести всех людей");
            System.out.println("3. Поиск людей по имени");
            System.out.println("4. Поиск людей по возрасту");
            System.out.println("5. Сохранить дерево в файл");
            System.out.println("6. Загрузить дерево из файла");
            System.out.println("0. Выйти из программы");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера сканера

            switch (choice) {
                case 1 -> addPerson();
                case 2 -> printAllPeople();
                case 3 -> searchByName();
                case 4 -> searchByAge();
                case 5 -> saveToFile();
                case 6 -> loadFromFile();
                case 0 -> exit = true;
                default -> System.out.println("Некорректный выбор. Повторите попытку.");
            }
        }

        scanner.close();
    }

    private static void addPerson() {
        System.out.println("Введите данные нового человека:");
        System.out.print("Имя: ");
        String name = scanner.nextLine();
        System.out.print("Пол (MALE/FEMALE): ");
        Gender gender = Gender.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Дата рождения (в формате ГГГГ-ММ-ДД): ");
        LocalDate birthDate = LocalDate.parse(scanner.nextLine());

        Person person = new Person(name, gender, birthDate);
        familyTree.addPerson(person);

        boolean addRelations = true;
        while (addRelations) {
            System.out.println("\nВыберите тип связи:");
            System.out.println("1. Добавить супруг(у)");
            System.out.println("2. Добавить отца");
            System.out.println("3. Добавить мать");
            System.out.println("4. Добавить детей");
            System.out.println("0. Завершить добавление связей");
            System.out.print("Ваш выбор: ");
            int relationChoice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера сканера

            switch (relationChoice) {
                case 1 -> addSpouse(person);
                case 2 -> addFather(person);
                case 3 -> addMother(person);
                case 4 -> addChildren(person);
                case 0 -> addRelations = false;
                default -> System.out.println("Некорректный выбор. Повторите попытку.");
            }
        }


        System.out.println("Человек успешно добавлен в дерево. Ему присвоен ID: " + person.getId());
    }

    private static void printAllPeople() {
        List<Person> people = familyTree.getPeople();
        if (people.isEmpty()) {
            System.out.println("Дерево пусто.");
        } else {
            System.out.println("В дереве " + people.size() + " объектов:");
            for (Person person : familyTree) {
                System.out.println(person);
            }
        }
    }


    private static void searchByName() {
        System.out.print("Введите имя для поиска: ");
        String name = scanner.nextLine();

        List<Person> result = familyTree.searchByName(name);
        if (result.isEmpty()) {
            System.out.println("Люди с именем '" + name + "' не найдены.");
        } else {
            System.out.println("Результаты поиска по имени '" + name + "':");
            for (Person person : result) {
                System.out.println(person);
            }
        }
    }

    private static void searchByAge() {
        System.out.print("Введите возраст для поиска: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера сканера

        List<Person> result = familyTree.searchByAge(age);
        if (result.isEmpty()) {
            System.out.println("Люди с возрастом " + age + " не найдены.");
        } else {
            System.out.println("Результаты поиска по возрасту " + age + ":");
            for (Person person : result) {
                System.out.println(person);
            }
        }
    }

    private static void saveToFile() {
        System.out.print("Введите имя файла для сохранения: ");
        String fileName = scanner.nextLine();

        boolean success = FileUtils.saveToFile(fileName, familyTree);
        if (success) {
            System.out.println("Дерево успешно сохранено в файл '" + fileName + "'");
        } else {
            System.out.println("Ошибка при сохранении дерева в файл.");
        }
    }

    private static void loadFromFile() {
        System.out.print("Введите имя файла для загрузки: ");
        String fileName = scanner.nextLine();

        FamilyTree loadedTree = FileUtils.loadFromFile(fileName);
        if (loadedTree != null) {
            familyTree = loadedTree;
            System.out.println("Дерево успешно загружено из файла.");
        } else {
            System.out.println("Ошибка при загрузке дерева из файла.");
        }
    }

    private static void addSpouse(Person person) {
        System.out.println("\nДобавление супруг(а) для человека ID " + person.getId());
        System.out.print("Введите ID супруг(а): ");
        int spouseId = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера сканера

        Person spouse = familyTree.getPersonById(spouseId);
        if (spouse != null) {
            person.setSpouse(spouse);
            spouse.setSpouse(person);
            System.out.println("Супруг(а) успешно добавлен(а).");
        } else {
            System.out.println("Человек с ID " + spouseId + " не найден.");
        }
    }

    private static void addFather(Person person) {
        System.out.println("\nДобавление отца для человека ID " + person.getId());
        System.out.print("Введите ID отца: ");
        int fatherId = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера сканера

        Person father = familyTree.getPersonById(fatherId);
        if (father != null) {
            person.setFather(father);
            father.addChild(person);
            System.out.println("Отец успешно добавлен.");
        } else {
            System.out.println("Человек с ID " + fatherId + " не найден.");
        }
    }

    private static void addMother(Person person) {
        System.out.println("\nДобавление матери для человека ID " + person.getId());
        System.out.print("Введите ID матери: ");
        int motherId = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера сканера

        Person mother = familyTree.getPersonById(motherId);
        if (mother != null) {
            person.setMother(mother);
            mother.addChild(person);
            System.out.println("Мать успешно добавлена.");
        } else {
            System.out.println("Человек с ID " + motherId + " не найден.");
        }
    }

    private static void addChildren(Person person) {
        System.out.println("\nДобавление детей для человека ID " + person.getId());
        System.out.print("Введите ID детей через запятую: ");
        String childrenIdsString = scanner.nextLine();

        String[] childrenIds = childrenIdsString.split(",");
        for (String childIdString : childrenIds) {
            int childId = Integer.parseInt(childIdString.trim());
            Person child = familyTree.getPersonById(childId);
            if (child != null) {
                person.addChild(child);
                System.out.println("Ребенок с ID " + childId + " успешно добавлен.");
            } else {
                System.out.println("Человек с ID " + childId + " не найден.");
            }
        }
    }
}