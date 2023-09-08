package ru.gb.Tree.View.Commands;

import ru.gb.Tree.View.ConsoleUI;

public class Finish extends Command{
    public Finish(ConsoleUI consoleUI) {
        super(consoleUI, "Завершить работу");
    }
    public void execute(){
        consoleUI.finish();
    }
}
