package commands;

import views.ConsoleInterface;

public class FindByFIO implements Option {

    ConsoleInterface consoleInterface;
    
    public FindByFIO(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }

    @Override
    public void execute() {
        this.consoleInterface.findByFIO();
    }

    @Override
    public String description() {
        return "Найти по ФИО";
    } 
}
