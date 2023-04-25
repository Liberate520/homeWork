package ui.commands;

import ui.Console;

public class GetFamilyTree extends Command{
    public GetFamilyTree(Console console){
        super(console);
    }

    public String getDescription(){
        return "Открыть дерево";
    }

    @Override
    public void execute() {
        getConsole().getFamilyTree();
    }
}
