package ru.gb.family_tree.ui.commands;

import ru.gb.family_tree.ui.ConsoleUI;

public class Save extends Command {

    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить в файл";
    }

    public void execute(){
        consoleUI.save();
    }
}
