package ru.gb.Tree.View.Commands;

import ru.gb.Tree.View.ConsoleUI;

public class GetSavedFile extends Command{


    public GetSavedFile(ConsoleUI consoleUI) {
        super(consoleUI, "Показать семейное дерево");
    }
    public void execute(){
        consoleUI.getSavedFileUI();
    }
}

