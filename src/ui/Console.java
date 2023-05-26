package ui;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private boolean work = true;
    private MainMenu mainMenu;

    public Console(){
        mainMenu = new MainMenu(this);
        scanner = new Scanner(System.in);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        System.out.println("Добрый день!");
        while (work) {
            System.out.println(mainMenu.print());
            String line = scanner.nextLine();
            int numComand = Integer.parseInt(line);
            mainMenu.execute(numComand);
        }
    }
    public void finish(){
        work = false;
    }
    public void getInfo(){
        presenter.getInfo();
    }
    public void addHuman(){
        System.out.println("Введите Имя");
        String firstName = scanner.nextLine();
        System.out.println("Введите Фамилию");
        String lastName = scanner.nextLine();
        System.out.println("Введите возраст");
        int age = Integer.parseInt(scanner.nextLine());
        presenter.addHuman(firstName,lastName,age);
    }

    public void sortByName(){
        presenter.sortByName();
    }
    public void sortByAge(){
        presenter.sortByAge();
    }



    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
