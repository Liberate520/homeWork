package classes.view.commands;

import classes.view.ConsoleUI;

public class GetListInfo extends Command{
    public GetListInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        String description = "Вывести фамильное древо";
    }

    public void execute(){
        consoleUI.GetTreeInfo();
    }
}

