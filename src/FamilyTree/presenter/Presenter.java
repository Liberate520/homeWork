package FamilyTree.presenter;

import FamilyTree.model.Service;
import FamilyTree.model.FamilyTree;
import FamilyTree.view.View;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view, Service service) {
        this.view = view;
        this.service = service;
        view.setPresenter(this);
    }

    public FamilyTree getService() {
        return (FamilyTree) service;
    }
}
