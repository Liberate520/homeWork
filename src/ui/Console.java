package ui;

import model.human.Human;
import presenter.Presenter;

import java.io.IOException;
import java.util.Scanner;

public class Console implements View {

    private Presenter presenter;//куда отправлять информацию
    private Scanner scanner;
    private boolean work;
    private Menu menu;


    public Console() {
        scanner = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }



    @Override
    public void start() {
        while (work) {
            System.out.println(menu.print());
            int choice = Integer.parseInt(scan());
            menu.execute(choice);
        }
    }
    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }
    public Presenter getPresenter() {
        return presenter;
    }



    private  boolean check(String text){
        return text.matches("[0-9]+");//Метод проверки что введено именно целое число из [0-9]
    }

    private String scan() {

        return scanner.nextLine();
    }

    private String scanName() {
        System.out.println("Введите имя: ");
        return scanner.nextLine();
    }

    private String scanFamily() {
        System.out.println("Введите фамилию: ");
        return scanner.nextLine();
    }

    @Override
    public void printHuman(Human human) {

        System.out.println(human);
    }

    @Override
    public void addHuman(){
        String name = scanName();
        String family = scanFamily();
        presenter.addHuman(family,name);
    }
    public void finish(){

        work = false;
    }
    @Override
    public void printTree() {
        System.out.println(presenter.getTree().getInfo());
    }


    public void searchHuman() {
        String name = scanName();
        String family = scanFamily();
        System.out.println(presenter.searchHuman(family,name));
    }

    @Override
    public void searchChild() {
        String name = scanName();
        String family = scanFamily();
        System.out.println(presenter.searchChild(family,name));
    }
    @Override
    public void save() {
        System.out.println(presenter.save());
    }

    @Override
    public void printFile() {
        System.out.println(presenter.printFile());
    }

}
