package service.UI;

import family.FamilyTree;
import service.FileHandlers.FileHandler;
import units.Gender;
import units.Human;

import java.io.IOException;
import java.util.Scanner;

public class Console {
    private Scanner scanner;
    private FamilyTree<Human> tree;

    public Console(FamilyTree<Human> tree) {
        this.scanner = new Scanner(System.in);
        this.tree = tree;
    }

    private Integer scan() {
        System.out.println(
                "Выберите действие:\n1 - Добавить человека в " + "дерево;" +
                        "\n2 - Вывести список людей в дереве;\n3 - Получить " +
                        "всю информацию о людях в дереве;\n4 - Сохранить " +
                        "измененное дерево;\n0 - Выход.");
        return scanner.nextInt();
    }

    public void addHuman() {
        try {
            System.out.println("Введите имя: ");
            String firstName = scanner.next();
            System.out.println("Введите фамилию: ");
            String secondName = scanner.next();
            System.out.println("Введите пол (Male или Female): ");
            Gender gender = Gender.valueOf(scanner.next());
            System.out.println(
                    "Введите дату рождения в формате(дд-мм-гггг): ");
            String[] birthdate = scanner.next().split("-");
            int birthday = Integer.parseInt(birthdate[0]);
            int birthmonth = Integer.parseInt(birthdate[1]);
            int birthyear = Integer.parseInt(birthdate[2]);
            tree.add(new Human(firstName, secondName, gender, birthday,
                               birthmonth, birthyear));

        } catch (Exception e) {
            System.out.println("Неверное значение.");
        }

    }

    public void getHumanList() {
        System.out.println("Список людей: ");
        for (Human human : tree) {
            System.out.println(human.getName());
        }
    }

    public void getAllInfo() {
        System.out.println(tree.getInfo());
    }

    public void update() throws IOException {
        System.out.println("Введите название файла: ");
        String path = scanner.next();
        tree.save(new FileHandler<Human>(), path);
    }

    public void start() throws IOException {
        while (true) {
            int function = scan();
            switch (function) {
                case 1 -> addHuman();
                case 2 -> getHumanList();
                case 3 -> getAllInfo();
                case 4 -> update();
                case 0 -> System.out.println("Пока!");
            }
            if (function == 0) {
                break;
            }
        }
    }
}
