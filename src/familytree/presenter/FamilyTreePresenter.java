package familytree.presenter;

import familytree.view.FamilyTreeView;
import familytree.model.TreeEntity;
import familytree.model.FamilyModelTree;

import java.util.List;

public class FamilyTreePresenter {
    private FamilyModelTree<TreeEntity> model;
    private FamilyTreeView view;

    public FamilyTreePresenter(FamilyModelTree<TreeEntity> model, FamilyTreeView view) {
        this.model = model;
        this.view = view;
    }

    public void loadData() {
        // Simulate loading data from model
        List<TreeEntity> entities = model.getEntities();
        view.displayEntities(entities);
    }
}
