package command;

import view.*;

public class ChooseCommand extends Command{

    private int familyTreeIndex;

    public ChooseCommand(ConsoleUI view, String title, String code, int level, int familyTreeIndex) {
        super(view, title, code, level);
        this.familyTreeIndex = familyTreeIndex;
    }

    @Override
    public void execute() {
        super.execute();
        view.getPresenter().onGetTree(familyTreeIndex);
    }
}
