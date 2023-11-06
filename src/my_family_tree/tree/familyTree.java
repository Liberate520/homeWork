package my_family_tree.tree;

import my_family_tree.human.comparators.HumanComparatorByAge;
import my_family_tree.human.comparators.HumanComparatorByYear;

import java.io.Serializable;
import java.util.*;

public class familyTree <E extends TreeItem> implements Serializable, Iterable<E> {
    private int humanId;
    private List<E> humanList;

    public familyTree (){
        this(new ArrayList<>());
    }

    public familyTree (List<E> humanList){
        this.humanList = humanList;
    }

    public void addToTheTree(E human){
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);

            addToParents(human);
            addToChildren(human);
        }
    }

    private void addToParents (E human){
        for (E parent : human.getParents()) {
            parent.addChildren(human);
        }
    }

    private void addToChildren (E human){
        for (E child : human.getChildren()) {
            child.addParents(human);
        }
    }

    private boolean checkId(int id){
        return id < humanId && id >= 0;
    }

    public E findById(int id){
        if (!checkId(id)){
            return null;
        }
        for (E human: humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<E> findSiblings(int id){
        E human = findById(id);
        if (human == null){
            return null;
        }
        List<E> siblings = new ArrayList<>();
        for (E parent : human.getParents()) {
            for (E child : parent.getChildren()) {
                if (!child.equals(human) && !(siblings.contains(child))){
                    siblings.add(child);
                }
            }
        }
        return siblings;
    }

    public List<E> findByName(String name){
        List<E> names = new ArrayList<>();
        for (E human : humanList) {
            if (human.getName().equals(name)){
                names.add(human);
            }
        }
        return names;
    }

    public void weddind(E human1, E human2){
        if (human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
        }
    }

    public void wedding(int humanId1, int humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            E human1 = findById(humanId1);
            E human2 = findById(humanId2);
            weddind(human1, human2);
        }
    }

    public void sortByName(){
        Collections.sort(humanList);
    }

    public void sortByAge(){
        Collections.sort(humanList, new  HumanComparatorByAge<>());
    }

    public void sortByYear(){
        Collections.sort(humanList, new HumanComparatorByYear<>());
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("Кол-во объектов: ").append(humanList.size()).append("\n");
        for (E human : humanList) {
            sb.append(human).append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }
}
