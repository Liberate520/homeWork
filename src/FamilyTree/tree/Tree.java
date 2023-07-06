package FamilyTree.tree;

import FamilyTree.sort.AgeComparator;
import FamilyTree.sort.NameComparator;
import FamilyTree.sort.PersonIterator;
import FamilyTree.tree.Person;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Tree implements Serializable, Iterable <Person> {

    private List<Person> treeList;

    public Tree() {this(new ArrayList<>()); }

    public Tree(List<Person> treeList)  {this.treeList=treeList;}

    public boolean addPerson (Person person){
        if (person == null) { return false;}
        if (!treeList.contains(person)){
            treeList.add (person);
            addToParents(person);
            addToChild(person);
            return  true;
        }
        return false;

    }
    private void addToParents(Person person){
        if (person.getMother()!= null){
            person.getMother().addChild(person);}
        if (person.getFather()!= null){
            person.getFather().addChild(person);}

    }
    private void addToChild(Person person){
        for (Person child :person.getChildren()){

            child.addParent(person);}
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве ");
        sb.append(treeList.size());
        sb.append(" объектов: \n");
        for (Person person : treeList){
            sb.append(person);
            sb.append("\n");
        }
    return sb.toString();
    }
    public  Person getByName (String name){
        for (Person person: treeList){
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
    public Iterator<Person> iterator() {
        return new PersonIterator(treeList);
    }
}
