package family_tree.model.family_trees;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree.model.comparators.ComparatorByAge;
import family_tree.model.comparators.ComparatorByName;
import family_tree.model.family_trees.iterators.ProbandIterator;

public class FamilyTree<E extends TreeItem<E>> implements Serializable, Iterable<E>{
    private List<E> probandList;
    private int probandID;
    public FamilyTree() 
    {
        probandList = new ArrayList<>();
    }
    public List<E> getProbandByName(String name)
    {
        List<E> humansFaundList = new ArrayList<>();
        for(E proband: probandList)
        {
            if(proband.getName().equals(name))
            {
                humansFaundList.add(proband);
            }
        }
        return humansFaundList;
    }

    public void addProband(E proband)
    {
        if(!probandList.contains(proband))
        {
            probandList.add(proband);
            proband.setID(probandID ++);

            addChildToParents(proband);
        }
    }

    private void addChildToParents (E child)
    {
        for(E parent : child.getParents())
        {
            parent.addChild(child);
        }
    }

    public void addMotherToChild(E mother, E child)
    {
        child.addMother(mother);
        addChildToParents(child);
    }

    public void addFatherToChild(E father, E child)
    {
        child.addFather(father);
        addChildToParents(child);
    }

    public String getProbandsListInfo()
    {
        StringBuilder stringBuilder = new StringBuilder();
        int index = 1;
        for(E people: probandList)
        {
            stringBuilder.append(index);
            stringBuilder.append(" .");
            stringBuilder.append(people);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public E getProbandFromList(int index)
    {
        return probandList.get(index);
    }

    public int getFamilyListSize()
    {
        return probandList.size();
    }

    public void sortByName(){
        probandList.sort(new ComparatorByName<>());
    }

    public void sortByAge(){
        probandList.sort(new ComparatorByAge<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new ProbandIterator<>(probandList);
    }
}