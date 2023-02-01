package commands;

import views.ConsoleInterface;

public class AddSpouseToHuman implements Option {

    ConsoleInterface consoleInterface;

    public AddSpouseToHuman(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }
    
    @Override
    public void execute() {
        consoleInterface.addSpouseToHuman();
    }

    @Override
    public String description() {
        return "Добавить супруга/супругу человеку";
    }
}
