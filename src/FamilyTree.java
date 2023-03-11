import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Individual> implements Serializable, Iterable<T> {
    private List<T> humans;

    public FamilyTree() {
        this(new ArrayList<>());
    }

    private FamilyTree(List<T> humans) {
        this.humans = humans;
    }

    public List<T> getHumans() {
        return humans;
    }
   
    public String getInfo(){
        StringBuilder res = new StringBuilder();
        res.append(humans.size());
        res.append(" objects in the tree: \n");
        for (T human : humans){
            res.append(human.getInfo());
            res.append("\n");
        }
        return res.toString();
    }

    // public String getAllHumanToString() {
    //     String res = "Генеологическое дерево: ";
    //     List<T> list1 = new ArrayList<>();
    //     for (int i = 0; i < humans.size(); i++) {
    //         list1.add(humans.get(i));
    //     }
    //     for (int i = 0; i < humans.size(); i++) {
    //         res = res + "\n" + (i + 1) + "). " + humans.get(i).getInfo();
    //     }
    //     return res;
    // }

    public boolean addHuman(T human) {

        if (human == null) {
            return false;
        }
        if (!humans.contains(human)) {
            humans.add(human);
            if (human.getFather() != null) {
                human.getFather().addChild(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }

    public T getByName(String name) {
        for (T human : humans) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    
    public T search(String sName) {
        T find = null;
        if(sName.isEmpty() || sName.equalsIgnoreCase("no")){
            find = null;
        }
        else{
            for (T human: humans) {
                if (human.getName().contains(sName)) {
                    find = human;
                }
            }
        }
        return find;
    }

    @Override
    public Iterator<T> iterator() {

        return new HumanIterator<T>(humans);
    }

    public void sortByName() {
        Collections.sort(humans, new HumanComparatorByName<T>());
    }

    public void sortByYearBirth() {
        Collections.sort(humans, new HumanComparatorByYearBirth<T>());
    }

}
