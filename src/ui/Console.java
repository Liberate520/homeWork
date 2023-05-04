package ui;

import model.humans.Gender;
import presenter.Presenter;

import java.sql.SQLOutput;
import java.util.Scanner;

import static model.humans.Gender.Female;
import static model.humans.Gender.Male;

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
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work){
            System.out.println(mainMenu.print());
            String line = scanner.nextLine();
            int numCommand = Integer.parseInt(line);
            mainMenu.execute(numCommand);
        }
    }

    public void addHuman() {
        System.out.println("Введите имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Укажите пол (м/ж)");
        String userGender = scanner.nextLine();
        Gender gender = null;
        if (userGender.equals("м")) gender = Male;
        if (userGender.equals("ж")) gender = Female;
        System.out.println("Введите дату рождения в формате ДД.ММ.ГГГГ");
        String dateOfBirth = scanner.nextLine();

        presenter.addHuman(firstName, lastName, gender, dateOfBirth);
    }

    public void serchByName(){
        System.out.println("Введите имя");
        String firstName = scanner.nextLine();
        presenter.serchByName(firstName);
    }

    public void listOfNames() {
        presenter.listOfNames();
    }

    public void finish() {
        System.out.println("До свидания!");
        work = false;
    }
}
