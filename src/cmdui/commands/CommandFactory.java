package cmdui.commands;

import familytree.FamilyTree;
import familytree.FamilyTreeMemeber;

public class CommandFactory implements ICommandFactory {
    private FamilyTree<FamilyTreeMemeber> familyTree;

    public CommandFactory(FamilyTree<FamilyTreeMemeber> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public ICommand commGet() {
        return new Get(familyTree);
    }
}
