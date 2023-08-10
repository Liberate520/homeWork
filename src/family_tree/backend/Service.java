package family_tree.backend;

import family_tree.backend.config.BaseInit;
import family_tree.backend.ftree.FamilyTree;
import family_tree.backend.ftree.Relatives;

public abstract class Service<P extends Relatives<P>> implements BaseInit<P> {
    private FamilyTree<P> relations;


}
