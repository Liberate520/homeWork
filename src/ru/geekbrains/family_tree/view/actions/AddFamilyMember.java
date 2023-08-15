package ru.geekbrains.family_tree.view.actions;

import ru.geekbrains.family_tree.view.ConsoleUserInterface;

/**
 * Добавление члена семьи в семейное древо.
 */
public class AddFamilyMember extends Action {
    
    public AddFamilyMember(ConsoleUserInterface consoleUserInterface) {
        super(consoleUserInterface);
        name = "add";
        description = "для добавления члена семьи";
    }

    public void perform() {
        consoleUserInterface.addFamilyMember();
    }

}
