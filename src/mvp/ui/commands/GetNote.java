package mvp.ui.commands;

import mvp.ui.ConsoleUI;

public class GetNote implements Command{
    
    private ConsoleUI consoleUI;

    public GetNote(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public String getDescription() {
        return "Получение члена семьи и его данных";
    }

    @Override
    public void execute() {
        consoleUI.getNote();
    }
}
