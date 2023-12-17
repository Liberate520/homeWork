package view;

import model.creatures.Gender;
import presenter.Presenter;
import view.input.ConsoleInput;
import view.input.Input;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

//TODO: Вынести обработку исключений в отдельный класс

public class ConsoleUI implements View {
    private final Scanner scanner;
    private final Input input;
    private boolean work;
    private final MainMenu menu;
    private Presenter presenter;

    public ConsoleUI() {
        this.input = new ConsoleInput();
        this.scanner = new Scanner(System.in);
        this.presenter = new Presenter();
        work = true;
        menu = new MainMenu(this);
    }

    public void setWork(boolean work) {
        this.work = work;
    }

    @Override
    public void start() {
        System.out.println("Здравствуйте!\nВведите в консоль пункт меню и нажмите Enter");
        while (work) {
            printMenu();
            execute();
        }
    }

    //TODO: продолжаем обработку ввода
    public void addCreature() {
        Gender gend = Gender.Male;
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String lastName = scanner.nextLine();
        boolean flag = false;
        System.out.println("Выберите пол: 1. Мужской, 2. Женский");
        while (!flag) {
            try {
                int gender = Integer.parseInt(scanner.nextLine());
                if (gender == 2) {
                    gend = Gender.Female;
                    flag = true;
                }
                if (gender == 1) {
                    gend = Gender.Male;
                    flag = true;
                }
            } catch (Exception e) {
                System.out.println("Корректно введите пол: 1. Мужской, 2. Женский");
            }
        }
        flag = false;
        LocalDate date = null;
        while (!flag) {
            try {
                System.out.println("Введите дату рождения в формате год-месяц-день: (1990-09-10):");
                DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(scanner.nextLine(), dateFormat);
                flag = true;
            } catch (DateTimeParseException ignored) {
            }
        }
        if (presenter.addCreature(name, lastName, gend, date)) {
            System.out.println("Человек успешно добавлен!");
        } else {
            System.out.println("Не удалось создать такого человека");
        }
    }

    public void showTree() {
        System.out.println(presenter.showTree());
    }

    private void printMenu() {
        System.out.println(menu.menu());
    }

    private void execute() {
        try {
            menu.execute(input.intInput());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Пожалуйста, введите корректный номер пункта меню");
        }
    }

    public void showNotInTree() {
        System.out.println(presenter.showNotInTree());
    }

    //TODO: Обработать ошибки ввода
    public void setChild() {
        System.out.println("Введите ID родителя:");
        Integer parentID = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите ID ребенка:");
        Integer childID = Integer.parseInt(scanner.nextLine());
        if (presenter.setChild(parentID, childID)) {
            System.out.println("Ребенок успешно задан");
        } else {
            System.out.println("Не удалось задать ребенка");
        }
    }

    public void showAll() {
        System.out.println(presenter.showAll());
    }

    public void ShowAllInfo() {
        System.out.println("Введите ID человека");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println(presenter.showAllInfo(id));
    }

    public void showHumanTree() {
        System.out.println(presenter.showHumanTree());
    }

    public void setSpouce() {
        System.out.println("Введите ID первого супруга");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите ID второго супруга");
        Integer id2 = Integer.parseInt(scanner.nextLine());
        if (presenter.setSpouce(id, id2)) {
            System.out.println("Супруги заданы успешно!");
        } else {
            System.out.println("Не удалось выполнить команду");
        }

    }
}
