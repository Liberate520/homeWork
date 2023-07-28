package family_tree.family_tree;

import family_tree.human.comporators.HumanComparatorByAge;
import family_tree.human.comporators.HumanComparatorByName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree <E extends TreeNode<E>>implements Serializable, Iterable<E>{
    private long humansId;
    private List<E> humanList;

    public FamilyTree(List<E> humanList){this.humanList = humanList;}

    public  FamilyTree(){this(new ArrayList<>());}

    public boolean add(E human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humansId++);
            addToParents(human);
            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToParents(E human){
        for (E parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParents(human);
        }
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

    public List<E> getSiblings(String name){
        E human = (E) getByName(name);
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

    private boolean cheekId(long id){
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

    public boolean remove(long humansId){
        if (cheekId(humansId)){
            E del = getById(humansId);
            return humanList.remove(del);
        }
        return false;
    }

    public String getInfo(){
        StringBuilder str = new StringBuilder();
        str.append("в древе ");
        str.append(humanList.size());
        str.append(" объектов: \n");
        for (E human: humanList){
            str.append(human);
            str.append("\n");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        return getInfo();
    }

    @Override
    public Iterator<E> iterator() {
        return new TreeIterator<>(humanList);
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge<>());
    }
}


