package family_Tree.model.familyTree;

import family_Tree.model.human.comparators.HumanComparatorByAge;
import family_Tree.model.human.comparators.HumanComparatorById;
import family_Tree.model.human.comparators.HumanComparatorByName;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private List<E> humanList;

    public FamilyTree(){
        humanList = new ArrayList<>();
    }

    public FamilyTree(List<E> humanList){
        this.humanList = humanList;
    }

    public void addHuman(E human){
        humanList.add(human);
    }

    public E getById (int id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanList) {
            if(human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Элементов в дереве => ");
        sb.append((humanList.size()));
        sb.append(" \n");
        for (E human: humanList) {
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String getHumanInfo(int id) {
        StringBuilder sb = new StringBuilder();
        sb.append(getById(id));
        sb.append("\n");
        return sb.toString();
    }

    public List<E> getBrotherSister(int id){
        E human = getById(id);
        if(human == null){
            return null;
        }
        List<E> res = new ArrayList<>();

        for(E parent: human.getParents()){
            for(E child: parent.getChildren()){
                if(!child.equals(human) && !res.contains(child)){
                    res.add(child);
                }
            }
        }
        return res;
    }
    @Override
    public String toString(){
        return getInfo();
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge<>());
    }

    public void sortById(){
        humanList.sort(new HumanComparatorById<>());
    }

    public void addChild(int parentId, int childId){
        E human = getById(parentId);
        E child = getById(childId);
        human.addChild(child);
    }

    public void addParent(int humanId, int parentId){
        E human = getById(humanId);
        E parent = getById(parentId);
        human.addParent(parent);
    }

    public E findById(int id) {
        for (E human : humanList) {
            if (human.getId() == id) return human;
        }
        return null;
    }

    public void setDeathDate(int id, LocalDate date){
        E human = findById(id);
        human.setDateOfDeath(date);
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }

}
