import model.FamilyTree;
import model.FamilyTreeItem;
import model.Gender;
import model.Human;
import presenter.Presenter;
import ui.Console;
import ui.View;

import java.security.Provider;

public class Test {
    public static void main(String[] args) {
        View view = new Console();
        FamilyTree familyTree = new FamilyTree();
        new Presenter(view, familyTree);

        view.start();
    }
}
