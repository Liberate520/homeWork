package ru.gb.fam_tree.view.comands;

import ru.gb.fam_tree.view.ConsoleUI;

public class SaveToFile extends Command{
    public SaveToFile(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Save family tree to file";
    }
    @Override
    public void execute() {
        consoleUI.saveToFile();
    }
}
