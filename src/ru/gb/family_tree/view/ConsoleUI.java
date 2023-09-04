package ru.gb.family_tree.view;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.presenter.Presenter;

import java.awt.*;
import java.time.LocalDate;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;

    public ConsoleUI() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
    }

    @Override
    public void print(String text){
        System.out.println(text);
    }

    @Override
    public void start() {
        hello();
        while (work) {
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("До новых встреч.");
        work = false;
    }

    private void hello() {
        System.out.println("Здравствуйте! Выберите из списка:");
    }

    public void addHuman() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Укажите дату рождения (гггг-мм-дд)");
        String birthString = scanner.nextLine();
        LocalDate birthDate = null;
        if (birthString != "") {
            birthDate = LocalDate.parse(birthString);
        }
        System.out.println("Укажите возраст: ");
        String ageString = scanner.nextLine();
        int age = Integer.parseInt(ageString);

        System.out.println("Укажите пол: М/Ж");
        String genderString = scanner.nextLine();
        Gender gender = null;
        if (genderString.equals("Ж"))
            gender = Gender.Female;
        if (genderString.equals("М"))
            gender = Gender.Male;
        presenter.addHuman(name, null, null, age, age);
    }

    public void addChild() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Укажите возраст: ");
        String ageString = scanner.nextLine();
        int age = Integer.parseInt(ageString);
    }

    public void addParent() {
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Укажите возраст: ");
        String ageString = scanner.nextLine();
        int age = Integer.parseInt(ageString);
    }

    public void getHumanList(){
        presenter.getHumanList();
    }

    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByName() {
        presenter.sortByName();
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
        System.out.println(menu.print());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }
}
