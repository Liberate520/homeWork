package familyTreeApi.trees;

import familyTreeApi.familyTree.FamilyTree;
import familyTreeApi.handler.Writable;

import java.util.List;

public interface TOTrees<E extends FamilyTree> extends Iterable<E> {

    boolean addFamilyTree(E fTree);

    E findFamilyTree(String name);

    String printAllInfo();

    void save(Writable<TreeOfTrees<E>> writable, String fileName);

    List<E> getFamilyTrees();

    String printTrees();
}