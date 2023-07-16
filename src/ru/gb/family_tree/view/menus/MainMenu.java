package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.ConsoleUI;
import ru.gb.family_tree.view.commands.*;

public class MainMenu extends Menu {

    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new AddMember(consoleUI));
        commandList.add(new GetMembers(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByBirthDate(consoleUI));
        if (checkPreviousMenu()) commandList.add(new Back(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
