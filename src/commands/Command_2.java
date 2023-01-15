package homeWork.src.commands;

import homeWork.src.Human;
import homeWork.src.ui.ConsoleUI;
/*
добавить нового члена семьи
 */

public class Command_2 implements Commands {
    ConsoleUI consoleUI;

    public Command_2(ConsoleUI consoleUI) {
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
