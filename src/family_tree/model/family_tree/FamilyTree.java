package family_tree.model.family_tree;

import family_tree.model.human.comparators.HumanComparatorByName;
import family_tree.model.human.comparators.HumanComparatorByBirthDate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private  long humansId;
    private  List<E> humanList;

    public FamilyTree(List<E> humanList){
        this.humanList = humanList;
    }
    public FamilyTree() {
        this(new ArrayList<>());
    }

    public boolean add(E human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
            return  true;
        }
        return  false;
    }
    private void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }
    private void addToChildren(E human){
        for (E children: human.getChildren()){
            children.addParent(human);
        }
    }
    public List<E> getSiblings(int id){
        E human = getById(id);
        if (human == null){
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent: human.getParents()){
            for (E child: parent.getChildren()){
                if (!child.equals(human)){
                    res.add(child);
                }
            }
        }
        return res;
    }
    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if (human.getName().equalsIgnoreCase(name)){
                res.add(human);
            }
        }
        return res;
    }
    public boolean setWedding(long humansId1, long humansId2){
        if (checkId(humansId1) && checkId(humansId2)){
            E human1 = getById(humansId1);
            E human2 = getById(humansId2);
            if (human1.getSpouse() == null && human2.getSpouse() == null){
                human1.getSpouse(human2);
                human2.getSpouse(human1);
            } else {
                return false;
            }
        }
        return false;
    }
    public boolean setDivorce(long humansId1, long humansId2){
        if (checkId(humansId1) && checkId(humansId2)){
            E human1 = getById(humansId1);
            E human2 = getById(humansId2);
            if (human1.getSpouse() != null && human2.getSpouse() != null){
                human1.getSpouse(null);
                human2.getSpouse(null);
            } else {
                return false;
            }
        }
        return false;
    }
    public boolean remove(long humansId){
        if (checkId(humansId)){
            E e = getById(humansId);
            return humanList.remove(e);
        }
        return false;
    }
    private boolean checkId(long id){
        if (id >= humansId || id < 0){
            return false;
        }
        for (E human: humanList){
            if (human.getId() == id){
                return true;
            }
        }
        return false;
    }
    public E getById(long id){
        for (E human: humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanList.size());
        sb.append(" объектов: \n ");
        for (E human: humanList){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public String toString(){
        return getInfo();
    }
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }
    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }
    public void sortByBirthDate(){
        humanList.sort(new HumanComparatorByBirthDate<>());
    }
}
