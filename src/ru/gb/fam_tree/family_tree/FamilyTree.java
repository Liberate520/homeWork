package ru.gb.fam_tree.family_tree;

import ru.gb.fam_tree.family_tree.all_tree_items.FamilyTreeItem;
import ru.gb.fam_tree.family_tree.all_tree_items.human.Human;
import ru.gb.fam_tree.family_tree.comparators.ComparatorByAge;
import ru.gb.fam_tree.family_tree.comparators.ComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends FamilyTreeItem<T>> implements Serializable,Iterable<T> {
    private long objectId;
    private List<T> objectList;

    public FamilyTree(List<T> objectList){
        this.objectList = objectList;
    }

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public boolean add(T t){
        if(t == null){
            return false;
        }
        if(!objectList.contains(t)){
            objectList.add(t);
            t.setId(objectId++);

            addToParents(t);
            addToChidrens(t);

            return true;
        }
        return false;
    }

    private void addToParents(T t){
        for(T parent: t.getParents()){
            parent.addChild(t);
        }
    }

    private void addToChidrens(T t){
        for (final T child: t.getChildrens()){
            child.addParent(t);
        }
    }

    public List<T> getSiblings(int id){
        T t = getById(id);
        if(t == null){
            return null;
        }
        List<T> res = new ArrayList<>();
        for(T parent: t.getParents())
            for (T child : parent.getChildrens()) {
                if (!child.equals(t)) {
                    res.add(child);
                }
            }
        return res;
    }

    public List<T> getByName(String name){
        List<T> res = new ArrayList<>();
        for(T t: objectList){
            if(t.getName().equalsIgnoreCase(name)){
                res.add(t);
            }
        }
        return res;
    }

    public boolean setWedding(long tId1, long tId2){
        if(checkId(tId1) && checkId(tId2)){
            T t1 = getById(tId1);
            T t2 = getById(tId2);
            return setWedding(t1, t2);
        }
        return false;
    }

    public boolean setWedding(T t1, T t2){
        if(t1.getSpouse() == null && t2.getSpouse() == null){
            t1.setSpouse(t2);
            t2.setSpouse(t1);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean setDivorce(long tId1, long tId2){
        if(checkId(tId1) && checkId(tId2)){
            T t1 = getById(tId1);
            T t2 = getById(tId2);
            if(t1.getSpouse() != null && t2.getSpouse() != null){
                t1.setSpouse(null);
                t2.setSpouse(null);
                return true;
            }
            else {
                return false;
            }
        }
        return false;
    }

    public boolean remove(long tId){
        if(checkId(tId)){
            T e = getById(tId);
            return objectList.remove(e);
        }
        return false;
    }

    private boolean checkId(long id){
        if(id >= objectId || id < 0){
            return false;
        }
        for(T t: objectList){
            if(t.getId() == id){
                return true;
            }
        }
        return false;
    }

    public T getById(long id){
        for(T t: objectList){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("In familly tree: ");
        sb.append(objectList.size());
        sb.append(" objects: \n");
        for(T t: objectList){
            sb.append(t);
            sb.append("\n");
        }
        return sb.toString();
    }

    public String toString(){
        return getInfo();
    }



    public Iterator<T> iterator(){
        return new HumanIterator(objectList);
    }

    public void sortByName(){
        objectList.sort(new ComparatorByName());
    }

    public void sortByAge(){
        objectList.sort(new ComparatorByAge());
    }
}
