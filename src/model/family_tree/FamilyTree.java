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

            addToParents(person);
            addToChildren(person);

            return true;
        }
        return false;
    }

    private void addToParents(E person) {
        E father = person.getFather();
        if (father != null) father.addChild(person);
        E mother = person.getMother();
        if (mother != null) mother.addChild(person);
    }

    private void addToChildren(E person) {
        for (E child : person.getChildren()) {
            if (person.getGender() == Gender.Male)
                child.addFather(person);
            else child.addMother(person);
        }
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
