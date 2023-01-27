package Command;

import AddParents.AddParentsScanner;
import AddParents.IAddParents;

public class addParentsCommand implements ICommand{
    @Override
    public void execute() {
        IAddParents iAddParents = new AddParentsScanner();
        iAddParents.addParents();
    }
}
