package homeWorkSem1.Option;

import java.io.Serializable;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;
import homeWorkSem1.Presenter.Presenter;

public class GetTree implements Serializable, Option{

    @Override
    public String description() {
        return String.format("Get FamilyTree");
    }
    
    @Override
    public void execute(FamilyTree<Human> tree, Presenter presenter) {
        presenter.showTree(tree);     
    }    
}
