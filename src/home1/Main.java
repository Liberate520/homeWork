package home1;

import home1.model.FamilyTree;
import home1.model.Human;
import home1.presenter.Presenter;
import home1.ui.Console;
import home1.ui.View;

public class Main {
    public static void main(String[] args) {
        FamilyTree<Human> familyTree = new FamilyTree<>();
        View view = new Console();
        new Presenter(view, familyTree);
        view.start();

    }
}
