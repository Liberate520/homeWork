package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.creatures.Creature;
import ru.gb.family_tree.model.creatures.CreatureComporatorByAge;
import ru.gb.family_tree.model.creatures.CreatureComporatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends Creature<E>> implements Serializable, Iterable<E> {
    private int countPeople;
    private List<E> familyTree;

    public FamilyTree() {this(new ArrayList<>()); }

    public FamilyTree(List<E> familyTree) {this.familyTree = familyTree; }

    public boolean add(E human) {
        if (human == null){
            return false;
        }
        if (!familyTree.contains(human)) {
            familyTree.add(human);
            human.setId(countPeople++);
            addToParents(human);
            addToChildren(human);


        }
        return true;
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    public List<E> getByName(String name) {
        List<E> res = new ArrayList<>();
        for (E human : familyTree) {
            if (human.getName().equals(name)) {
                res.add(human);
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В древе: ");
        sb.append(familyTree.size());
        sb.append(" человек \n");
        for (E human: familyTree){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() { return new TreeIterator<>(familyTree); }

    public void sortByName(){familyTree.sort(new CreatureComporatorByName()); }

    public void sortByBirthDate(){
        familyTree.sort(new CreatureComporatorByAge());
    }
}
