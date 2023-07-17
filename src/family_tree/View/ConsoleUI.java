package family_tree.View;

import java.time.LocalDate;
import java.util.Scanner;

import family_tree.Model.human.Gender;
import family_tree.Model.human.Human;
import family_tree.Presenter.Presenter;

public class ConsoleUI {
    private Scanner scanner;
    private Presenter presenter;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }

    public void work(){
        int choise = 0;
        hello();
        loadTree();
        while(choise != 11) {
            System.out.println("Что необходимо сделать:\n [1] - Добавить человека");
            System.out.println(" [2] - Добавить дату смерти\n [3] - Создать семейные связи");
            System.out.println(" [4] - Добавить ребенка\n [5] - Добавить родителей");
            System.out.println(" [6] - Найти человека\n [7] - Показать все дерево");
            System.out.println(" [8] - Удалить человека из дерева");
            System.out.println(" [9] - Сохранить дерево в файл\n [10] - Загрузить дерево из файла");
            System.out.print(" [11] - Выход\n--> ");
            choise = scanner.nextInt();
            switch (choise) {
                case 1:
                    addHuman();
                    break;
                case 2:
                    setDeathDate();
                    break;
                case 3:
                    addFamily();
                    break;
                case 4:
                    addChild();
                    break;
                case 5:
                    addParents();
                    break;
                case 6:
                    findHuman();
                    break;
                case 7:
                    showAllTree();
                    break;
                case 8:
                    deleteHuman();
                    break;
                case 9:
                    saveTree();
                    break;
                case 10:
                    loadTree();
                    break;
                case 11:
                    saveTree();
                    goodbye();
                    break;
                default:
                    System.out.println("\nНекорректный выбор!\n");
                    break;
            }
        }
    }

    private void hello() {
        System.out.println("Добро пожаловать!\nРабота с генеалогическим древом.");
    }

    private void goodbye() {
        System.out.println("До новых встреч!");
    }

    private void addHuman() {
        scanner.nextLine();
        System.out.print("Введите имя человека: ");
        String name = scanner.nextLine();
        System.out.print("Укажите дату рождения в формате dd.MM.yyyy: ");
        String birthDateString = scanner.nextLine();
        String[] birthDateArray = birthDateString.split("\\.");
        LocalDate birthDate = LocalDate.of(Integer.parseInt(birthDateArray[2]), Integer.parseInt(birthDateArray[1]), Integer.parseInt(birthDateArray[0]));
        System.out.print("Укажите пол\n [1] - Мужской\n [2] - Женский\n --> ");
        int genderScanner = scanner.nextInt();
        Gender gender;
        if (genderScanner == 1) {
            gender = Gender.Male;
        } else {
            gender = Gender.Female;
        }
        presenter.addHuman(name, birthDate, gender);
    }

    private void setDeathDate() {
        scanner.nextLine();
        System.out.print("Введите имя человека которому надо добавить дату смерти: ");
        String name = scanner.nextLine();
        Human human = presenter.findHuman(name);
        System.out.print("Укажите дату смерти в формате dd.MM.yyyy: ");
        String deathDateString = scanner.nextLine();
        String[] deathDateArray = deathDateString.split("\\.");
        LocalDate deathDate = LocalDate.of(Integer.parseInt(deathDateArray[2]), Integer.parseInt(deathDateArray[1]), Integer.parseInt(deathDateArray[0]));
        presenter.setDeathDate(human, deathDate);
    }

    private void addFamily() {
        scanner.nextLine();
        System.out.print("Введите имя первого родителя: ");
        String name = scanner.nextLine();
        Human parent1 = presenter.findHuman(name);
        System.out.print("Введите имя второго родителя: ");
        name = scanner.nextLine();
        Human parent2 = presenter.findHuman(name);
        System.out.print("Введите имя ребенка: ");
        name = scanner.nextLine();
        Human child = presenter.findHuman(name);
        presenter.createFamily(parent1, parent2, child);
    }

    private void addChild() {
        scanner.nextLine();
        System.out.print("Введите имя родителя: ");
        String name = scanner.nextLine();
        Human parent = presenter.findHuman(name);
        System.out.print("Введите имя ребенка: ");
        name = scanner.nextLine();
        Human child = presenter.findHuman(name);
        presenter.addChild(parent, child);
    }

    private void addParents() {
        scanner.nextLine();
        System.out.print("Введите имя ребенка: ");
        String name = scanner.nextLine();
        Human child = presenter.findHuman(name);
        System.out.print("Введите имя первого родителя: ");
        name = scanner.nextLine();
        Human parent1 = presenter.findHuman(name);
        System.out.print("Введите имя второго родителя: ");
        name = scanner.nextLine();
        Human parent2 = presenter.findHuman(name);
        presenter.addParents(child, parent1, parent2);
    }

    private void findHuman() {
        scanner.nextLine();
        System.out.print("Введите имя человека котрого ищем: ");
        String name = scanner.nextLine();
        Human human = presenter.findHuman(name);
        System.out.println(human);
    }

    private void showAllTree() {
        scanner.nextLine();
        System.out.print("По какойму принципу отсортировать вывод: \n [1] - по имени\n [2] - по дате рождения\n [3] - по возрасту\n [ ] - не сортировать\n-->");
        int sortBy = scanner.nextInt();
        presenter.getFamilyTreeInfo(sortBy);
    }

    private void deleteHuman() {
        scanner.nextLine();
        System.out.print("Введите имя человека котрого надо удалить: ");
        String name = scanner.nextLine();
        Human human = presenter.findHuman(name);
        presenter.deleteHuman(human);
    }

    private void saveTree() {
        presenter.saveTree("Projects_OOP/Projects_OOP_HomeWork/src/family_tree/FamilyTree1.out");
    }

    private void loadTree() {
        presenter.loadTree("Projects_OOP/Projects_OOP_HomeWork/src/family_tree/FamilyTree1.out");
    }

}
