package ru.gb.family_tree.family_tree.model;

import ru.gb.family_tree.family_tree.model.comparator.FamilyComparatorByAge;
import ru.gb.family_tree.family_tree.model.comparator.FamilyComparatorByName;
import ru.gb.family_tree.family_tree.model.human.Human;

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
    }
    public A getPersonByID(int ID){
        A human=null;
        for(A person:familyTree){
            if (person.getID()==ID){
                human=person;
            }
        }
        return human;
    }
    public void printFamilyTree(FamilyTree familytree) {
        System.out.println(familytree);
    }
    public String getFamilyTree() {
        return getInfo();
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

    @Override
    public String toString() {return getInfo();}
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное древо: ");
        sb.append(familyTree.size());
        sb.append(" человек\n");
        for(A human:familyTree)
        {
            sb.append(++treeNum);
            sb.append(") ");
            sb.append(human);
            sb.append("\n");
        }
        treeNum=0;
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