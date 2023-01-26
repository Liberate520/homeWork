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

        ViewCurrentCommand viewCurrentCommand = new ViewCurrentCommand(this, "Choose family tree");
        commandList.add(viewCurrentCommand);

        List<String>  treeNames = presenter.onGetTreeNames();
        for (int i = 0; i < treeNames.size(); i++)
            new ChooseCommand(viewCurrentCommand, this, treeNames.get(i), String.format("%d", i + 1), i);

        Command viewCommand = new Command(this, "View family tree");
        commandList.add(viewCommand);
        new ViewCommand(viewCommand,this, "sort by id", "20", 0);
        new ViewCommand(viewCommand, this, "sort by member name", "21", 1);
        new ViewCommand(viewCommand, this, "sort by children count desc", "22", 2);

        commandList.add(new FindCommand(this, "Find in family tree", "30"));

        List<String> writerDescriptions = presenter.onGetWriterDescriptions();

        Command saveCommand = new Command(this, "Save family tree");
        commandList.add(saveCommand);

        for (int i = 0; i < writerDescriptions.size(); i++)
        {
            String descr = writerDescriptions.get(i);
            int fileType = presenter.onGetFileType(i);
            new SaveCommand(saveCommand, this, "to " + descr, String.format("%d", 40 + fileType), fileType);
        }

        Command loadCommand = new Command(this, "Load family tree");
        commandList.add(loadCommand);

        for (int i = 0; i < writerDescriptions.size(); i++)
        {
            String descr = writerDescriptions.get(i);
            int fileType = presenter.onGetFileType(i);
            new LoadCommand(loadCommand, this, "from " + descr, String.format("%d", 50 + fileType) , fileType);
        }

        commandList.add(new ExitCommand(this, "Exit", "0"));
    }

    private void menu() {
        print("-----------------------------------------");
        for (int i = 0; i < commandList.size(); i++)
            print(commandList.get(i).description());
        print("-----------------------------------------");
        print("Input your choice: ");
    }

    private void scan() {
        while (continueRun) {
            menu();

            String menuChoice = scanner.nextLine();

            boolean findCommand = false;
            for (int i = 0; i < commandList.size(); i++) {
                if (commandList.get(i).execute(menuChoice)) {
                    findCommand = true;
                    break;
                }
            }
            if (!findCommand) print("Incorrect input");
        }
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    public String getAnswer(String text) {
        print(text);
        return scanner.nextLine();
    }
}