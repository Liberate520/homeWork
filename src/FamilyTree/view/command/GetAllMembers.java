package FamilyTree.view.command;

import FamilyTree.view.ConsoleUI;

public class GetAllMembers implements Command{
    private ConsoleUI consoleUI;
    public GetAllMembers(ConsoleUI consoleUI){
        this.consoleUI = consoleUI;
    }
    @Override
    public String getDescription() {
        return "Показать все дерево";
    }
    @Override
    public void execute() {
        consoleUI.getHumanList();
    }
}
