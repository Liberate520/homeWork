package family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable{
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
}