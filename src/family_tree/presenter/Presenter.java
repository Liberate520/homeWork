package family_tree.presenter;

import family_tree.model.base.FileHandlerForTree;
import family_tree.model.service.Service;
import family_tree.model.tree.FamilyTree;
import family_tree.view.View;

public class Presenter {
    private final Service service;

    public Presenter(View view) {
        service = new Service();
    }

    public void getFamilyListInfo() {
        /*String info = */
        FamilyTree.handlerForTree();
//        view.printAnswer(info);
    }

    public void sortByName() { service.sortByName(); }

    public void sortByLastName() { service.sortByLastName(); }
    public void sortByAge() { service.sortByAge(); }
    public void sortByIncome() {
        service.sortByIncome();
    }
}
