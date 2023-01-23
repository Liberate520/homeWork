package command;

import view.*;

public class ViewCommand extends Command{

    private int sortType;

    public ViewCommand(Command parent, ConsoleUI view, String title, String code, int sortType) {
        super(parent, view, title, code);
        this.sortType = sortType;
    }

    @Override
    public Boolean execute(String execCode) {
        if (execCode.equals(code)) {
            view.getPresenter().onSortTree(sortType);
            return true;
        }
        return false;
    }
}
