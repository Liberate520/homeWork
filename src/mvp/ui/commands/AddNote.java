package mvp.ui.commands;

import mvp.ui.ConsoleUI;

public class AddNote implements Command {

    private ConsoleUI consoleUI;

    public AddNote(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Добавление члена семьи и его данных";
    }

    @Override
    public void execute() {
        consoleUI.addNote();
    }
}
