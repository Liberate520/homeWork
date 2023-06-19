package view.commands;

import view.ConsoleUI;

public class AddNewMember implements Command {
    private final ConsoleUI ui;
    public AddNewMember(ConsoleUI ui){
        this.ui = ui;
    }

    @Override
    public String getDescription() {
        return "Добавить нового члена семьи";
    }

    @Override
    public void execute() {
        ui.addNewMember();
    }
}
