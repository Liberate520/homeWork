package UI;

import Presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }
    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }
    @Override
    public  void start(){

        int number = scan();
        presenter.choseNumber(number);
    }
    private Integer scan(){
        System.out.println("Chose number: 1 - show all, 2 - find member, 3 - finish");
        return scanner.nextInt();
    }
    @Override
    public String getName(){
        System.out.println("Enter name of person");
        return scanner.nextLine();
    }
    @Override
    public void print(String text){
        System.out.println(text);
    }
}
