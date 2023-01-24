package commands;

import views.ConsoleInterface;

public class OutoutHumanByUuid implements Option {

    ConsoleInterface consoleInterface;
    
    public OutoutHumanByUuid(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }

    @Override
    public void execute() {
        this.consoleInterface.outoutHumanByUuid();
    }

    @Override
    public String description() {
        return "Вывод человека по uidd";
    }
}
