package UI.commands;


import UI.Console;

public class GetHumanList implements Command {
    private Console console;

    public GetHumanList(Console console) {
        this.console = console;
    }

    @Override
    public String description() {
        return "Вывести список всех людей в дереве";
    }

    @Override
    public void run() {
        console.getHumanList();
    }
}
