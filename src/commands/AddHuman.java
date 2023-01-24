package commands;

import views.ConsoleInterface;

public class AddHuman implements Option {

    ConsoleInterface consoleInterface;

    public AddHuman(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }

    @Override
    public void execute() {
        consoleInterface.addHuman();
    }

    @Override
    public String description() {
        return "Добавить человека";  
    }
}
