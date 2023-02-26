package UserInterface;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View {
    private Scanner scanner = new Scanner(System.in);
    private Presenter presenter;
    private Menu menu;





    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void start() {

        menu = new Menu();
        hello();
        System.out.println("¬ведите командую...................");
//        scanner = new Scanner(System.in);
        Menu menu = new Menu();
        while (true){
            int n = scanner.nextInt();

            menu.getCommands(n - 1).execute();
            break;



        }

    }
    private void hello(){
        System.out.println(menu.printMenu());
    }


    @Override
    public void print(String text) {
        System.out.println(text);
    }
}
