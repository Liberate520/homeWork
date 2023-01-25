package commands;

import views.ConsoleInterface;

public class AddFatherToHuman implements Option {

    ConsoleInterface consoleInterface;

    public AddFatherToHuman(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }
    
    @Override
    public void execute() {
        consoleInterface.addFatherToHuman();
    }

    @Override
    public String description() {
        return "Добавить отца человеку";
    }
    
}
