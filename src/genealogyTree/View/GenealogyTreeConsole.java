package View;

import model.GenealogyTree;
import model.Person;

import java.util.Scanner;

public class GenealogyTreeConsole {
    private GenealogyTree<Person> tree;
    private Scanner scanner;

    public GenealogyTreeConsole() {
        scanner = new Scanner(System.in);
        initTree();
    }

    private void initTree() {
        System.out.print("Введите имя корневой персоны: ");
        String rootName = scanner.nextLine();
        System.out.print("Введите возраст корневой персоны: ");
        int rootAge = Integer.parseInt(scanner.nextLine());
        Person root = new Person(rootName, rootAge);
        tree = new GenealogyTree<>(root);

        System.out.println("Дерево успешно создано.");
    }

    public void run() {
        boolean running = true;
        while (running) {
            printMenu();
            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    addPerson();
                    break;
                case "2":
                    getChildren();
                    break;
                case "3":
                    getAncestors();
                    break;
                case "4":
                    sortChildrenByName();
                    break;
                case "5":
                    sortAncestorsByName();
                    break;
                case "6":
                    saveToFile();
                    break;
                case "7":
                    loadFromFile();
                    break;
                case "8":
                    running = false;
                    break;
                default:
                    System.out.println("Неверная команда.");
                }
            }
            scanner.close();
            System.out.println("Работа завершена.");
        }
    
        private void printMenu() {
            System.out.println("\nВыберите действие:");
            System.out.println("1 - Добавить персону");
            System.out.println("2 - Получить детей персоны");
            System.out.println("3 - Получить предков персоны");
            System.out.println("4 - Отсортировать детей по имени");
            System.out.println("5 - Отсортировать предков по имени");
            System.out.println("6 - Сохранить дерево в файл");
            System.out.println("7 - Загрузить дерево из файла");
            System.out.println("8 - Выйти");
        }
    
        private void addPerson() {
            System.out.print("Введите имя персоны: ");
            String name = scanner.nextLine();
            System.out.print("Введите возраст персоны: ");
            int age = Integer.parseInt(scanner.nextLine());
            Person newPerson = new Person(name, age);
    
            System.out.print("Введите имя родителя (если нет, нажмите Enter): ");
            String parentName = scanner.nextLine();
            if (parentName.isEmpty()) {
                tree.addParentChildRelation(tree.getRoot(), newPerson);
            } else {
                // Поиск персоны по имени
                for (Person person : tree) {
                    if (person.getPersonName().equals(parentName)) {
                        tree.addParentChildRelation(person, newPerson);
                        break;
                    }
                }
            }
            System.out.println("Персона успешно добавлена.");
        }
    
        private void getChildren() {
            System.out.print("Введите имя персоны: ");
            String name = scanner.nextLine();
            // Поиск персоны по имени
            for (Person person : tree) {
                if (person.getPersonName().equals(name)) {
                    System.out.println("Дети персоны " + name + ": " + tree.getChildren(person));
                    return;
                }
            }
            System.out.println("Персона с именем " + name + " не найдена.");
        }
    
        private void getAncestors() {
            System.out.print("Введите имя персоны: ");
            String name = scanner.nextLine();
            // Поиск персоны по имени
            for (Person person : tree) {
                if (person.getPersonName().equals(name)) {
                    System.out.println("Предки персоны " + name + ": " + tree.getAncestors(person));
                    return;
                }
            }
            System.out.println("Персона с именем " + name + " не найдена.");
        }
    
        private void sortChildrenByName() {
            System.out.print("Введите имя персоны: ");
            String name = scanner.nextLine();
            // Поиск персоны по имени
            for (Person person : tree) {
                if (person.getPersonName().equals(name)) {
                    System.out.println("Дети персоны " + name + " отсортированы по имени: " + tree.sortChildrenByName(person));
                    return;
                }
            }
            System.out.println("Персона с именем " + name + " не найдена.");
        }
    
        private void sortAncestorsByName() {
            System.out.print("Введите имя персоны: ");
            String name = scanner.nextLine();
            // Поиск персоны по имени
            for (Person person : tree) {
                if (person.getPersonName().equals(name)) {
                    System.out.println("Предки персоны " + name + " отсортированы по имени: " + tree.sortAncestorsByName(person));
                    return;
                }
            }
            System.out.println("Персона с именем " + name + " не найдена.");
        }
    
        private void saveToFile() {
            System.out.print("Введите имя файла для сохранения дерева: ");
            String filePath = scanner.nextLine();
            tree.saveToFile(filePath);
        }
    
        private <T> void loadFromFile() {
            System.out.print("Введите имя файла для загрузки дерева: ");
            String filePath = scanner.nextLine();
            GenealogyTree<T> loadedTree = (GenealogyTree<T>) GenealogyTree.loadFromFile(filePath);
            if (loadedTree != null) {
                tree = (GenealogyTree<Person>) loadedTree;
            }
        }
    
        public static void main(String[] args) {
            GenealogyTreeConsole console = new GenealogyTreeConsole();
        console.run();
    }
}