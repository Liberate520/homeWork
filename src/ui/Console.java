package ui;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View {
    private final Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private final Menu menu;

    public Console() {
        this.scanner = new Scanner(System.in);
        this.work = true;
        this.menu = new Menu(this);
    }

    @Override
    public void start() {
        while (work){
           menu.printMenu();
           if(checkInt(scan())){
               int choice = Integer.parseInt(scan());
           }else{
               System.out.println("Введено некорректное значение. Попробуйте еще раз.");
           }
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

    private boolean checkInt(String text) {
       return text.matches("[0-9]+");
    }

    public Presenter getPresenter() {
        return presenter;
    }

    private String scan() {
        return scanner.nextLine();
    }

    public void addUnit(){
//        System.out.println("Введите имя");
//        String name = scanner.nextLine();
//        presenter.addUnit(name);
    }
    public void getUnitInfo(){
        System.out.println("Введите через пробел Имя Отчество Фамилия:");
        String fullName = scanner.nextLine();
        presenter.getUnitInfo(fullName);
    }
    public void getTree(){

    }
    public void finish(){
        this.work = false;
    }
}
