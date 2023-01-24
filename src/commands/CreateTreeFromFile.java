package commands;

import views.ConsoleInterface;

public class CreateTreeFromFile implements Option {

    ConsoleInterface consoleInterface;
    
    public CreateTreeFromFile(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }

    @Override
    public void execute() {
        this.consoleInterface.createTreeFromFile();
    }

    @Override
    public String description() {
        return "Создать дерево из файла"; 
    }
}
