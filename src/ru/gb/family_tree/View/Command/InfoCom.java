package ru.gb.family_tree.View.Command;

import ru.gb.family_tree.View.ConsoleUI;

public class InfoCom extends Command {



    public InfoCom(ConsoleUI consoleUI) {
        super(consoleUI, "Получить список дерева");
    }
    public  void execute(){
        getConsoleUI().info();
    }
}
