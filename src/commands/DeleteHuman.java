package commands;

import views.ConsoleInterface;

public class DeleteHuman implements Option {

    ConsoleInterface consoleInterface;
    
    public DeleteHuman(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }

    @Override
    public void execute() {
        this.consoleInterface.deleteHuman();
    }

    @Override
    public String description() {
        return "Удалить человека";
    }
}
