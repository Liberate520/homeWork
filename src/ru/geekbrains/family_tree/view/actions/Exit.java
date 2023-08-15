package ru.geekbrains.family_tree.view.actions;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Завершение программы.
 */
public class Exit extends Action {

    public Exit(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        name = "exit";
        description = "для выхода из программы";
    }

    public void perform() {
        consoleUserInterface.exit();
    }
    
}
