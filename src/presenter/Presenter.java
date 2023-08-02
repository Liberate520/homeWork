package presenter;

import model.familyTree.FamilyTree;
import model.familyTree.TreeNode;
import model.service.Service;
import view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service();
    }

    public void addPerson (TreeNode person) {
        service.addPerson(person);
    }
}
