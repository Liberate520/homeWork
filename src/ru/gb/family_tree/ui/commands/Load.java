package ru.gb.family_tree.ui.commands;

import ru.gb.family_tree.ui.ConsoleUI;

public class Load extends Command {

    public Load(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить из файла";
    }

    public void execute(){
        consoleUI.load();
    }
}
