package src.UI;

import src.Presenter.Presenter;

import java.util.Scanner;

public class Console implements View{

    private Scanner scanner= new Scanner(System.in);
    private Presenter presenter;
    private Menu menu;
    private boolean work;

    public Console() {
    }

    @Override
    public void start() {
        System.out.println("\nStart");
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
        scanner.close();
    }

    public void comandList(){
        System.out.println();
        System.out.println(menu.printMenu());
    }

    private boolean checkInput(String text){
        return text.matches("[0-9]+");
    }

    public void finish() {
        work = false;
    }

    public void printingListOfPersons(){
        presenter.printingListOfPersons();
    }

    public void yearsOfTheReignOfPersons(){
        presenter.yearsOfTheReignOfPersons();
    }

    public void getPersonByName(){
        print("Enter the Person's name: \n");
        presenter.getPersonByName(scanner.nextLine());
    }

    public void findSpouse(){
        print("Enter the Person's name: \n");
        presenter.findSpouse(scanner.nextLine());
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
