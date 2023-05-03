package Package.View;

import Package.Presenter.Presenter;

import java.util.Scanner;

public class Console implements View{
    private Presenter presenter;
    private Scanner sc;
    private boolean work;
    private Menu menu;

    public Console() {
        this.sc = new Scanner(System.in);
        this.work = true;
        this.menu = new Menu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work){
            System.out.println(menu.print());
            String choice = sc.nextLine();
            if (check(choice)){
                menu.execute(Integer.parseInt(choice));
            } else{
                fail();
            }
        }
    }

    private boolean check(String text){
        return (text.matches("[0-9]+") && Integer.parseInt(text) <= menu.getSize() && Integer.parseInt(text) > 0);
    }

    public void showTree(){
        presenter.showTree();
    }

    public void addPerson(){
        presenter.addPerson();
    }

    public void deletePerson(){
        presenter.deletePerson();
    }

    public void exit(){
        presenter.exit();
    }

    public void fail(){
        System.out.println("Неверный ввод!");
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
