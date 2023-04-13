package model.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Persons.Person;
public class HumanIterator<T> implements Iterator<T> 
{
    private int index;
    private List<T> familyTree;

    public HumanIterator(ArrayList<T> familyTree)
    {
        this.familyTree = familyTree;
    }
    @Override
    public boolean hasNext() 
    {
        return index < familyTree.size();
    }

    @Override
    public T next() 
    {
        return familyTree.get(index++);
    }
}    
