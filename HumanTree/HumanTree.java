import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class HumanTree implements Iterable<Human>{
    private List<Human> humanList;
    

    public HumanTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public HumanTree() {
        this(new ArrayList<>());
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public void setHumanList(List<Human> humanList) {
        this.humanList = humanList;
    }

    public void addHuman(Human human) {
        humanList.add(human);
    }
    
    public List<Human> getChild(Human parent){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if (human.getFather() == parent){
                res.add(human);
            }
        }
        return res;
    }

    public List<Human> getSistBroth(Human one){
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if (human.getFather() == one.getFather() && human.getName()!=one.getName()){
                res.add(human);
            }
        }
        return res;
    }

    @Override
    public Iterator<Human> iterator() {        
        return humanList.iterator();
    }

    public void sortByName(){
        Collections.sort(humanList);
    }

    public void sortByBirth(){
        Collections.sort(humanList, new HumanComparatorByBirth());
    }
}
