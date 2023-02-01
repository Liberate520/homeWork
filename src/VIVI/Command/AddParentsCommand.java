package VIVI.Command;

import VIVI.AddParents.AddParentsJOptionPane;
import VIVI.AddParents.IAddParents;

public class AddParentsCommand implements ICommand{
    @Override
    public void execute() {
        IAddParents iAddParents = new AddParentsJOptionPane();
        iAddParents.addParents();
    }
}
