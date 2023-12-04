package ru.gb.family_tree_homework.family_tree;

import ru.gb.family_tree_homework.human.Human;
import ru.gb.family_tree_homework.human.HumanComparatorByAge;
import ru.gb.family_tree_homework.human.HumanComparatorByBirthDate;
import ru.gb.family_tree_homework.human.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long counter;
    private List<Human> familyTree;

    public FamilyTree() {
        this.familyTree = new ArrayList<>();
    }

    public FamilyTree(List<Human> familyTree) {
        this.familyTree = familyTree;
    }

    public void addFamilyMember(Human human) {
        if (human != null) {
            if(!familyTree.contains(human)) {
                familyTree.add(human);
                human.setId(counter++);

                addParents(human);
                addChildren(human);
            }
        }
    }

    private void addParents(Human human){
        for (Human parent:
                human.getParents()) {
            parent.addChild(human);
        }
    }

    private void addChildren(Human human){
        for (Human child:
                human.getChildren()) {
            human.addParent(human);
        }
    }

    public List<Human> getSiblings(Human human) {
        List<Human> siblings = new ArrayList<>();
        if (human.getMother().getChildren().size() > 1) {
            for (Human child :
                    human.getMother().getChildren()) {
                if (!child.equals(human)) {
                    siblings.add(child);
                }
            }
            return siblings;
        }
        return null;
    }

    public List<Human> getByName(String name){
        List<Human> humans = new ArrayList<>();
        for (Human human:
                familyTree) {
            if(human.getName().equals(name)){
                humans.add(human);
            }
        }
        if (!humans.isEmpty()){
            return humans;
        }
        return null;
    }

    public void setWedding(Human human1, Human human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
        }
    }

    public void setDivorce(Human human1, Human human2){
        if(human1.getSpouse() != null && human2.getSpouse() != null){
            human1.setSpouse(null);
            human2.setSpouse(null);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("There are ").append(familyTree.size())
                .append(" people in family tree: \n");
        for (Human human:
                familyTree) {
            stringBuilder.append(human).append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public Iterator<Human> iterator(){
        return new HumanIterator(familyTree);
    }

    public void sortByName(){
        familyTree.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        familyTree.sort(new HumanComparatorByAge());
    }

    public void sortByBirthDate(){
        familyTree.sort(new HumanComparatorByBirthDate());
    }
}
