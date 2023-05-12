package ui;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View{
    private Presenter presenter;
    private Scanner scanner;
    private boolean work;
    private Menu menu;

    public Console() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
    }

    private void hello(){
        System.out.println("Доброго времени суток!");
    }

    @Override
    public void start() {
        hello();
        while (work) {
            showMenu();
            execute();
        }
    }

    private void showMenu(){
        menu.showMenu();
    }

    private void execute(){
        System.out.print("Введите номер команды: ");
        int commandNumber = Integer.parseInt(scanner.nextLine());
        menu.execute(commandNumber);
    }

    @Override
    public void addChild() {
        System.out.print("Введите имя родителя ребенка: ");
        String parentName = scanner.nextLine();
        System.out.print("Введите пол ребенка: ");
        String gender = scanner.nextLine();
        System.out.print("Введите имя ребенка: ");
        String childName = scanner.nextLine();
        presenter.addChild(parentName, gender, childName);
    }

    @Override
    public void addHuman() {
        System.out.print("Введите пол: ");
        String gender = scanner.nextLine();
        System.out.print("Введите имя: ");
        String firstName = scanner.nextLine();
        System.out.print("Введите фамилию: ");
        String lastName = scanner.nextLine();
        presenter.addHuman(gender, firstName, lastName);
    }

    @Override
    public void getMarried() {
        System.out.print("Введите имя первого партнера: ");
        String name1 = scanner.nextLine();
        System.out.print("Введите имя второго партнера: ");
        String name2 = scanner.nextLine();
        presenter.getMarried(name1, name2);

    }

    @Override
    public void finishWork() {
        System.out.println("Спасибо за работу! Досвидания.");
        work = false;
    }

    @Override
    public void getInfo() {
        System.out.println(presenter.getInfo());
    }

    @Override
    public void save() {
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        presenter.save(fileName + ".txt");
    }

    @Override
    public void upload() {
        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();
        presenter.upload(fileName);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
