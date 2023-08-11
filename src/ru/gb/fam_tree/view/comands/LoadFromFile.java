package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class LoadFromFile extends Command{
    public LoadFromFile(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Load family tree from file";
    }
    @Override
    public void execute() {
        consoleUI.loadFromFile();
    }
}
