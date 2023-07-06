package tree.view;

import tree.model.human.Gender;
import tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean flag;
    private MainMenu mainMenu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        flag = true;
        mainMenu = new MainMenu(this);
//        service = new Service();
        presenter = new Presenter();
    }

    @Override
    public void start() {
        System.out.println("Добро пожаловать\nВыбери действие: ");
        while (flag) {
            System.out.println(mainMenu.printMenu());
            int choice = inputNumMenu();
            if (choice == -1) {
                System.out.println("Ошибка ввода");
                continue;
            }
            mainMenu.execute(choice);
        }
    }

    private int inputNumMenu() {
        String line = scanner.nextLine();
        if (!checkLine(line)) {
            System.out.println("Ошибка ввода!");
            return -1;
        }
        int choice = Integer.parseInt(line);
        return choice;
    }

    private boolean checkLine(String line) {
        if (!line.matches("[0-9]+")) {
            return false;
        }
        int choice = Integer.parseInt(line);
        return choice > 0 && choice <= mainMenu.size();
    }

    public void addFromConsoleHuman() {
        System.out.println("Добавить человека\n Имя:");
        String humanName = scanner.nextLine();
        System.out.println("Дата рождения: (YYYY-MM-DD)");
        LocalDate humanBirthDay = LocalDate.parse(scanner.nextLine());
        System.out.println("Пол м/ж: ");
        Gender humanGender = getGender(scanner.nextLine());

        presenter.addFromConsoleHuman(humanName, humanBirthDay, humanGender);
    }

    public void getFromConsoleHuman() {
        System.out.println("Получение одной записи по имени");
        System.out.println("Укажите имя: ");
        String choice = scanner.nextLine();
        presenter.getFromConsoleHuman(choice);
    }

    public void getFromConsoleAllHuman() {
        System.out.println("Получение всех записей");
        presenter.getFromConsoleAllHuman();
    }

    public void finish() {
        System.out.println("До свидания");
        flag = false;
        presenter.save();
    }

    private Gender getGender(String text) {
        text = text.toLowerCase();
        if (text.equals("м")) {
            return Gender.Male;
        }
        if (text.equals("ж")) {
            return Gender.Female;
        }
        return null;
    }


    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }

}
