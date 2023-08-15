package ru.geekbrains.family_tree.view.actions;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Чтение семейного древа из файла.
 */
public class ReadFamilyTreeFromFile extends Action {
    
    public ReadFamilyTreeFromFile(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        name = "read";
        description = "для чтения семейного древа из файла";
    }

    public void perform() {
        consoleUserInterface.readFamilyTreeFromFile();
    }

}
