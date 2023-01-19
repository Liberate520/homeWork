package Model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HumanTree<E extends Human> implements Iterable<E>{
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

    public void setHumanList(List<E> humanList) {
        this.humanList = humanList;
    }

    public Integer sizeHumanTree() {
        return humanList.size();
    }

    public void addHuman(E human) {
        humanList.add(human);
    }
    
    public List<E> getChild(E parent){
        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if (human.getFather() == parent){
                res.add(human);
            }
        }
        return res;
    }

    public List<E> getSistBroth(E one){

        List<E> res = new ArrayList<>();
        for (E human: humanList){
            if (human.getFather() == one.getFather() && human.getName()!=one.getName()){
                res.add(human);
            }
        }
        return res;
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
