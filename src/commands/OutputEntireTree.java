package commands;

import views.ConsoleInterface;

public class OutputEntireTree implements Option {

    ConsoleInterface consoleInterface;
    
    public OutputEntireTree(ConsoleInterface consoleInterface) {
        this.consoleInterface = consoleInterface;
    }

    @Override
    public void execute() {
        this.consoleInterface.outputEntireTree();
    }

    @Override
    public String description() {
        return "Вывести все дерево";
    } 
}
