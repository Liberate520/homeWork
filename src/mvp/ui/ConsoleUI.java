package mvp.ui;

import java.time.LocalDate;
import java.util.Scanner;

import model.geoTree.GeoTree;
import model.person.Person;
import mvp.presenter.Presenter;

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
     * ДОБАВЛЕНИЕ ЛИЧНОСТЕЙ В СЕМЕЙНОЕ ДЕРЕВО
     */
    public void addNote() {
        LocalDate timeWrite = inputDate("Дата совершения операции");

        String name = inputStringText("Имя: ");
        String surname = inputStringText("Фамилия: ");
        String patronymic = inputStringText("Отчество: ");

        LocalDate dateOfBirth = inputDate("Дата рождения:");

        System.out.println("Добавить родственников отца и мать, введите 1:");
        int answer = scanner.nextInt();

        // ЗАГЛУШКА, ПРОБЛЕМА С ПОТОКОМ
        String del = scanner.nextLine();
        // ЗАГЛУШКА, ПРОБЛЕМА С ПОТОКОМ

        if (answer == 1) {
            System.out.println(">>>>>>>>>>>>>>>>>>>>Отец<<<<<<<<<<<<<<<<<<<<");
            
            String nameF = inputStringText("Имя: ");
            String surnameF = inputStringText("Фамилия: ");
            String patronymicF = inputStringText("Отчество: ");

            System.out.println(">>>>>>>>>>>>>>>>>>>>Мать<<<<<<<<<<<<<<<<<<<<");
            
            String nameM = inputStringText("Имя: ");
            String surnameM = inputStringText("Фамилия: ");
            String patronymicM = inputStringText("Отчество: ");

            familyTree.addPerson(new Person(
                    name,
                    surname,
                    patronymic,
                    dateOfBirth,
                    familyTree.getByName(nameF, surnameF, patronymicF),
                    familyTree.getByName(nameM, surnameM, patronymicM)));
        } else {
            familyTree.addPerson(new Person(
                    name,
                    surname,
                    patronymic,
                    dateOfBirth));
        }

        // System.out.println(familyTree.getInfo()); //ТЕСТ(УДАЛИТЬ ПОТОМ)
    }

    private String inputStringText(String text) {
        System.out.println(text);
        String textUser = scanner.nextLine();
        return textUser;
    }

    private LocalDate inputDate(String textInfo) {
        System.out.println(textInfo);
        System.out.println("Год:");
        int year = scanner.nextInt();
        System.out.println("Месяц:");
        int month = scanner.nextInt();
        System.out.println("День:");
        int day = scanner.nextInt();

        LocalDate date = LocalDate.of(year, month, day);

        return date;
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

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
