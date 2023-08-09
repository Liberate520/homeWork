package ru.gb.view;


import ru.gb.model.data.Gender;
import ru.gb.model.human.Human;
import ru.gb.presenter.Presenter;

import java.io.IOException;
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
    public void start() throws IOException, ClassNotFoundException {
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
        Human human = presenter.createHuman(scanner);
        presenter.addHuman(human);
    }
    public void sortByName(){
        presenter.sortByName();
    }
    public void sortByAge(){
        presenter.sortByAge();
    }
    public void getInfo(){
        presenter.getInfo();
    }
    public void setConnection() {
        presenter.setConnection(scanner);
    }
    @Override
    public void printAnswer(String answer) {
        System.out.println(answer);
    }

    public void save() throws IOException {
        presenter.save();
    }
    public void load() throws IOException, ClassNotFoundException {
        presenter.load();
    }
}
