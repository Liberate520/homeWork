package commands;

import views.ConsoleInterface;

public class AddMotherToHuman implements Option {

    ConsoleInterface consoleInterface;

    public AddMotherToHuman(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }
    
    @Override
    public void execute() {
        consoleInterface.addMotherToHuman();
    }

    @Override
    public String description() {
        return "Добавить мать человеку";
    }
    
}
