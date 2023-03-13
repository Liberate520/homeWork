package cmdui.commands;

import familytree.FamilyTree;

public class CommandFactory implements ICommandFactory {
    private FamilyTree familyTree;

    public CommandFactory(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public ICommand commGet() {
        return new Get(familyTree);
    }
}
