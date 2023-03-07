package ui;

import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class Console implements View{
    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;
    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() throws IOException, ClassNotFoundException {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while (work){
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)){
                menu.execute(Integer.parseInt(command));
            }else{
                System.out.println("Ошибка ввода команды");
            }
        }
    }
    @Override
    public void print(String text){
        System.out.println(text);
    }
    private void hello(){
        System.out.println(menu.printMenu());
    }
    private boolean checkInput(String text){
        return text.matches("[0-9]+");
    }
    public void finish() {
        work = false;
    }
    public void addRecord() {
        System.out.println("Добавление новой записи в древо: ");
        presenter.addRecord(scanner.nextLine());
    }

    public void wholeList() {
        presenter.wholeList();
    }
    public void search() {
        System.out.println("Поиск по династии: ");
        presenter.search(scanner.nextLine());
    }
    public void sorting() {
        presenter.sorting();
    }
    public void save() throws IOException {
        presenter.save();
    }
    public void read() throws IOException, ClassNotFoundException {
        presenter.read();
    }
}