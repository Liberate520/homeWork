package model.TreeFamily;

import model.human.Human;
import model.human.HumanIterator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeFamily <E extends Human> implements Iterable<E>, Serializable{//extends Tree <E>
    public List<E> list;

    public TreeFamily(List<E> list) {
        this.list = list;
    }


    public TreeFamily() {
        list = new ArrayList<>();
    }

    public void addHuman(E human) {

        if (!list.contains(human)) {
            list.add(human);
            if (human.getFather() != null) {
                human.getFather().addChildrenList(human);
            }
            if (human.getMother() != null) {
                human.getMother().addChildrenList(human);
            }
        }
    }


        public boolean add (E human){
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

//    public void addHuman(model.human.Human model.human) {

//            if (!(human1.equals(model.human))) {
//                list.add(model.human);
////                System.out.printf("%s %s добавлен в генеалогическое древо.");
////            } else {
////                System.out.printf("%s %s уже добавлен в генеалогическое древо.");
////            }
//            }
//        }
//    }

//    public void addHuman(model.human.Human model.human) {
//        list.add(model.human);
//    }

    public Human getByMather(Human human) {
        for (Human hum : list) {
            if (hum.getMother().equals(human.getMother())) {
                return hum;
            }
        }
        return null;
    }

    public Human getByHuman ( Human human){
        for (Human hum: list){
            if (human.equals(hum)){
                return hum;
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

    public List<E> getList() {
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
//        return "model.TreeFamily.model.TreeFamily{" +
//                "list=" + list +
//                '}';
        return this.getInfo();
    }



    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<E>(list);
    }

}
