package FT.commands;

import FT.Human;
import FT.UI.ConsoleUI;

public class AddNewHuman implements Commands {
    ConsoleUI consoleUI;

    public AddNewHuman(ConsoleUI consoleUI) {
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
