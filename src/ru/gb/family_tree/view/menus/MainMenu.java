package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.console_ui.ConsoleUI;
import ru.gb.family_tree.view.commands.*;

public class MainMenu extends Menu {

    public MainMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new AddMember(consoleUI));
        commandList.add(new GetMembers(consoleUI));
        commandList.add(new SortByName(consoleUI));
        commandList.add(new SortByBirthDate(consoleUI));
        commandList.add(new ExportTree(consoleUI));
        if (checkPreviousMenu()) commandList.add(new Back(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
