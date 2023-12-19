package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

public class GetFamilyTreeInfo extends Command{
    public GetFamilyTreeInfo(ConsoleUI consoleUI){
        super("Get family tree information", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().getFamilyTreeInfo();
    }
}
