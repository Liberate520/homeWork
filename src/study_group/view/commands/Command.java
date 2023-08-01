package study_group.view.commands;

import study_group.model.Service;
import study_group.presenter.Presenter;
import study_group.view.ConsoleUI;

public abstract class Command {
    private String description;
    private ConsoleUI consoleUI;

    public Command(String description, ConsoleUI consoleUI) {
        this.description = description;
        this.consoleUI = consoleUI;
    }
    public String getDescription() {
        return description;
    }
    public abstract void execute();

    protected ConsoleUI getConsoleUI() {
        return consoleUI;
    }
}
