package ui.command;

import presenter.Presenter;

import java.util.Scanner;

public abstract class Command {
    protected final String name;

    protected final Presenter presenter;
    protected final Scanner scanner;

    protected Command(String name, Presenter p, Scanner s) {
        this.name = name;
        this.presenter = p;
        this.scanner = s;
    }

    public String getName() {
        return name;
    }


    public abstract void execute();
}
