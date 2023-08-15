package ru.geekbrains.family_tree.view.actions;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Запись семейного древа в файл.
 */
public class WriteFamilyTreeToFile extends Action {
    
    public WriteFamilyTreeToFile(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        name = "write";
        description = "для записи семейного древа в файл";
    }

    public void perform() {
        consoleUserInterface.writeFamilyTreeToFile();
    }

}
