package command;

import view.*;

public class ChooseCommand extends Command{

    private int familyTreeIndex;

    public ChooseCommand(Command parent, ConsoleUI view, String title, String code, int familyTreeIndex) {
        super(parent, view, title, code);
        this.familyTreeIndex = familyTreeIndex;
    }

    @Override
    public Boolean execute(String execCode) {
        if (execCode.equals(code)) {
            view.getPresenter().onGetTree(familyTreeIndex);
            return true;
        }
        return false;
    }
}
