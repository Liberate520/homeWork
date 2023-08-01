package family_tree.view;

import family_tree.model.human.Gender;
import family_tree.presenter.Presenter;

import java.time.LocalDate;
import java.util.Scanner;

import static family_tree.model.human.Gender.Male;

public class ConsoleUI implements View{
    private Presenter presenter;
    private Scanner scanner;

    public ConsoleUI() {
        presenter=new Presenter(this);
        scanner=new Scanner(System.in);
    }

    public void addHuman(){
        System.out.println("Укажите имя");
        String name =scanner.nextLine();
        presenter.addHuman(name, Male, LocalDate.of(1963,12,10));
    }

    @Override
    public void start() {
        addHuman();
    }

    @Override
    public void printAnswer(String text) {
        System.out.println(text);
    }
}
