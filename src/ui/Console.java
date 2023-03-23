package ui;

import java.util.ArrayList;
import java.util.Scanner;
import presenter.Presenter;

public class Console implements View {
    
    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;
    private ArrayList<String> member;
    private String name, fileName;

    public void hello() {
        System.out.println(menu.printMune());
    }

    public void finish() {
        work = false;
    }

    public void addMember(){
        member = new ArrayList<>();
        System.out.print("Введите имя нового члена семьи:");
        member.add(scanner.nextLine());
        System.out.println();
        System.out.print("Введите пол:");
        member.add(scanner.nextLine());
        System.out.println();
        System.out.print("Введите день рождения:");
        member.add(scanner.nextLine());
        System.out.println();
        System.out.print("Введите месяц рождения:");
        member.add(scanner.nextLine());
        System.out.println();
        System.out.print("Введите год рождения:");
        member.add(scanner.nextLine());
        System.out.println();
        presenter.addMember(member);
    }

    public void printMember() {
        System.out.print("Введите имя:");
        name = scanner.nextLine();
        System.out.println();
        presenter.printMember(name);
    }

    public void printTree() {
        presenter.printTree();
    }

    public void addParents() {
        member = new ArrayList<>();
        System.out.print("Введите ребенка:");
        member.add(scanner.nextLine());
        System.out.println();
        System.out.print("Введите имя отца:");
        member.add(scanner.nextLine());
        System.out.println();
        System.out.print("Введите имя матери:");
        member.add(scanner.nextLine());
        System.out.println();
        presenter.addParents(member);
    }

    public void save() {
        presenter.save();
    }

    public void open() {
        presenter.open();
    }

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work) {
            hello();
            menu.execute(Integer.parseInt(scanner.nextLine()));
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
