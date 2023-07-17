package OopJava.Tree;

import OopJava.Human.Human;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Iterator;

public class FamilyTree<E extends Human> implements Serializable, Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        return new HumanIterator<E>(humans);
    }

    private List<E> humans;
    public FamilyTree() {
        this(new ArrayList<>());
    }
    private FamilyTree(List<E> humans) {
        this.humans = humans;
    }
    public void add(E human) {
        humans.add(human);
    }
    public List<E> getPersonList() {
        return humans;
    }
    public List<E> getInfo() {
        List result = new ArrayList();
        String info;
        for (int i = 0; i < humans.size(); i++) {
            info = humans.get(i).toString();
            result.add(info);
            result.add("\n");
        }
        return result;
    }

    public Human getByName(String name){
        Human result = null;
        for (int i = 0; i < humans.size(); i++) {
            if (this.humans.get(i).getName().equals(name))
                result = this.humans.get(i);
        }
        return result;
    }

    public List <E> getChilds(String name){
        List<E> childs = new ArrayList();
        for (int i = 0; i < humans.size(); i++) {
            if (this.humans.get(i).getFather() != null) if (this.humans.get(i).getFather().getName().equals(name)) {
                childs.add(this.humans.get(i));
            }
            if (this.humans.get(i).getMother() != null) {
                if (this.humans.get(i).getMother().getName().equals(name)) {
                    childs.add(this.humans.get(i));
                }
            }
            if (this.humans.get(i).getMother() != null) {
                if (this.humans.get(i).getMother().getName().equals(name)) {
                    childs.add(this.humans.get(i));
                }
            }
        }
        return childs;
    }
}


