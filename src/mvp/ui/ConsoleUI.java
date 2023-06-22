package mvp.ui;

import java.time.LocalDate;
import java.util.Scanner;

import geoTree.GeoTree;
import mvp.presenter.Presenter;
import person.Person;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean flagWork;
    private MainMenu mainMenu;
    private GeoTree<Person> familyTree;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        flagWork = true;
        mainMenu = new MainMenu(this);
        presenter = new Presenter();
        familyTree = new GeoTree<>();
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (flagWork) {
            System.out.println("\n\n>>>>>>>>>>>>Семейное дерево<<<<<<<<<<<<<");
            System.out.println(mainMenu.printMenu());
            // ПРОВЕРКА НА КОРРЕКТНОСТЬ ВВОДА:
            int choice = inputNumMenu();

            if (choice == -1) {
                System.out.println("Ошибка ввода");
                continue;
            }

            mainMenu.execute(choice);
        }
    }

    /*
     *ДОБАВЛЕНИЕ ЛИЧНОСТЕЙ В СЕМЕЙНОЕ ДЕРЕВО
     */
    public void addNote() {
        System.out.println("Дата совершения операции");
        String timeWrite = scanner.nextLine();

        System.out.println("Имя:");
        String name = scanner.nextLine();

        System.out.println("Фамилия:");
        String surname = scanner.nextLine();

        System.out.println("Отчество:");
        String patronymic = scanner.nextLine();

        System.out.println("Дата рождения:");
        System.out.println("Год:");
        int year = scanner.nextInt();
        System.out.println("Месяц:");
        int month = scanner.nextInt();
        System.out.println("День:");
        int day = scanner.nextInt();

        LocalDate dateOfBirth = LocalDate.of(year, month, day);

        System.out.println("Добавить родственников отца и мать, введите 1:");
        int answer = scanner.nextInt();

        // ЗАГЛУШКА, ПРОБЛЕМА С ПОТОКОМ
        String del = scanner.nextLine();
        // ЗАГЛУШКА, ПРОБЛЕМА С ПОТОКОМ

        if (answer == 1) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>Отец<<<<<<<<<<<<<<<<<<<<");
            System.out.println("Имя:");
            String nameF = scanner.nextLine();

            System.out.println("Фамилия:");
            String surnameF = scanner.nextLine();

            System.out.println("Отчество:");
            String patronymicF = scanner.nextLine();

            System.out.println(">>>>>>>>>>>>>>>>>>>>Мать<<<<<<<<<<<<<<<<<<<<");
            System.out.println("Имя:");
            String nameM = scanner.nextLine();

            System.out.println("Фамилия:");
            String surnameM = scanner.nextLine();

            System.out.println("Отчество:");
            String patronymicM = scanner.nextLine();

            familyTree.addPerson(new Person(
                    name,
                    surname,
                    patronymic,
                    dateOfBirth,
                    familyTree.getByName(nameF, surnameF, patronymicF),
                    familyTree.getByName(nameM, surnameM, patronymicM)
                )
            );
        } else {
            familyTree.addPerson(new Person(
                    name,
                    surname,
                    patronymic,
                    dateOfBirth
                )
            );
        }

        // System.out.println(familyTree.getInfo()); //ТЕСТ(УДАЛИТЬ ПОТОМ)
    }

    public void getNote() {
        System.out.println("Укажите событие");
        String text = scanner.nextLine();
        presenter.getNote(text);
    }

    public void getAllNote() {
        presenter.getAllNote();
    }

    public void end() {
        System.out.println("Хорошего дня;)");
        flagWork = false;
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)) {
            System.out.println("Такого действия нет в меню");
            return -1;
        }
        return Integer.parseInt(line);
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")) {
            return false;
        }

        int choice = Integer.parseInt(line);

        return choice > 0 && choice <= mainMenu.size();
    }

}
