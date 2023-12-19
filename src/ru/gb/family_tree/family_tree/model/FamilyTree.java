package ru.gb.family_tree.family_tree.model;

import ru.gb.family_tree.family_tree.model.comparator.FamilyComparatorByAge;
import ru.gb.family_tree.family_tree.model.comparator.FamilyComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<A extends TreeNode<A>> implements Serializable,Iterable<A> {
    private List<A> familyTree;
    private int treeNum=0; //счетчик людей в дереве
    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }
    public FamilyTree(List<A> familyTree) {
        this.familyTree=familyTree;
    }
    public void addToFamilyTree(A human) {
        familyTree.add(human);
        human.setID(++treeNum);
    }


    public List<A> getByName(String name){
        List<A> result = new ArrayList<>();
        for(A human:familyTree)
        {
            if(human.getName().equals(name)){
                result.add(human);
            }
        }
        return result;
    }
    public List<A> getFamilyTree() {
        return familyTree;
    }
    @Override
    public String toString() {return GetInfo();}
    public String GetInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное древо: ");
        sb.append(familyTree.size());
        sb.append(" человек\n");
        for(A human:familyTree)
        {
            sb.append(human.getID());
            sb.append(") ");
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<A> iterator(){
        return new FamilyIterator(familyTree);
    }
public void sortByName(){
        familyTree.sort(new FamilyComparatorByName());
}
public void sortByAge(){
        familyTree.sort(new FamilyComparatorByAge<>());
}
}