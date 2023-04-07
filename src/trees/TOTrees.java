package trees;

import familyTree.FamilyTree;
import handler.Writable;

import java.util.List;

public interface TOTrees<E extends FamilyTree> extends Iterable<E> {

    void addFamilyTree(E fTree);

    E findFamilyTree(String name);

    void printAllInfo();

    void save(Writable<TreeOfTrees<E>> writable, String fileName);

    List<E> getFamilyTreeList();
}