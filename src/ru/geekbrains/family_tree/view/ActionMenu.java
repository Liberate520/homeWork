package ru.geekbrains.family_tree.view;

import java.util.ArrayList;
import java.util.Arrays;

import ru.geekbrains.family_tree.view.actions.*;

/**
 * Меню действий.
 */
public class ActionMenu {

    private ArrayList<Action> actions;

    public ActionMenu(ConsoleUserInterface consoleUserInterface) {
        actions = new ArrayList<>(Arrays.asList(new PrintFamilyTree(consoleUserInterface),
                                                new AddFamilyMember(consoleUserInterface),
                                                new SortFamilyTreeByName(consoleUserInterface),
                                                new SortFamilyTreeByBirthDate(consoleUserInterface),
                                                new ReadFamilyTreeFromFile(consoleUserInterface),
                                                new WriteFamilyTreeToFile(consoleUserInterface),
                                                new Exit(consoleUserInterface)));
    }
    
    /**
     * Возвращает строковое представление меню действий в формате "'действие'
     * описание действия".
     */
    public String getActions() {
        StringBuilder userActions = new StringBuilder();
        for (Action action : actions) {
            userActions.append(String.format("'%s' %s\n", action.getName(),
                                                                 action.getDescription()));
        }
        return userActions.toString();
    }

    /**
     * Выполняет действие и возвращает true или возвращает false, если действие
     * отсутствует в меню действий.
     */
    public boolean performAction(String userAction) {
        for (Action action : actions) {
            if (action.getName().equals(userAction)) {
                action.perform();
                return true;
            }
        }
        return false;
    }
    
}
