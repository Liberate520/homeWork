package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class GetHumansInfo extends Command {
    public GetHumansInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Get information about family tree";
    }
    @Override
    public void execute() {
        consoleUI.getHumansInfo();
    }
}
