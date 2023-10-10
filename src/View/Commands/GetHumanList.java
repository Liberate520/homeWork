package View.Commands;

import View.ConsoleUI;

public class GetHumanList extends Command{
    public GetHumanList(ConsoleUI consoleUI){
        super("Вывести дерево",consoleUI);
    }
    public void execute() {
        getConsoleUI().getHumanList();
    }
}
