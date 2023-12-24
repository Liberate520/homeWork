package ru.gb.family_tree.family_tree.view.commands;

import ru.gb.family_tree.family_tree.view.ConsoleUI;

public class finish extends Command {
    public finish(ConsoleUI consoleUI) {
        super(consoleUI);
        description = "Закончить работу";
    }

    public void execute(){
        System.out.println("Закрытие программы");
        consoleUI.finish();
    }
}
