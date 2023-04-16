package treeAPI.familyTrees;

import treeAPI.familyTree.FamilyTree;
import treeAPI.handler.Writable;

import java.util.List;

public interface InterfaceTrees<E extends FamilyTree> extends Iterable<E>{
    boolean addFamilyTree(E fTree);

    E findFamilyTree(String name);

    String printAllInfo();

    void save(Writable<TreesHolder<E>> writable, String fileName);

    List<E> getFamilyTrees();

    String printTrees();
}
