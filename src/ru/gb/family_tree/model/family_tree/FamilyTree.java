package ru.gb.family_tree.model.family_tree;

import ru.gb.family_tree.model.family_tree.comparator.FamilyTreeComparatorByAge;
import ru.gb.family_tree.model.family_tree.comparator.FamilyTreeComparatorByName;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E> {
    private int humansId;
    private List<E> humanlist;

    public FamilyTree(List<E> humanlist){
        this.humanlist = humanlist;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public void add(E human){
        humanlist.add(human);
    }

//
    public List<E> getSiblings(int id){
        E human = getById(id);
        if (human == null){
            return null;
        }
        List<E> res = new ArrayList<>();
        for (E parent: human.getParents()){
            for (E child: parent.getChildren()){
                if (!child.equals(human) && !res.contains(child)){
                    res.add(child);
                }
            }
        }
        return res;
    }

    public List<E> getByName(String name){
        List<E> res = new ArrayList<>();
        for (E human: humanlist){
            if (human.getName().equalsIgnoreCase(name)){
                res.add(human);
            }
        }
        return res;
    }


    public boolean remove(int humansId){
        if (checkId(humansId)){
            E human = getById(humansId);
            return humanlist.remove(human);
        }
        return false;
    }

    private boolean checkId(long id){
        if (id > humansId || id < 0){
            return false;
        }
        for (E human: humanlist){
            if (human.getId() == id){
                return true;
            }
        }
        return false;
    }

    public E getById(long id){
        for (E human: humanlist){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(humanlist.size());
        sb.append(" объектов: \n");
        for (E human: humanlist){
            sb.append(human);
            sb.append("\n");
        }
        return sb.toString();
    }

    @Override
    public String toString(){
        return getInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyTreeIterator<>(humanlist);
    }

    public void sortByName() {
        humanlist.sort(new FamilyTreeComparatorByName<>());
    }

    public void sortByAge() {
        humanlist.sort(new FamilyTreeComparatorByAge<>());
    }
}
