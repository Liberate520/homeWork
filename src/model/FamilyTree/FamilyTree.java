package model.FamilyTree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import model.Comparator.IdComparator;
import model.Comparator.NameComparator;
import model.Iterator.HumanIterator;
import model.Persons.Human;
import model.Persons.Others;
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

    public void sortById(FamilyTree familyTree) 
    {
        ((List) familyTree).sort(new IdComparator());
    }

    public void sortByLastName(FamilyTree familyTree) 
    {
        ((List) familyTree).sort(new NameComparator());
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

    public static void addPerson(Person person, FamilyTree familyTree) {
    }

    public FamilyTree getFamilyTree(FamilyTree familyTree)
    {
        return familyTree;
    }
}
