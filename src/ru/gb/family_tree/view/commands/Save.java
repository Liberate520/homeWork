package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class Save extends Command {

    public Save(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Сохранить в файл";
    }

    public void execute(){
        consoleUI.save();
    }
}
