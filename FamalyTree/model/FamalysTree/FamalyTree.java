package homeWork.FamalyTree.model.FamalysTree;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import homeWork.FamalyTree.model.Human.HumanComporatoByAge;
import homeWork.FamalyTree.model.Human.HumanIterator;


public class FamalyTree<E extends ItemTree<E>> implements Serializable, Iterable<E>  {
    private long humanId;
    private List<E> humanList;


    public FamalyTree(List<E> humanList){
        this.humanList = humanList;
    }

    public FamalyTree(){
        this(new ArrayList<>());
    }

    public boolean addHumman(E human){
        if (human == null){
            return false;
        }
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(humanId++);
            addToChildren(human);
            addToParent(human);
            return true;
        }
        return false;
        
    }

    private void addToChildren(E human){
        for (E child: human.getChildren()){
            child.addParents(human);
        }
    }

    private void addToParent(E human){
        for (E child: human.getParents()){
            child.addChild(human);
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

        @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanList);
    }
    
    public void sortByName(){
        humanList.sort(new HumanComporatoByAge<>());
    }

    public void sortByAge(){
        humanList.sort(new HumanComporatoByAge<>());
    }
}