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
    @Override
    public void getElementList() {
        presenter.getTreeElementList();
    }

    @Override
    public void addChildren() {
        System.out.println("Введите имя родителя.");
        String parent = scanner.nextLine();
        System.out.println("Введите имя потомка.");
        String child = scanner.nextLine();
        presenter.addChildren(parent,child);
    }
    @Override
    public void setFather(){
        System.out.println("Введите имя потомка.");
        String child = scanner.nextLine();
        System.out.println("Введите имя родителя.");
        String parent = scanner.nextLine();
        presenter.setFather(child, parent);
    }
    @Override
    public void setMother(){
        System.out.println("Введите имя потомка.");
        String child = scanner.nextLine();
        System.out.println("Введите имя родителя.");
        String parent = scanner.nextLine();
        presenter.setMother(child, parent);
    }

    @Override
    public void loadFrom() {
        System.out.println("Введите имя файла");
        String fileName = scanner.nextLine();
        presenter.load(fileName);
    }

    @Override
    public void saveTo() {
        System.out.println("Введите имя файла.");
        String fileName = scanner.nextLine();
        presenter.save(fileName);
    }

    @Override
    public void finish() {
        System.out.println("До свидания.");
        work = false;
    }
    @Override
    public void sort(){
        presenter.sort();
    }
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

}
