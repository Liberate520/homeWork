package familyTree.view;

import familyTree.model.familyTree.FamilyTree;
import familyTree.model.human.Human;

public interface View {
    FamilyTree<Human> start();
    void printAnswer(String answer);

}
