package view;


import presenter.Presenter;
import view.commands.*;
import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private Presenter presenter;

    public UI(){
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
    }
    public void start(){
        CommandList commandList = new CommandList();
        while (true){
            int i = 0;
            for(Command command: commandList){
                System.out.println(++i + ". " + command.getDescription());
            }
            int choice = scanner.nextInt();
            commandList.commandList.get(choice-1).start(presenter);
        }
    }
    public void printAnswer(String answer){
        System.out.println(answer);
    } //TODO не понял зачем этот метод обязательный

}
