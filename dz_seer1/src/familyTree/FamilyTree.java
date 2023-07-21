package familyTree;

import human.Human;

import java.io.Serializable;
import java.util.*;

public class FamilyTree implements Serializable, Iterable<Human> {
    private List<Human> humanList;
    //private Human root;

    public FamilyTree(){
        this(new ArrayList<>());
       // this.root = null;
    }
    public boolean add(Human human){
        if(human == null){
            return false;
        }
//        if(root == null){
//            root = human;
//            return true;
//        }
        if(!humanList.contains(human)){
            humanList.add(human);
            if(human.getFather() != null){
                human.getFather().addChild(human);
            }
            if(human.getMother() != null){
                human.getMother().addChild(human);
            }
            return true;
        }
        return false;
    }
    public Human getByName(String name){
        if (name == null){
            return null;
        }
        Iterator<Human> it = iterator();
        while (it.hasNext()){
            Human human = it.next();
            if(name.equals(human.getName())){
                return human;
            }
        }
        return null;
    }

    public  String getInfo(){
        StringBuilder sb = new StringBuilder();
        Iterator<Human> it = iterator();
        while (it.hasNext()){
            sb.append(it.next().getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }

    public void sortByName(){
        List<Human> list = new ArrayList<>();
        Iterator<Human> it = iterator();
        while (it.hasNext()){
            list.add(it.next());
        }
        Collections.sort(list, Comparator.comparing(Human::getName));
        root = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            Human parent = list.get(i);
            List<Human> children = new ArrayList<>();
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j).getFather() == parent || list.get(j).getMother() == parent){
                    children.add(list.get(j));
                }
            }
            parent.setChildren(children);
        }
    }

    public void sortByBirthDate(){
        List<Human> list = new ArrayList<>();
        Iterator<Human> it = iterator();
        while (it.hasNext()){
            list.add(it.next());
        }
        Collections.sort(list, Comparator.comparing(Human::getBirthDate));
        root = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            Human parent = list.get(i);
            List<Human> children = new ArrayList<>();
            for (int j = i+1; j < list.size(); j++) {
                if(list.get(j).getFather() == parent || list.get(j).getMother() == parent){
                    children.add(list.get(j));
                }
            }
            parent.setChildren(children);
        }
    }
    public FamilyTree(List<Human> humanList){
        this.humanList = humanList;
    }

    @Override
    public Iterator<Human> iterator() {
        return new FamilyTreeIterator(root);
    }
}
