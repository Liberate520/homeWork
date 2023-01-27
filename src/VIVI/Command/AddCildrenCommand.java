package VIVI.Command;

import VIVI.AddCildren.AddChildrenScanner;
import VIVI.AddCildren.IAddCildren;

public class AddCildrenCommand implements ICommand{

    @Override
    public void execute() {
        IAddCildren iAddCildren = new AddChildrenScanner();
        iAddCildren.addCildren();

    }
}
