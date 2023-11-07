package family_tree;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private long humanId;

    public List<Human> getHumanList() {
        return humanList;
    }

    private List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    public void add(Human human) {
        if (human != null){
            if (!humanList.contains(human)){
                humanList.add(human);
                human.setId(humanId++);
                addToParent(human);
                addToChildren(human);
            }
        }
    }

    public Human getById(Long id){
        for (Human human : humanList){
            if (human.getId() == id){
                return human;
            }
        }
        return null;
    }

    public List<Human> getSibList(Long id) {
        Human human = getById(id);
        if (human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent: human.getParent()){
            for (Human kid: parent.getChildren()){
                if (!kid.equals(human) && !res.contains((kid))){
                    res.add(kid);
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name) {
        List<Human> res = new ArrayList<>();
        for (Human human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }

    private void addToParent(Human human){
        for (Human parent: human.getParent()) {
            parent.addKid(human);
        }
    }

    private void addToChildren(Human human){
        for (Human kid: human.getChildren()) {
            kid.addParent(human);
        }
    }

    private boolean chekId(long id){
        return id < humanId && id >= 0;
    }

    public String getData(){
        StringBuilder info = new StringBuilder();
        info.append("In tree ");
        info.append(humanList.size());
        info.append(" elements: \n");
        for (Human human: humanList){
            info.append(human);
            info.append("\n");
        }


        return info.toString();
    }

    public void sortByName(){
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humanList.sort(new HumanComparatorByAge());
    }

    @Override
    public String toString(){
        return getData();
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(humanList);
    }
}
