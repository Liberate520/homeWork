package familyTree.tree;

import familyTree.TreeItems;
import familyTree.person.ComparatorAge;
import familyTree.person.ComparatorGender;
import familyTree.person.ComparatorName;

import java.io.*;
import java.util.*;

public class Tree<E extends TreeItems> implements Serializable, Iterable<E> {
    private List<E> family;
    public Tree() {
        family= new ArrayList<>();
    }
    public void addPerson(E e){
        family.add(e);
//        if(e.getMother()!=null){
//            e.getMother().addChild(e);
//        }
//        if(e.getFather()!=null){
//            e.getFather().addChild(e);
//        }
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






}



