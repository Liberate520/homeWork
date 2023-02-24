package ui;
import presenter.Presenter;
import java.util.Scanner;

public class ConsoleUI implements View{
    private Scanner scanner;
    private Presenter presenter;
    private Menu menu;
    private boolean work;
    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu();
        hello();
        work = true;
        while (work){

        }
//        scan();
//       presenter.onClick();
    }
    private void hello() {
        System.out.println(menu.printMenu());
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }
    public void finish(){
        work = false;
    }
    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }
}
