package commands;

import views.ConsoleInterface;

public class WriteTreeToFile implements Option {

    ConsoleInterface consoleInterface;
    
    public WriteTreeToFile(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }

    @Override
    public void execute() {
        consoleInterface.writeTreeToFile();
    }

    @Override
    public String description() {
        return "Записать дерево в файл"; 
    }
}
