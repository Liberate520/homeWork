package family_tree.family_trees;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import family_tree.human.Human;
import family_tree.human.comparators.HumanComparatorByAge;
import family_tree.human.comparators.HumanComparatorByName;

public class FamilyTree implements Serializable, Iterable<Human>{
    private List<Human> humanstList;
    private int humansID;
    public FamilyTree() 
    {
        humanstList = new ArrayList<>();
    }
    public List<Human> getPeopleSByName(String name)
    {
        List<Human> humansFaundList = new ArrayList<>();
        for(Human people: humanstList)
        {
            if(people.getName().equals(name))
            {
                humansFaundList.add(people);
            }
        }
        return humansFaundList;
    }

    public void addHuman(Human people)
    {
        if(!humanstList.contains(people))
        {
            humanstList.add(people);
            people.setID(humansID ++);

            addChildToParents(people);
        }
    }

    private void addChildToParents (Human people)
    {
        for(Human parent : people.getParents())
        {
            parent.addChild(people);
        }
    }
    public String getHumansListInfo()
    {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список людей: \n");
        for(Human people: humanstList)
        {
            stringBuilder.append(people);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void sortByName(){
        humanstList.sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        humanstList.sort(new HumanComparatorByAge());
    }

    @Override
    public Iterator<Human> iterator() {
        return new HumanIterator(humanstList);
    }
}