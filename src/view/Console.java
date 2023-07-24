package view;

import java.time.LocalDate;
import java.util.Scanner;

import model.Gender;
import presenter.Presenter;

public class Console implements View {

    private Scanner iScanner;
    private Presenter presenter;

    private boolean flag;
    CommandList commandList;

    public Console() {
        iScanner = new Scanner(System.in, "utf-8");
        presenter = new Presenter(this);
        flag = true;
        commandList = new CommandList(this);

    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Приветствую!");
        while (flag) {
            System.out.println(commandList.showCommands());
            String choise = iScanner.nextLine();
            commandList.execute(Integer.parseInt(choise));
        }

    }

    public void exit() {
        System.out.println("До свидания!");
        flag = false;

    }

    public void sortByBirthdate() {
        presenter.sortByBirthdate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void printInformation() {
        presenter.receiveInformation();
    }

    public void addHuman() {
        System.out.println("ИМЯ: \n");
        String name = iScanner.nextLine();
        System.out.println("ФАМИЛИЯ: \n");
        String surname = iScanner.nextLine();

        System.out.println("ДАТА РОЖДЕНИЯ (YYYY-MM-DD): \n");
        LocalDate dateOfBirth = LocalDate.parse(iScanner.nextLine());

        System.out.println("ПОЛ: \n");
        Gender gender = Gender.valueOf(genderFormat(iScanner.nextLine().toLowerCase()));

        presenter.addHuman(name, surname, gender, dateOfBirth);

    }

    public String genderFormat(String input) {
        StringBuilder strb = new StringBuilder();
        if (input.equals("мужской") || input.equals("м") || input.equals("муж") || input.equals("мужчина") || input.equals("male")) {
            strb.append("Male");
        } else if (input.equals("женский") || input.equals("ж") || input.equals("жен") || input.equals("женщина") || input.equals("female")) {
            strb.append("Female");
        }
        return strb.toString();
    }

}
