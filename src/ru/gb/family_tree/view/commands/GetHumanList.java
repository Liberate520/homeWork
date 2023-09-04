package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class GetHumanList extends Command{

    public GetHumanList(ConsoleUI console) {
        super(console);
        description = "Получить список людей";
    }

    public void execute() {
        consoleUI.getHumanList();
    }

}
