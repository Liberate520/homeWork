package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;
import family_tree.view.commands.Command;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class ConsoleUi implements View{

    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;



    public ConsoleUi() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work = true;
        menu = new MainMenu(this);



    }

    @Override
    public void start() {
        System.out.println("Привет!");
        while (work) {
            System.out.println(menu.menu());
            String choice = scanner.nextLine();

            int numChoice = Integer.parseInt(choice);
            menu.execute(numChoice);
        }



    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);

    }

    public void finish() {
        System.out.println("Работа завершена, спасибо! ");
        work = false;
    }

    public void sortByBirthDate(){
        presenter.sortByBirthDate();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void getInfo() {
        presenter.getInfo();
    }

    public void addHuman() {
            System.out.println("Введите имя: ");
            String name = scanner.nextLine();
            System.out.println("Введите пол: ");
            String gend = scanner.nextLine();
            Gender gender = Gender.valueOf(gend);
            System.out.println("Введите дату рождения: ");
            String date = scanner.nextLine();
            LocalDate birthDate = LocalDate.parse(date);
            presenter.addHuman(name, gender, birthDate);
        }


    }

