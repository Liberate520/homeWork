package view.menu;

import view.Console;

public class ShowList implements Command{
    public Console console;

    public ShowList(Console console) {
        this.console = console;
    }

    @Override
    public String getDescription() {
        return "Вывести всех людей в дереве";
    }

    @Override
    public void execute() {
        console.ShowList();
    }
}
