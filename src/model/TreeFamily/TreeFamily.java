package model.TreeFamily;

import model.human.Human;
import model.human.HumanIterator;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TreeFamily<E extends Human> implements Iterable<E>, Serializable{//extends Tree <E>
    public List<E> list;


    //Конструктор для создания дерева
    public TreeFamily(List<E> list) {

        this.list = list;
    }


    //Пустой конструктор
    public TreeFamily() {

        list = new ArrayList<>();
    }

    //Метод добавления человека в дерево по имени и фамилии
    public void addHuman(String family, String name) {
        E human = (E) new Human(family, name);
        list.add(human);
    }

    public boolean add (E human) {
            if (human == null) {
                return false;
            }
            if (!list.contains(human)) {
                list.add(human);
                if (human.getFather() != null) {
                    human.getFather().addChildrenList(human);
                }
                if (human.getMother() != null) {
                    human.getMother().addChildrenList(human);
                }
                return true;
            }
            return false;
        }

    //Возвращает дерево
    public List<E> getList() {
        return list;
    }

    public E getByMather(String family, String name) {
        E human = (E) new Human(family, name);
        for (E hum : list) {
            if (hum.equals(human)) {
                if (hum.getMother() != null){
                    return (E) hum.getMother();
                }
                else {
                    return null;
                }

            }
        }
        return null;
    }

    public E getByHuman (String family, String name){
        E human = (E) new Human(family, name);
        for (E hum: list){
            if (human.equals(hum)){
                return hum;
            }

        }
        return null;
    }

    public void addKid(E kid) {
        for (E hum : list) {
            if (kid.getMother().equals(hum)
                    || kid.getFather().equals(hum)) {
                hum.addChildrenList(kid);
            }
        }
    }


    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве объектов - ");
        sb.append(list.size());
        sb.append(":\n");
        for (E hum: list){
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
