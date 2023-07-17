package FamilyTree.Model.tree;

import FamilyTree.Model.sort.AgeComparator;
import FamilyTree.Model.sort.NameComparator;
import FamilyTree.Model.sort.PersonIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree <E extends Being>implements Serializable, Iterable <E> {

    private List<E> treeList;

    public Tree() {this(new ArrayList<>()); }

    public Tree(List<E> treeList)  {this.treeList=treeList;}

    public boolean addPerson (E person){
        if (person == null) { return false;}
        if (!treeList.contains(person)){
            treeList.add (person);
            addToParents(person);
            addToChild(person);
            return  true;
        }
        return false;

    }
    private void addToParents(E person){
        if (person.getMother()!= null){
            person.getMother().addChild(person);}
        if (person.getFather()!= null){
            person.getFather().addChild(person);}

    }

    private void addToChild (E person){
        for (Object child :person.getChildren()){

            ((Person)(child)).addParent(person);}
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(treeList.size());
        sb.append(" объектов: \n");
        for (E person : treeList){
            sb.append(person);
            sb.append("\n");
        }
    return sb.toString();
    }
    public  E getByName (String name){
        for (E person: treeList){
            if (person.getName().equals(name)){return person;}

        }
        return null;
    }


    public void sortAge() {
        treeList.sort(new AgeComparator());

    }
    public void sortName() {
        treeList.sort(new NameComparator());

    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator(treeList);
    }

}
