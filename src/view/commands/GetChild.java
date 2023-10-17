package view.commands;

import view.ConsoleUI;

public class GetChild extends Command{
    public GetChild(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Добавить ребенка родителям";
    }

    public void execute(){
        consoleUI.getChild();
    }
}
