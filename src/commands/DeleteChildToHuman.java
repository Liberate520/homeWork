package commands;

import views.ConsoleInterface;

public class DeleteChildToHuman implements Option {
    ConsoleInterface consoleInterface;
    
    public DeleteChildToHuman(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }

    @Override
    public void execute() {
        this.consoleInterface.deleteChildToHuman();
    }

    @Override
    public String description() {
        return "Удалить ребенка человека";
    }
}
