package view.commands;

import view.ConsoleUI;

import java.util.ArrayList;
import java.util.List;

public class CommandsList {
    private List<Command> comandsList;

    public CommandsList(ConsoleUI consoleUI) {
        this.comandsList = new ArrayList<>();
        comandsList.add(new AddTreeItem(consoleUI));
        comandsList.add(new GetById(consoleUI));
        comandsList.add(new GetHumanListInfo(consoleUI));
        comandsList.add(new Remove(consoleUI));
        comandsList.add(new Finish(consoleUI));
    }

    public List<Command> getComandsList() {
        return comandsList;
    }
}
