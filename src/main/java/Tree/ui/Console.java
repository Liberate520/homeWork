package Tree.ui;

import Tree.model.components.Gender;
import Tree.presenter.Presenter;

import java.util.Scanner;

// класс реализует методы взаимодействия с пользователем
public class Console implements View {

    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    // сеттер
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    // метод запуска меню
    @Override
    public void start() {
        scanner = new Scanner(System.in);
        presenter.load();
        menu = new Menu(this);
        work = true;
        while (work) {
            visualMenu();
            System.out.print("Ввод: ");
            String command = scanner.nextLine();
            if (checkInputInt(command)) {
                menu.execute(Integer.parseInt(command));
                System.out.println();
            } else {
                System.out.println("Некорректный ввод!");
            }
        }
    }

    // метод проверки ввода целого положительного числа(года рождения)
    private int userInputIntPositivData(String msg) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите год рождения: ");
        int inputStr;
        while (true) {
            try {
                inputStr = Integer.parseInt(sc.next());
                if (inputStr > 0) {
                    break;
                } else {
                    System.out.println("Введите положительное значение!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод!");
            }
        }
        return inputStr;
    }


    // метод проверки ввода целого числа
    private boolean checkInputInt(String text) {
        return text.matches("[1-9]");
    }

    // визуальное оформление шапки меню
    private void visualMenu() {
        System.out.println("    ---    MENU    ---    ");
        System.out.println(menu.printMenu());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    // визуальное оформление завершения программы
    public void finish() {
        System.out.println("   ---   CLOSED   ---    ");
        work = false;
    }

    // метод парсинга имени
    public void searchByName() {
        System.out.print("Введите имя: ");
        presenter.searchByName(scanner.nextLine());
    }

    // метод показывает все дерево
    public void outputAList() {
        presenter.outputAList();
    }

    // метод парсинга имени удаляемого человека
    public void deletePerson() {
        print("Введите полное имя удаляемого человека: ");
        if (presenter.deletePerson(scanner.nextLine())) {
            print("Удаление успешно!");
        }else {
            System.out.println("Человек не найден!");
        }
    }

    // сохранение в файл
    public void save() {
        presenter.save();
        print("Изменения сохранены!");
    }

    // очистить дерево
    public void clearTree() {
        presenter.clearTree();
        System.out.println("Дерево очищено!");
    }

    // сортировка по алфавиту
    public void sortAlfab() {
        presenter.sortAlfab();
        System.out.println("Отсортировано по алфавиту!");
    }

    // сортировка по возрасту
    public void sortByAge() {
        presenter.sortByAge();
        System.out.println("Отсортировано по дате рождения!");
    }

    // Ввод данных добавляемого человека
    public void addHuman() {
        try {
            System.out.print("Ввод новых людей должен осуществляться по старшинству.\n"
                    + "Введите имя и фамилию: ");
            String fullName = scanner.nextLine();

            System.out.print("Введите (male, female) пол: ");
            String gender = scanner.next();
            Gender sex = Gender.valueOf(gender);
            int birth = userInputIntPositivData(scanner.nextLine());
            System.out.print("""
                    Родителей можно добавить если они уже были ранее добавлены в дерево.
                    Если родители неизвестны то поля необходимо оставить пустыми.
                    Введите имя и фамилию матери:\s""");
            String mother = scanner.nextLine();
            System.out.print("Введите имя и фамилию отца: ");
            String father = scanner.nextLine();
            presenter.addHuman(fullName, birth, sex, mother, father);
            System.out.println("Человек добавлен!");
        } catch (Exception e) {
            System.out.println("Человек не добавлен. Введены некорректные данные!");
        }
    }
}