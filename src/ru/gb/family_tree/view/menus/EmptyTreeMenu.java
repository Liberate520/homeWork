package ru.gb.family_tree.view.menus;

import ru.gb.family_tree.view.commands.Finish;
import ru.gb.family_tree.view.commands.ImportTree;
import ru.gb.family_tree.view.console_ui.ConsoleUI;

public class EmptyTreeMenu extends Menu {

    public EmptyTreeMenu(ConsoleUI consoleUI) {
        super(consoleUI);
        commandList.add(new ImportTree(consoleUI));
        commandList.add(new Finish(consoleUI));
    }
}
