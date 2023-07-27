package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Предлагаю выбрать команду:");
        while(work) {
            System.out.println(menu.menu());
            String line = scanner.nextLine();
            // проверка ввода пользователя
            try {
                int choice = Integer.parseInt(line);
                if (choice > 0 & choice < 8)
                    menu.execute(choice);
                else
                    System.out.println("Вы ввели что-то не то");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }

    public void sortByDateBirch() {
        presenter.sortByDateBirth();
    }

    public void sortByAgeByFirstName() {
        presenter.sortByAgeByFirstName();
    }
    public void addHuman() {
        System.out.print("Введите имя человека: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите фамилию человека: ");
        String lastName = scanner.nextLine();
        System.out.print("Введите дату рождения человека (гггг.мм.дд): ");
        String birthDateString = scanner.nextLine();
        System.out.print("Введите пол: (m или f): ");
        String genderString = scanner.nextLine();
        try {
            String[] str = birthDateString.split("\\.");
            LocalDate birthDate = LocalDate.of(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
            Gender gender = null;
            if (genderString.equals("m"))
                gender = Gender.male;
            if (genderString.equals("f"))
                gender = Gender.female;
            presenter.addHuman(firstName, lastName, birthDate, gender);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void getHumanListInfo() {
        presenter.getHumanListInfo();
    }

    public void sortByFirstName() {
        presenter.sortByFirstName();
    }

    public void sortByLastName() {
        presenter.sortByLastName();
    }
}
