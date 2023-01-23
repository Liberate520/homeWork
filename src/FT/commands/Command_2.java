package FT.commands;

import FT.Human;
import FT.UI.ConsoleUI;

public class Command_2 implements Commands {
    ConsoleUI consoleUI;

    public Command_2(ConsoleUI consoleUI) {
        this.consoleUI = consoleUI;
    }

    @Override
    public void execute() {
        Human human = consoleUI.getHuman(consoleUI.getFamilyTree());
        consoleUI.getPresenter().addNewMember(human);
    }

    @Override
    public String description() {
        return "добавить нового члена семьи";
    }
}
