package mvp.ui.commands;

import mvp.ui.ConsoleUI;

public class GetAllNote implements Command{
    
    private ConsoleUI consoleUI;

    public GetAllNote(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получение всех родственников и их данных";
    }

    @Override
    public void execute() {
        consoleUI.getNote();
    }
}
