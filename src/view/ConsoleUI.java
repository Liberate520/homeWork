package view;

import model.Gender;
import model.Human;
import presenter.Presenter;
import view.commands.MainMenu;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View {

    private static final String INPUT_ERROR = "Вы ввели неверное значение";
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
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Приятно было пообщаться");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getFamilysListInfo() {
        presenter.getFamilysListInfo();
    }

    public void addFamily() {
        System.out.println("Введите имя ");
        String name = scanner.nextLine();
        System.out.println("Введите пол Male или  Female ");
        String gender = scanner.nextLine();
        System.out.println("Веедите год рождения");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите месяц рождени");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите день рождения");
        int day = Integer.parseInt(scanner.nextLine());
        LocalDate birthday = LocalDate.of(year, month, day);
        System.out.println("Имеется ли дата смерти?  1-нет или 2-да");
        int d = Integer.parseInt(scanner.nextLine());
        if (d == 1){
            LocalDate deathday = null;
            presenter.addFamily(name, Gender.valueOf(gender), birthday, deathday);
        } else {
            System.out.println("Веедите год смерти");
            int yearD = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите месяц смерти");
            int monthD = Integer.parseInt(scanner.nextLine());
            System.out.println("Введите день смерти");
            int dayD = Integer.parseInt(scanner.nextLine());
            LocalDate deathday = LocalDate.of(yearD, monthD, dayD);
            presenter.addFamily(name, Gender.valueOf(gender), birthday, deathday);
        }

    }
















    private void hello(){
        System.out.println("Доброго времени суток!");
    }



    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand < menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}