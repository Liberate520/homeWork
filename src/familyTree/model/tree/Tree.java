package familyTree.model.tree;

import familyTree.model.TreeItems;
import familyTree.model.person.ComparatorAge;
import familyTree.model.person.ComparatorGender;
import familyTree.model.person.ComparatorName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree<E extends TreeItems> implements Serializable, Iterable<E> {
    private List<E> family;
    public Tree() {
        family= new ArrayList<>();
    }
    public boolean addPerson(E e){
        if (e==null){
            return false;
        }
        family.add(e);
        if(e.getMother()!=null){
            e.getMother().addChild(e);
        }
        if(e.getFather()!=null){
            e.getFather().addChild(e);
        }
        return true;
    }

    public  String getParents(E e){
        String mother=new String();
        String father=new String();

        for (E relative:family) {
            try {
                if (relative.hashCode() == e.getMother().hashCode()) {
                    mother = relative.getName();
                }
                if (relative.hashCode() == e.getFather().hashCode()) {
                    father = relative.getName();
                }
            } catch (NullPointerException y) {

            }
        }
        return "mother: "+ mother + " father: "+ father;
    }

    public  String getChildren(E e) {
        StringBuilder children = new StringBuilder();

        for (E x : family) {
            try {
                if (e.hashCode() == x.getMother().hashCode() || e.hashCode() == x.getFather().hashCode()) {
                    children.append(x.getName()+"\n");
                }
            } catch (NullPointerException y) {
            }
        }
        String res = children.toString();
        return "children: \n" + res;
    }

    public  String getGrandParents(E e){
        StringBuilder grandparents=new StringBuilder();

        for (E x:family) {
            try {
                if (x.hashCode() == e.getMother().hashCode()) {
                    grandparents.append(x.getMother().getName() + "\n").append(x.getFather().getName() + "\n");
                }
                if (x.hashCode() == e.getFather().hashCode()) {
                    grandparents.append(x.getMother().getName() + "\n").append(x.getFather().getName() + "\n");
                }
            } catch (NullPointerException y) {
            }
        }
        String res=grandparents.toString();
        return "grandparents: \n"+res;

    }

    public String getInfoTree(){
        StringBuilder info=new StringBuilder();
        info.append("В дереве: ");
        info.append(family.size());
        info.append("объектов: \n");
        for (E e:family){
            info.append(e.getInfo());
            info.append("\n");
        }
        return info.toString();
    }

    @Override
    public Iterator<E> iterator(){
        return new TreeIterator<E>(family);
    }

    public void sortName(){
        family.sort(new ComparatorName());
    }

    public void sortAge(){
        family.sort(new ComparatorAge());
    }

    public void sortGender(){
        family.sort(new ComparatorGender());
    }

    public E search (String e){
        for (E x : family) {
            try {
                if (x.getName().equals(e)) {
                    return x;
                }
            } catch (NullPointerException y) {
            }
        }
        return null;
    }







}



