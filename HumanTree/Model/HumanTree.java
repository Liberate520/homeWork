package Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HumanTree<E extends Human> implements Iterable<E>, Serializable {
    private List<E> humanList;
    

    public HumanTree(List<E> humanList) {
        this.humanList = humanList;
    }

    public HumanTree() {
        this(new ArrayList<>());
    }

    public List<E> getHumanList() {
        return humanList;
    }

    public Integer sizeHumanList() {
        return humanList.size();
    }

    public boolean addHuman(E human) {
        if (!humanList.contains(human)){
            humanList.add(human);
            if (human.getFather()!=null){
                human.getFather().addChild(human);
            }
            if (human.getMother()!=null){
                human.getMother().addChild(human);
            }
            return true;
        }
        else return false;        
    }
    
    @Override
    public Iterator<E> iterator() {        
        return humanList.iterator();
    }

    public void sortByName(){
        Collections.sort(humanList);
    }

    public void sortByBirth(){
        Collections.sort(humanList, new HumanComparatorByBirth<E>());
    }
}
