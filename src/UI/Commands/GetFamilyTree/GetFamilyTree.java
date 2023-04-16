package UI.Commands.GetFamilyTree;

import UI.Commands.Command;
import UI.Console;

public class GetFamilyTree extends Command {
    public GetFamilyTree(Console console) {
        super(console);
    }

    @Override
    public String getDescription() {
        return "Посмотреть дерево";
    }

    @Override
    public void execute() {
        getConsole().getFamilyTree();
    }

}
