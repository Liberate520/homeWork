package command;

import view.*;

public class SaveCommand extends Command{

    private int fileType;

    public SaveCommand(ConsoleUI view, String title, String code, int level, int fileType) {
        super(view, title, code, level);
        this.fileType = fileType;
    }

    @Override
    public void execute() {
        super.execute();
        view.getPresenter().onSaveTree(fileType);
    }
}
