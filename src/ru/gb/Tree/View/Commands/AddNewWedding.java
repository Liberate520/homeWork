package ru.gb.Tree.View.Commands;

import ru.gb.Tree.View.ConsoleUI;

public class AddNewWedding extends Command{


    public AddNewWedding(ConsoleUI consoleUI) {
        super(consoleUI, "Установить супружескую связь");
    }
    public void execute(){
        consoleUI.addNewWedding();
    }
}

