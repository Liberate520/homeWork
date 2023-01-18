package command;

import view.*;

public class ViewCommand extends Command{

    private int sortType;

    public ViewCommand(ConsoleUI view, String title, String code, int level, int sortType) {
        super(view, title, code, level);
        this.sortType = sortType;
    }

    @Override
    public void execute() {
        super.execute();
        view.getPresenter().onSortTree(sortType);
    }
}
