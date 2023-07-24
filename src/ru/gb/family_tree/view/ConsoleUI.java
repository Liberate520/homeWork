package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private MainMenu menu;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        work=true;
        menu=new MainMenu(this);
    }

    @Override
    public void start() {
        System.out.print("Добро пожаловать");
        while(work){
            System.out.println(menu.menu());
            String choice=scanner.nextLine();
            //проверка
            int numChoice=Integer.parseInt(choice);
            menu.execute(numChoice);
        }

    }

    public void finish() {
        System.out.println("Goodbye");
        work=false;
    }

    public  void sortByAge() {
        presenter.sortByAge();
    }

    public  void sortByName() {
        presenter.sortByName();
    }

    public  void getHumanInfo() {
        presenter.getHumanInfo();
    }

    public  void addHuman() {
        System.out.print("Введите имя");
        String name=scanner.nextLine();
        System.out.println("Введите дату рождания");
        String birthDate=scanner.nextLine();
        //метод проверки
        System.out.println("Введите дату смерти");
        String deathDate=scanner.nextLine();
        System.out.println("Введите пол");
        String gender =scanner.nextLine();
        presenter.addHuman(name, LocalDate.parse(birthDate),LocalDate.parse(deathDate), Gender.valueOf(gender));
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);

    }
}
