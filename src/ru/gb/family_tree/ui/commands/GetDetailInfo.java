package ru.gb.family_tree.ui.commands;

import ru.gb.family_tree.ui.ConsoleUI;

public class GetDetailInfo extends Command {

    public GetDetailInfo(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Просмотреть подробную информацию по Id";
    }

    public void execute(){
        consoleUI.infoById();
    }
}
