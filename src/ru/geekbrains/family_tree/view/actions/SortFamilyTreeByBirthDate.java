package ru.geekbrains.family_tree.view.actions;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Сортировка семейного древа по дате рождения в порядке возрастания.
 */
public class SortFamilyTreeByBirthDate extends Action {
    
    public SortFamilyTreeByBirthDate(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        name = "sort by age";
        description = "для сортировки по возрасту";
    }

    public void perform() {
        consoleUserInterface.sortFamilyTreeByBirthDate();
    }

}
