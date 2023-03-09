package ui.menu.commands;

import ui.ConsoleOne;

public class AddTreeEntity extends Command {

    public AddTreeEntity(ConsoleOne console) {
        super(console);
    }

    @Override
    public String description() {
        return "Add Entity";
    }

    @Override
    public void execute() {
        getConsole().addTreeEntity();
    }

}
