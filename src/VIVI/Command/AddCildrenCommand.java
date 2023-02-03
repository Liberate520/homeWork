package VIVI.Command;

import VIVI.AddCildren.AddChildrenJOptionPane;
import VIVI.AddCildren.IAddCildren;

public class AddCildrenCommand implements ICommand{

    @Override
    public void execute() {

        IAddCildren iAddCildren = new AddChildrenJOptionPane();
        iAddCildren.addCildren();

    }
}
