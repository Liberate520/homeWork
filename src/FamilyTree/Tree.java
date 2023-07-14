package FamilyTree;

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class Tree<E extends Human> implements Serializable, Iterable<E> {
    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<E>(humans);
    }

    private List<E> humans;
    public Tree() {
        this(new ArrayList<>());
    }
    private Tree(List<E> humans) {
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
        }
        return result;
    }

        public Human getByName(String name){
            for (int i = 0; i < humans.size(); i++) {
                if (this.humans.get(i).getName().equals(name))
                    result = this.humans.get(i);}
            
            return result;
        }

        public List <E> getChildren(String name){
            List<E> kids = new ArrayList();
            for (int i = 0; i < humans.size(); i++) {
                if (this.humans.get(i).getFather() != null) if (this.humans.get(i).getFather().getName().equals(name)) {
                    kids.add(this.humans.get(i));
                }
                if (this.humans.get(i).getMother() != null) {
                    if (this.humans.get(i).getMother().getName().equals(name)) {
                        kids.add(this.humans.get(i));
                    }
                }
                if (this.humans.get(i).getMother() != null) {
                    if (this.humans.get(i).getMother().getName().equals(name)) {
                        kids.add(this.humans.get(i));
                    }
                }
            }
            return kids;
        }
    }