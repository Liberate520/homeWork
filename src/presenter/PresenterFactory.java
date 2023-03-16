package presenter;

import cmdui.IView;
import familytree.FamilyTree;
import familytree.FamilyTreeMemeber;

public class PresenterFactory {
    private FamilyTree<FamilyTreeMemeber> familyTree;

    public PresenterFactory(FamilyTree<FamilyTreeMemeber> familyTree) {
        this.familyTree = familyTree;
    }

    public Presenter createPresenter(IView view) {
        return new Presenter(view, familyTree);
    }
}
