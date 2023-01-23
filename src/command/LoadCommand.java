package command;

import view.*;

public class LoadCommand extends Command{

    private int fileType;

    public LoadCommand(Command parent, ConsoleUI view, String title, String code, int fileType) {
        super(parent, view, title, code);
        this.fileType = fileType;
    }

    @Override
    public Boolean execute(String execCode) {
        if (execCode.equals(code)) {
            view.getPresenter().onLoadTree(fileType);
            return true;
        }
        return false;
    }
}