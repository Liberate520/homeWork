package src.UI;

import src.FamilyTree.FamilyTree;
import src.Presenter.Presenter;

import java.util.Scanner;

public class Console implements View{
    private Scanner scanner;
    private Presenter presenter;
    private FamilyTree family;
    private Menu menu;
    private boolean work;
    private static Integer actionNumber;


    @Override
    public void start() {
        System.out.println("\nStart");
        Scanner scanner = new Scanner(System.in);
        menu = new Menu(this);
        work = true;
        while(work){
            comandList();
            String command = scanner.nextLine();
            if (checkInput(command)){
                menu.execute(Integer.parseInt(command));
            } else {
                System.out.println("что-то пошло не так");
            }
        }


    }
    public void comandList(){
        System.out.println(menu.printMenu());
    }

    private boolean checkInput(String text){
        return text.matches("[0-9]+");
    }
    @Override
    public void print(String text){
        System.out.println(text);
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
