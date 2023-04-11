package ui;

import presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{

    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }

    private String scan(){
        return scanner.nextLine();
    }

    @Override
    public void start() {
        while (work) {
            menu.print();
            int choice = Integer.parseInt(scan()); // добавить проверки, чтобы не упало приложение?!
            menu.execute(choice);
        }

    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }
    public void getAllMembers() {

    }

    public void addMember(){
        System.out.println("Введите имя: ");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию: ");
        String surname = scanner.nextLine();
        System.out.println("Введите дату рождения в формате ДД.ММ.ГГГГ: ");
        String dateBirth = scanner.nextLine();
    }

    public void removeMember(){}


    public void searchMember(){}


    public void finish() {work = false;}
}
