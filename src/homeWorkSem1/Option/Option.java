package homeWorkSem1.Option;

import homeWorkSem1.FamilyTree;
import homeWorkSem1.Human;


public interface Option {

    void exucute(FamilyTree<Human> tree);
    String description();
}
