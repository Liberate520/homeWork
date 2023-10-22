package my_family_tree.tree;

import my_family_tree.human.Human;
import my_family_tree.human.comparators.HumanComparatorByAge;
import my_family_tree.human.comparators.HumanComparatorByYear;

import java.io.Serializable;
import java.util.*;

public class familyTree implements Serializable, Iterable<Human> {
    private int humanId;
    private List<Human> humanList;

    public familyTree (){
        this(new ArrayList<>());
    }

    public familyTree (List<Human> humanList){
        this.humanList = humanList;
    }

    public void addToTheTree(Human human){
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);

            addToParents(human);
            addToChildren(human);
        }
    }

    private void addToParents (Human human){
        for (Human parent : human.getParents()) {
            parent.addChildren(human);
        }
    }

    private void addToChildren (Human human){
        for (Human child : human.getChildren()) {
            child.addParents(human);
        }
    }

    private boolean checkId(int id){
        return id < humanId && id >= 0;
    }

    public Human findById(int id){
        if (!checkId(id)){
            return null;
        }
        for (Human human: humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<Human> findSiblings(int id){
        Human human = findById(id);
        if (human == null){
            return null;
        }
        List<Human> siblings = new ArrayList<>();
        for (Human parent : human.getParents()) {
            for (Human child : parent.getChildren()) {
                if (!child.equals(human) && !(siblings.contains(child))){
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }

    public List<Human> findByName(String name){
        List<Human> names = new ArrayList<>();
        for (Human human : humanList) {
            if (human.getName().equals(name)){
                names.add(human);
            }
        }
        return names;
    }

    public void weddind(Human human1, Human human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
        }
    }

    public void wedding(int humanId1, int humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            Human human1 = findById(humanId1);
            Human human2 = findById(humanId2);
            weddind(human1, human2);
        }
    }

    public void sortByName(){
        Collections.sort(humanList);
    }

    public void sortByAge(){
        Collections.sort(humanList, new  HumanComparatorByAge());
    }

    public void sortByYear(){
        Collections.sort(humanList, new HumanComparatorByYear());
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Кол-во объектов: ").append(humanList.size()).append("\n");
        for (Human human : humanList) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanList);
    }
}
