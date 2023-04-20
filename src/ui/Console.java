package ui;

import model.human.Human;
import presenter.Presenter;

import java.util.Scanner;

public class Console implements View {

    private Presenter presenter;//куда отправлять информацию
    private Scanner scannerName;// для работы с пользователем
    private Scanner scanner;
//    private Scanner scannerMenu;
//    private Scanner scannerFamily;
    private boolean work;
    private Menu menu;


    public Console() {
        scanner = new Scanner(System.in);
//        scannerName = new Scanner(System.in);
//        scannerFamily = new Scanner(System.in);
        work = true;
        menu = new Menu(this);
    }

    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }
    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void start() {
         while (work) {
             menu.print();
             int choice = Integer.parseInt(scan());
             menu.execute(choice);
        }
//        scannerMenu.close();
//        scannerName.close();
//        scannerFamily.close();



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
    public void print(Human human) {
        System.out.println(human);
    }

    @Override
    public void printTree() {
        System.out.println(presenter.getTree().getInfo());
    }

    public void addHuman(){
        System.out.println("Введите имя");
        String name = scanner.nextLine();
        System.out.println("Введите фамилию");
        String family = scanner.nextLine();
        presenter.addHuman(family,name);

    }
    public void finish(){
        work = false;
    }

    public void getHumanTree() {
        System.out.println(presenter.getTree());

    }

//    public void searchHuman() {
//        System.out.println(presenter.searchHuman());
//    }
}
