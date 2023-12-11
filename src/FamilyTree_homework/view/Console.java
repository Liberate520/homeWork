package FamilyTree_homework.view;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View {

    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;

    public Console() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work){
            System.out.println(menu.print());
            String choice = scanner.nextLine();
            menu.execute(choice);
        }
    }

//    public void addHuman(){
//        getHumanList();
//        System.out.println("Введите имя человека");
//        String name = scanner.nextLine();
//        presenter.addHuman(name);
//    }

    public void getHumanList(){
        presenter.getHumanList();
    }
}
