
import person.Person;
import person.PersonIterator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import comporator.PersonComporatorByChild;
import comporator.PersonComporatorByName;

public class FamilyTree<E extends Person> implements Serializable, Iterable<E>{
    private List<E> familyTree;
    public FamilyTree(List<E> familyTree) {
        this.familyTree = familyTree;
    }
    public  FamilyTree()
    {
        this(new ArrayList<>());
    }

    public List<E> getFamilyTree() {
        return familyTree;
    }

    public boolean addMember(E newPerson) {
        if (newPerson==null){
            return false;
        }
        this.familyTree.add(newPerson);
        if (newPerson.getFather()!=null)
        {
            newPerson.getFather().addChild(newPerson);
        }
        if (newPerson.getMother()!=null)
        {
            newPerson.getMother().addChild(newPerson);
        }
        return true;
    }

    public E getByName(String fio)
    {
    for (E person : familyTree) {
        if (person.getName().equals(fio))
        {
            return person;
        }
    }
    return null;
    }
    public String getInfo()
    {
        StringBuilder sb =new StringBuilder();
        sb.append(" Семья состоит из:");
        sb.append("\n");
        for (E person:familyTree) {
            sb.append(person.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
    public E find(String name)
    {
        for (E person: familyTree) {
            if(person.getName().equals(name))
            {return person; }
        } return null;
    }
    @Override
    public String toString() {
        return familyTree.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new PersonIterator<E>(familyTree);
    }
    public void sortByName(){
        familyTree.sort(new PersonComporatorByName());
    }
    public void sortByChild(){
        familyTree.sort(new PersonComporatorByChild());
    }
}