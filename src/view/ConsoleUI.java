package view;

import command.*;
import presenter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI implements View {

    private Presenter presenter;
    private Scanner scanner;
    private boolean continueRun = true;
    List<Command> commandList = new ArrayList<>();

    public ConsoleUI() {
        scanner = new Scanner(System.in);
    }

    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void setPresenter(Presenter presenter){
        this.presenter = presenter;
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setContinueRun(boolean continueRun) {
        this.continueRun = continueRun;
    }

    @Override
    public void start() {
        createMenu();
        scan();
    }

    private void createMenu() {
        commandList.add(new Command(this, "-----------------------------------------"));
        commandList.add(new Command(this, "Choose family tree"));

        List<String>  treeNames = presenter.onGetTreeNames();
        for (int i = 0; i < treeNames.size(); i++)
            commandList.add(new ChooseCommand(this, treeNames.get(i), String.format("%d", i + 1) , 1,  i));

        commandList.add(new Command(this, "View family tree"));
        commandList.add(new ViewCommand(this, "sort by id", "20", 1, 0));
        commandList.add(new ViewCommand(this, "sort by member name", "21", 1, 1));
        commandList.add(new ViewCommand(this, "sort by children count desc", "22", 1, 2));

        commandList.add(new FindCommand(this, "Find in family tree", "30"));

        commandList.add(new Command(this, "Save family tree"));
        commandList.add(new SaveCommand(this, "to text file", "40", 1, 0));
        commandList.add(new SaveCommand(this, "to binary file", "41", 1, 1));

        commandList.add(new Command(this, "Load family tree"));
        commandList.add(new LoadCommand(this, "from text file", "50", 1, 0));
        commandList.add(new LoadCommand(this, "from binary file", "51", 1, 1));

        commandList.add(new ExitCommand(this, "Exit", "0"));

        commandList.add(new Command(this, "-----------------------------------------"));
        commandList.add(new Command(this, "Input your choice: "));
    }

    private void menu() {
        for (int i = 0; i < commandList.size(); i++)
            print(commandList.get(i).description());
    }

    private void scan() {
        while (continueRun) {
            menu();

            String menuChoice = scanner.nextLine();

            boolean findCommand = false;
            for (int i = 0; i < commandList.size(); i++) {

                Command command = commandList.get(i);
                if (menuChoice.equals(command.getCode())) {
                    command.execute();
                    findCommand = true;
                }
            }
            if (!findCommand) print("Incorrect input");
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

}