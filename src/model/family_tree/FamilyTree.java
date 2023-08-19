package model.family_tree;

import model.person.Gender;
import model.person.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private int personsId;
    private List<E> familyTree;

    public FamilyTree(List<E> familyTree) {this.familyTree = familyTree;}

    public FamilyTree() {this(new ArrayList<>());}

    public boolean add(E person) {
        if (person == null) return false;
        if (!familyTree.contains(person)) {
            familyTree.add(person);
            person.setId(personsId++);
            return true;
        }
        return false;
    }

    private E getById(int id) {
        for (E person : familyTree){
            if (person.getId() == id) return person;
        }
        return null;
    }

    public boolean addParent(int childId, int parentId) {
        E child = getById(childId);
        E parent = getById(parentId);
        if (child == null || parent == null) return false;
        if (parent.getGender() == Gender.Male)
            child.addFather(parent);
        else
            child.addMother(parent);
        parent.addChild(child);
        return true;
    }

    public List<E> getParents(int childId){
        return getById(childId).getParents();
    }

    public List<E> getChildren(int parentId){
        return getById(parentId).getChildren();
    }

    public void sortByName(){
        familyTree.sort(new PersonComparatorByName<>());
    }

    public void sortByAge(){
        familyTree.sort(new PersonComparatorByAge<>());
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (E person : familyTree) {
            result.append(person).append("\n");
        }
        return result.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<>(familyTree);
    }

}
