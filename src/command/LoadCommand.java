package command;

import view.*;

public class LoadCommand extends Command{

    private int fileType;

    public LoadCommand(ConsoleUI view, String title, String code, int level, int fileType) {
        super(view, title, code, level);
        this.fileType = fileType;
    }

    @Override
    public void execute() {
        super.execute();
        view.getPresenter().onLoadTree(fileType);
    }
}