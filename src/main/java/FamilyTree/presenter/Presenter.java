package FamilyTree.presenter;

import FamilyTree.model.Family.FamilyItem;
import FamilyTree.model.Family.FamilyTree;
import FamilyTree.view.View;

public class Presenter {
    private View view;
    private FamilyTree family;

    public Presenter(View view, FamilyTree family) {
        this.view = view;
        this.family = family;
        view.setPresenter(this);
    }

    public void showChildren(String name) {
        family.findChildren(name);
    }

    public void showFamily() {
        family.getFamilyInfo();
    }
}
