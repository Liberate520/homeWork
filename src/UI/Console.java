package UI;

import presenter.Presenter;

import java.util.Scanner;


public class Console implements View {
    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;

    public Console() {
        scanner = new Scanner(System.in);
    }

    @Override
    public void start() {
        menu = new Menu(this);
        work = true;
        while (work) {
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            if (check(choice)) {
                menu.doit(Integer.parseInt(choice));
            } else {
                fail();
            }
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    private void fail() {
        System.out.println("Неверный ввод.");
    }

    private boolean check(String choice) {
        return choice.matches("[0-9]+") &&
                Integer.parseInt(choice) <= menu.getSize() &&
                Integer.parseInt(choice) > 0;
    }

    @Override
    public void addElement() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Год рождения");
        int birthday = scanner.nextInt();
        System.out.println("Год смерти или 0");
        int deathDay = scanner.nextInt();
        presenter.addTreeElement(name, birthday, deathDay);
    }

    @Override
    public void findElement() {
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        presenter.findTreeElement(name);
    }

    public void getElementList() {
        presenter.getTreeElementList();
    }

    public void finish() {
        System.out.println("До свидания.");
        work = false;
    }
    public void sort(){
        presenter.sort();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
