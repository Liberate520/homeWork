package FT_Project.model.service.FileActions;

import FT_Project.model.Human.Human;
import FT_Project.model.family_tree.FamilyTree;

public interface FamilyTreeWritable {
    boolean save(FamilyTree<Human> tree);
    FamilyTree<Human> load();
}
