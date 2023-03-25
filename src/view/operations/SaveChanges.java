package view.operations;


import view.ConsoleUI;

public class SaveChanges extends ViewTasker {
    public SaveChanges(ConsoleUI consoleUI) {
        super(consoleUI);
    }

    @Override
    public String optionName() {
        return "Сохранить изменения      ";
    }

    @Override
    public void execute() {
        getConsole().save();
    }
}