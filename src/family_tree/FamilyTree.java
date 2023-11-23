package family_tree;

import java.io.Serializable;
import java.util.*;

public class FamilyTree<T extends HumanInterface<T>> implements Serializable, Iterable<T> {
    private long humanId;

    public List<T> getHumanList() {
        return humanList;
    }

    private List<T> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<T> humanList){
        this.humanList = humanList;
    }

    public void add(T human) {
        if (human != null){
            if (!humanList.contains(human)){
                humanList.add(human);
                human.setId(humanId++);
                addToParent(human);
                addToChildren(human);
            }
        }
    }

    public T getById(Long id){
        for (T human : humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public List<T> getSibList(Long id) {
        T human = getById(id);
        if (human == null){
            return null;
        }
        List<T> res = new ArrayList<>();
        for (T parent: human.getParent()){
            for (T kid: parent.getChildren()){
                if (!kid.equals(human) && !res.contains((kid))){
                    res.add(kid);
                }
            }
        }
        return res;
    }

    public List<T> getByName(String name) {
        List<T> res = new ArrayList<>();
        for (T human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    private void addToParent(T human){
        for (T parent: human.getParent()) {
            parent.addKid(human);
        }
    }

    private void addToChildren(T human){
        for (T kid: human.getChildren()) {
            kid.addParent(human);
        }
    }

    private boolean chekId(long id){
        return id < humanId && id >= 0;
    }

    public String getData(){
        StringBuilder info = new StringBuilder();
//        info.append("In tree ");
//        info.append(humanList.size());
//        info.append(" elements: \n");
        for (T human: humanList){
            info.append(human);
            info.append("\n");
        }


        return info.toString();
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge<>());
    }

    @Override
    public String toString(){
        return getData();
    }

    @Override
    public Iterator<T> iterator() {
        return new FamilyTreeIterator<>(humanList);
    }
}
