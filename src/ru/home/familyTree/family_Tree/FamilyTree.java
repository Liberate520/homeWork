package ru.home.familyTree.family_Tree;

import ru.home.familyTree.human.Human;
import ru.home.familyTree.human.comporator.*;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> humanList;

    public FamilyTree(List<E> humanList){
        this.humanList = humanList;}

        public FamilyTree(){
        this(new ArrayList<>());
    }

    public void addHuman(E human){
        humanList.add(human);
        addToParents(human);
        addToChildren(human);
    }

    private void addToParents(E human){
        for (E parent: human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for (E child: human.getChildren()) {
            child.addParent(human);
        }
    }
    public String getHumansInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        for (E human: humanList) {
            stringBuilder.append(human);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<E> iterator(){
        return new HumanIterator<>(humanList);
    }

    public void sortName(){
        humanList.sort(new HumanComporatorName<>());
    }

    public void sortDateOfBirth(){
        humanList.sort(new HumanComparatorDateOfBirth<>());
    }
}
