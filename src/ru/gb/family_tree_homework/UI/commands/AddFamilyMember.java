package ru.gb.family_tree_homework.UI.commands;

import ru.gb.family_tree_homework.UI.ConsoleUI;

public class AddFamilyMember extends Command{
    public AddFamilyMember(ConsoleUI consoleUI){
        super("Add family member", consoleUI);
    }
    @Override
    public void execute() {
        getConsoleUI().addFamilyMember();
    }
}
