package family_tree.view;

import family_tree.presenter.Presenter;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner  scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.println("Приветствую!");
        while (work) {
            printMenu();
            scanMenu();
        }
    }

    private void scanMenu(){
        if (scanner.hasNextInt()) {
            String choicestr = scanner.nextLine();


            int choice = Integer.parseInt(choicestr);
            if (choice > menu.size()) {
                System.out.println("Ввели команду больше чем есть!");
                return;
            }
            menu.execute(choice);
        }



    }

    public void error() {
        System.out.println("Вы ввели неверное значение");
    }
    public void finish() {
        System.out.println("Досвидание");
        work = false;
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void GetHumanListInfo() {
        presenter.GetHumanListInfo();
    }

    public void addHuman() {
        //(String snils, String fam, String name, LocalDate dr, Gender gender)
        System.out.println("Введите СНИЛС");
        String snils = scanner.nextLine();
        System.out.println("Введите Фамилию");
        String fam = scanner.nextLine();
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения в формате дд-мм-гггг");
        String dateStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        LocalDate dr = LocalDate.parse(dateStr, formatter);
        presenter.addHuman(snils, fam, name, dr);

    }




    public void printMenu() {
        System.out.println(menu.print());



    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
