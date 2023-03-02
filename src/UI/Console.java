package src.UI;

import src.FamilyTree.FamilyTree;
import src.Presenter.Menu;
import src.Presenter.Presenter;

import java.util.Scanner;

public class Console implements View{
    private Scanner scanner;
    private Presenter presenter;
    private FamilyTree family;
    private Menu menu;
    private static Integer actionNumber;




    @Override
    public void setPresenter(Presenter presenter) {
            this.presenter = presenter;
    }

    @Override
    public void start() {
        System.out.println("\nStart");
        Scanner scanner = new Scanner(System.in);
        menu = new Menu(this);
//        family = new FamilyTree(this);
        System.out.println(menu.printMenu());
        System.out.println(family.sortByYearOfReigh());
    }

    @Override
    public void print(String text){
        System.out.println(text);
    }

}
