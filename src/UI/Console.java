package src.UI;

import src.FamilyTree.FTService;
import src.Presenter.Presenter;

import java.util.Scanner;

public class Console implements View{

    private Scanner scanner;
    private Presenter presenter;
    private FTService ftService;
    private Menu menu;
    private boolean work;

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

    public void finish() {
        work = false;
    }

    public void PrintingListOfPersons(){
        presenter.PrintingListOfPersons();
    }

    public void YearsOfTheReignOfPersons(){
        presenter.YearsOfTheReignOfPersons();
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public void print(String text){
        System.out.println(text);
    }

    public void load() {
        presenter.load();
    }
    public void save() {
        presenter.save();
    }
}
