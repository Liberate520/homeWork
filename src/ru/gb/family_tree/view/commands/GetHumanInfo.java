package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetHumanInfo extends Command{

    public GetHumanInfo(ConsoleUI consoleUI){
        super(consoleUI,"Получить список");

    }

    public void execute() {
        consoleUI.getHumanInfo();
    }
}
