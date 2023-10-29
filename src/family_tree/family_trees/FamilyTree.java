package family_tree.family_trees;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree.human.comparators.HumanComparatorByAge;
import family_tree.human.comparators.HumanComparatorByName;

public class FamilyTree<E extends TreeItem> implements Serializable, Iterable<E>{
    private List<E> humanstList;
    private int humansID;
    public FamilyTree() 
    {
        humanstList = new ArrayList<>();
    }
    public List<E> getPeopleSByName(String name)
    {
        List<E> humansFaundList = new ArrayList<>();
        for(E people: humanstList)
        {
            if(people.getName().equals(name))
            {
                humansFaundList.add(people);
            }
        }
        return humansFaundList;
    }

    public void addHuman(E people)
    {
        if(!humanstList.contains(people))
        {
            humanstList.add(people);
            people.setID(humansID ++);

 //           addChildToParents(people);
        }
    }

    // private void addChildToParents (E people)
    // {
    //     for(E parent : people.getParents())
    //     {
    //         parent.addChild(people);
    //     }
    // }
    public String getHumansListInfo()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей: \n");
        for(E people: humanstList)
        {
            stringBuilder.append(people);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        humanstList.sort(new HumanComparatorByName<>());
    }

    public void sortByAge(){
        humanstList.sort(new HumanComparatorByAge<>());
    }

    @Override
    public Iterator<E> iterator() {
        return new HumanIterator<>(humanstList);
    }
}