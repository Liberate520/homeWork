package ru.gb.family_tree.familytree;

import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.human.comparators.HumanComparatorByAge;
import ru.gb.family_tree.human.comparators.HumanComparatorByName;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree implements Iterable<Human>{
    private List<Human> humanList;
    private FamilyTree familyTree;
    private int id;
    private int humanId;

    public int getId() {
        return id;
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public int getHumanId() {
        return humanId;
    }

    public FamilyTree(int id) {
        this.id = id;
        humanList = new ArrayList<>();
    }

    public void addHuman(Human human){
        if (!humanList.contains(human) ) {
            human.setId(humanId++);
            humanList.add(human);
            addToParents(human);
            addToChildren(human);

        }
    }
    public void addToParents(Human human){
        for (Human parent : human.getParents()) {
            parent.addChild(human);
        }
    }
    public void addToChildren(Human human){
        for (Human child : human.getChildren()) {
            child.addParent(human);
        }
    }


    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge() {
        humanList.sort(new HumanComparatorByAge());
    }

    public String getInfo( ){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Family tree:\n");
        for (Human human: humanList){
            stringBuilder.append(human.getInfo());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
