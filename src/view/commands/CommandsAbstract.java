package view.commands;

import view.View;

import java.util.Scanner;

public abstract class CommandsAbstract implements Command{
    private String description;
    private View view;
    private Integer number;
    private Scanner scanner;

    public CommandsAbstract(View view, Integer number, String description) {
        this.description = description;
        this.view = view;
        this.number = number;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getDescription() {
        return this.number + ". " + this.description;
    }
    public Integer getNumber() {
        return this.number;
    }
    public View getView() {
        return this.view;
    }
    public Scanner getScanner() {return this.scanner;}
    public abstract void execute();
}
