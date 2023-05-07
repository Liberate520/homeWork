package ui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import model.Gender;
import presenter.Presenter;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu mainMenu;

    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        mainMenu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Приветсвую Вас в семейном дереве!");
        while (work) {
            System.out.println(mainMenu.print());
            String line = scanner.nextLine();
            try {
                int numCommand = Integer.parseInt(line);
                if (numCommand > mainMenu.getNumberOfCommands()) {
                    System.out.println("Некорректная команда. Попробуйте еще раз.");
                    continue;
                }
                mainMenu.execute(numCommand);
            } catch (NumberFormatException e) {
                System.out.println("Некоректная коммада. Попробуйте еще раз.");
            }
        }
    }

    public void addHuman() {
        System.out.println("Введите имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Выберите пол:\n1. Мужской\n2. Женский");
        Gender gender = null;
        while (gender == null) {
            String input = scanner.nextLine();
            switch (input) {
                case "1":
                    gender = Gender.MALE;
                    break;
                case "2":
                    gender = Gender.FEMALE;
                    break;
                default:
                    System.out.println("Некорректный ввод. Попробуйте еще раз.");
            }
        }
        System.out.println("Введите дату рождения в формате 'дд.мм.гггг'");
        String input = scanner.nextLine();
        LocalDate birthDate = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        presenter.addHuman(firstName, lastName, birthDate, gender);
    }

    public void getInfo() {
        presenter.getInfo();
    }

    public void finish() {
        System.out.println("Досвидания");
        work = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
