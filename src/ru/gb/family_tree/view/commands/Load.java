package ru.gb.family_tree.view.commands;

import ru.gb.family_tree.view.ConsoleUI;

public class Load extends Command {

    public Load(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить из файла";
    }

    public void execute(){
        consoleUI.load();
    }
}
