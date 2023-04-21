package view.commands;

import view.Console;

public class TreeView extends Command{
    
    
    
    public TreeView(Console console){
        super(console);
    }

    @Override
    public String description() {
        return "Все объекты семейного дерева ";
    }

    @Override
    public void execute() {
        System.out.println("Печатаю весь список объектов...");
        getConsole().treeView();
    }


    
}
