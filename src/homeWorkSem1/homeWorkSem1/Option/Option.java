package homeWorkSem1.Option;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;
import homeWorkSem1.Presenter.Presenter;

public interface Option {
    void execute(FamilyTree<Human> tree, Presenter presenter);
    String description(); 
}
