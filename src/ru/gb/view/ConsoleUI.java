package ru.gb.view;


import ru.gb.model.data.Gender;
import ru.gb.model.human.Human;
import ru.gb.presenter.Presenter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private boolean work;
    private MainMenu menu;
    private Scanner scanner;
    private Presenter presenter;
    public ConsoleUI() {
        work = true;
        menu = new MainMenu(this);
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        System.out.println("Привет! Я помогу тебе составить семейное древо!");
        while (work) {
            System.out.println(menu.menu());
            String choice = scanner.nextLine();
            int choiceInt = Integer.parseInt(choice);
            menu.execute(choiceInt);
        }
    }
    public void finish() {
        scanner.close();
        work = false;
    }
    public void addHuman() {
        Human human = createHuman();
        presenter.addHuman(human);
    }
    public Human createHuman(){
        System.out.println("Введите имя человека");
        String name = scanner.nextLine();
        System.out.println("Введите дату рождения человека в формате ДД_ММ_ГГ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd_MM_yyyy");
        LocalDate birthday = LocalDate.parse(scanner.nextLine(), formatter);
        System.out.println("Введите пол в формате Male или Female");
        Gender gender = Gender.valueOf(scanner.nextLine());

        return new Human(name, birthday, gender);
    }
    public void SortByName(){
        presenter.SortByName();
    }
    public void SortByAge(){
        presenter.SortByAge();
    }
    public void getInfo(){
        presenter.getInfo();
    }
    public void setConnection() {
        Human child = createHuman();
        Human parent = createHuman();
        presenter.setConnection(child, parent);
    }
    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }
}
