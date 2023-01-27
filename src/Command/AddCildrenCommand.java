package Command;

import AddCildren.AddChildrenScanner;
import AddCildren.IAddCildren;

public class AddCildrenCommand implements ICommand{

    @Override
    public void execute() {
        IAddCildren iAddCildren = new AddChildrenScanner();
        iAddCildren.addCildren();

    }
}
