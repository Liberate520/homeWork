package ru.gb.family_tree.family_tree.view.commands;

import ru.gb.family_tree.family_tree.view.ConsoleUI;

public class loadTreeFromFile extends Command{
    public loadTreeFromFile(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Загрузить древо из файла";
    }

    public void execute(){
        consoleUI.loadTreeFromFile();
        System.out.println("Древо загружено");
    }
}
