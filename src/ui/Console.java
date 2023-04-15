package ui;

import presenter.Presenter;

import java.util.Scanner;

public class Console implements View{

    private Presenter presenter;
    private Scanner scanner;
    private Menu menu;
    private boolean work;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void start() {
        scanner = new Scanner(System.in);
        menu = new Menu(this);
        work =true;
        while (work){
            hello();
            String command = scanner.nextLine();
            if (checkInput(command)){
                menu.execute(Integer.parseInt(command));
            }else {
                System.out.println("Некорректные данные");
            }
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public boolean AddMemberToTree(){

        return false;
    }

    public void finish(){
        work = false;
    }

    private void hello(){
        System.out.println(menu.printMenu());
    }
    private boolean checkInput(String text){
        return text.matches("[0-9]+");
    }
}
