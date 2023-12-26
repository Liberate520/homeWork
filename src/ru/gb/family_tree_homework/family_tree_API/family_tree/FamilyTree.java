package ru.gb.family_tree_homework.family_tree_API.family_tree;

import ru.gb.family_tree_homework.family_tree_API.family_tree.comparators.TreeComparatorByAge;
import ru.gb.family_tree_homework.family_tree_API.family_tree.comparators.TreeComparatorByBirthDate;
import ru.gb.family_tree_homework.family_tree_API.family_tree.comparators.TreeComparatorByName;
import ru.gb.family_tree_homework.family_tree_API.human.Gender;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
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
                member.setId(familyTree.size());

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

    public String getByName(String name){
        StringBuilder stringBuilder = new StringBuilder();
        for (E member:
                familyTree) {
            if(member.getName().equals(name)){
                stringBuilder.append(member)
                        .append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public E getById(long id) {
        for (E member:
             familyTree) {
            if (member.getId() == id){
                return member;
            }
        }
        return null;
    }

    public boolean setWedding(E human1, E human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        return false;
    }

    public boolean setDivorce(E human1, E human2){
        if(human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        }
        return false;
    }

    public boolean setParent(E parent, E child){
        if (child != null) {
            if (parent.getGender().equals(Gender.Male)) {
                child.setFather(parent);
                return true;
            } else {
                child.setMother(parent);
                return true;
            }
        }
        return false;
    }

    public boolean setChild(E child, E parent){
        if (parent != null){
            parent.addChild(child);
            return true;
        }
        return false;
    }

    public void remove(long id){
        try {
            familyTree.remove(getById(id));
        } catch (IndexOutOfBoundsException e){
            System.out.println("Invalid input");
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
