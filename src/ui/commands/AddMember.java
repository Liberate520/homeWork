package ui.commands;

import ui.Console;

import javax.swing.text.View;

public class AddMember extends Command {
    
    public AddMember(Console console) {
        super(console);
    }

    @Override
    public String description() {
        return "Добавить нового члена семьи";
    }

    @Override
    public void execute() {
        getConsole().addMember();
    }
}
