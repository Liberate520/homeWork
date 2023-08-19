package view.commands;

import view.ConsoleUI;

public class GetTreeInfo extends Command{

    public GetTreeInfo(ConsoleUI consoleUI) {
        super("Получить содержимое древа", consoleUI);
    }

    @Override
    public void execute(){
        super.getConsoleUI().getTreeInfo();
    }
}
