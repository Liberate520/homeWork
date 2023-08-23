package Model.FamilyTree;

import Model.BaseCharacter.Comparators.ComparatorSortByAge;
import Model.BaseCharacter.Comparators.ComparatorSortByName;
import Model.BaseCharacter.BaseCharacter;
import Model.FamilyTree.Iterators.IteratorForBuffer;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends BaseCharacter> implements Iterable<BaseCharacter>, Serializable {
    private List<T> treeList;
    public FamilyTree(){
        treeList = new ArrayList<>();
    }
    public List<T> getTreeList() {
        return treeList;
    }

    public void add(T houseHold){
        treeList.add(houseHold);
    }

    @Override
    public Iterator<BaseCharacter> iterator() {
        return new IteratorForBuffer<>(treeList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное дерево: \n");
        for (T b: treeList) {
            sb.append(b);
            sb.append("\n");
        }
        return sb.toString();
    }

    public void print() {
        System.out.println(treeList.toString());
    }

    public void sortByAge() {
        treeList.sort(new ComparatorSortByAge<T>());
    }

    public void sortByName() {
        treeList.sort(new ComparatorSortByName<T>());
    }
}