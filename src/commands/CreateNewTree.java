package commands;

import views.ConsoleInterface;

public class CreateNewTree implements Option {
    
    ConsoleInterface consoleInterface;
    
    public CreateNewTree(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }

    @Override
    public void execute() {
        this.consoleInterface.createNewTree();
    }

    @Override
    public String description() {
        return "Создать новое дерево";
    }
}
