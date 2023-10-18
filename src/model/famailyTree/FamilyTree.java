package model.famailyTree;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import model.famailyTree.comparators.FamilyTreeComparatorByBirthDay;
import model.famailyTree.comparators.FamilyTreeComparatorByName;






public class FamilyTree <E extends TreeNode<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> humanList;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    public FamilyTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        } else if (!humanList.contains(human)) {
            humanList.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    public E getById(long id) {
        for (E person : humanList) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

  
      

    public List<E> getList() {
        List<E> list = new ArrayList<>();
        for (E human : humanList) {
            list.add(human);
        }
        return list;
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    private void addToParents(E human) {
        E mother = human.getMother();
        E father = human.getFather();
        if (mother != null) {
            mother.addChild(human);
        }
        if (father != null) {
            father.addChild(human);
        }
    }

    private boolean checkId(long id) {
        if (id >= humansId || id < 0) {
            return false;
        }
        for (E human : humanList) {
            if (human.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public String Info() {
        StringBuilder sb = new StringBuilder();
        sb.append("Семейное дерево: \n");
        sb.append(humanList.size()).append(" - Семейное дерево\n");
        sb.append("Перечень людей в дереве:\n");
        for (E human : humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return Info();
    }

    @Override
    public Iterator<E> iterator(){
        return new FamilyTreeIterator<>(humanList);
    }

     
    public void sortBirthDay(){
        humanList.sort(new FamilyTreeComparatorByBirthDay<>());
    }

    public void sortByName(){
        humanList.sort(new FamilyTreeComparatorByName<>());
    }
    
}
