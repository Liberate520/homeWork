package homeWork.src.familyTree.commands;

import homeWork.src.familyTree.Human;
import homeWork.src.familyTree.ui.ConsoleUI;
/*
добавить нового члена семьи
 */

public class AddNewMember implements Commands {
    ConsoleUI consoleUI;

    public AddNewMember(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
//        получаем нового члена FamilyTree
        Human human = consoleUI.getHuman(consoleUI.getFamilyTree());
//        добавляем нового члена FamilyTree
        consoleUI.getPresenter().addNewMember(human);

    }

    @Override
    public String description() {
        return "добавить нового члена семьи";
    }
}
