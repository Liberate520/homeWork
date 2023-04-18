package view.commands;

import view.Console;

public class AddHuman extends Command {
    public AddHuman(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Добавить человека в дерево ";
    }

    @Override
    public void execute() {
        //getConsole().getTreeInfo();
        getConsole().addHuman();
    }
}
