package ui.commands;

import ui.Console;

public class AddHuman extends Command {
    public AddHuman(Console console){
        super(console);
    }
    public String getDescription(){
        return "Добавить человека в дерево";
    }

    public void execute() {
        getConsole().addHuman();
    }
}
