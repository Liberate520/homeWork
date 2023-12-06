package ru.gb.family_tree_homework.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private long counter;
    private List<E> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public FamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }

    public void addFamilyMember(E member) {
        if (member != null) {
            if(!familyTree.contains(member)) {
                familyTree.add(member);
                member.setId(counter++);

                addParents(member);
                addChildren(member);
            }
        }
    }

    private void addParents(E child){
        for (E parent:
                child.getParents()) {
            parent.addChild(child);
        }
    }

    private void addChildren(E parent){
        for (E child:
                parent.getChildren()) {
            child.addParent(parent);
        }
    }

    public List<E> getSiblings(E member) {
        List<E> siblings = new ArrayList<>();
        if (member.getMother().getChildren().size() > 1) {
            for (E child :
                    member.getMother().getChildren()) {
                if (!child.equals(member)) {
                    siblings.add(child);
                }
            }
            return siblings;
        }
        return null;
    }

    public List<E> getByName(String name){
        List<E> familyMembers = new ArrayList<>();
        for (E member:
                familyTree) {
            if(member.getName().equals(name)){
                familyMembers.add(member);
            }
        }
        if (!familyMembers.isEmpty()){
            return familyMembers;
        }
        return null;
    }

    public void setWedding(E human1, E human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
        }
    }

    public void setDivorce(E human1, E human2){
        if(human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("There are ").append(familyTree.size())
                .append(" family members in family tree: \n");
        for (E member:
                familyTree) {
            stringBuilder.append(member).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator(){
        return new TreeIterator<>(familyTree);
    }

    public void sortByName(){
        familyTree.sort(new TreeComparatorByName<>());
    }

    public void sortByAge(){
        familyTree.sort(new TreeComparatorByAge<>());
    }

    public void sortByBirthDate(){
        familyTree.sort(new TreeComparatorByBirthDate<>());
    }
}
