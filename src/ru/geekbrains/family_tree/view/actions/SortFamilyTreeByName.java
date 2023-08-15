package ru.geekbrains.family_tree.view.actions;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Сортировка семейного древа по имени в порядке возрастания.
 */
public class SortFamilyTreeByName extends Action {
    
    public SortFamilyTreeByName(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        name = "sort by name";
        description = "для сортировки по имени";
    }

    public void perform() {
        consoleUserInterface.sortFamilyTreeByName();
    }

}
