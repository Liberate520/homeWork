package TreeFamily;

import human.Human;
import human.HumanIterator;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeFamily implements Iterable<Human>, Serializable{
    public List<Human> list;

    public TreeFamily() {
        list = new ArrayList<>();
    }

    public boolean add(Human human){
        if (human== null) {
            return false;
        }
        if (!list.contains(human)){
            list.add(human);
            if (human.getFather() != null){
                human.getFather().addChildrenList(human);
            }
            if (human.getMother() != null){
                human.getMother().addChildrenList(human);
            }
            return true;
        }
        return false;

    }

//    public void addHuman(human.Human human) {

//            if (!(human1.equals(human))) {
//                list.add(human);
////                System.out.printf("%s %s добавлен в генеалогическое древо.");
////            } else {
////                System.out.printf("%s %s уже добавлен в генеалогическое древо.");
////            }
//            }
//        }
//    }

//    public void addHuman(human.Human human) {
//        list.add(human);
//    }

    public Human getByMather(Human human) {
        for (Human hum : list) {
            if (hum.getMother().equals(human.getMother())) {
                return hum;
            }
        }
        return null;
    }

    public Human getByHuman(Human human){
        for (Human hum: list){
            if (human.equals(hum)){
                return human;
            }
        }
        return null;
    }


    public void addKid(Human kid) {
        for (Human hum : list) {
            if (kid.getMother().equals(hum)
                    || kid.getFather().equals(hum)) {
                hum.addChildrenList(kid);
            }
        }
    }

    public List<Human> getList() {
        return list;
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве объектов - ");
        sb.append(list.size());
        sb.append(":\n");
        for (Human hum:list){
            sb.append(hum.getInfo());
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "TreeFamily.TreeFamily{" +
                "list=" + list +
                '}';
    }

    public void save(Writable writable) throws IOException {
        writable.save(this);

    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(list);
    }



}
