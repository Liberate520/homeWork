package FamilyTree.Tree.view;


import FamilyTree.Tree.model.HumanGroup.Service;
import FamilyTree.Tree.presenter.Presenter;

public interface View {

    void start(String path, Service service, Presenter presenter);
    void printAnswer(String answer);


}
