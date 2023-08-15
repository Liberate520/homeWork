package ru.geekbrains.family_tree.view.actions;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Вывод семейного древа.
 */
public class PrintFamilyTree extends Action {

    public PrintFamilyTree(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        name = "print";
        description = "для вывода семейного древа";
    }

    public void perform() {
        consoleUserInterface.printFamilyTree();
    }

}
