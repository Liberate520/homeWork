package model.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import model.Comparator.IdComparator;
import model.Iterator.HumanIterator;
import model.Persons.Person;

public class FamilyTree<T extends Person> implements Serializable, Iterable<T>
{  
    private ArrayList t;
    private ArrayList<T> familyTree = new ArrayList<>();
    
    @Override
    public String toString() 
    {
        return familyTree.toString();
    }

    @Override
    public Iterator<T> iterator()
    {
        return new HumanIterator(t);
    }

    public void add(T person) 
    {
       familyTree.add(person);
    }


    public int size() 
    {
        return familyTree.size();
    }

    public Object get(int i) {
        return familyTree.get(i);
    }
    public Object getLastName()
    {
        return getLastName();
    }
    public Object getFirstName()
    {
        return getFirstName();
    }

    public void sort(IdComparator idComparator) 
    {
    }
}
