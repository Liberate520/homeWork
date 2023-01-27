package Command;

import Sort.ISort;
import Sort.SortByName;

public class SortingCommand implements ICommand {
    @Override
    public void execute() {
        ISort sort = new SortByName();
        sort.sort();

    }
}
