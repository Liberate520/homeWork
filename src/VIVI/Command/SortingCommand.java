package VIVI.Command;

import VIVI.Sort.ISort;
import VIVI.Sort.SortByName;

public class SortingCommand implements ICommand {
    @Override
    public void execute() {
        ISort sort = new SortByName();
        sort.sort();

    }
}
