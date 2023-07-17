package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetInfo extends Command{
    public GetInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Посмотреть семейное дерево";
    }

    @Override
    public void execute() {
        consoleUI.getInfo();
    }
}
