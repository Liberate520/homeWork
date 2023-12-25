package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.Console;

public class GetHumanList extends Command {
    public GetHumanList(Console console) {
        super("Family Tree Search", console);
    }

    public void execute() {
        getConsole().getFamilyTreeInfo();
    }
}
