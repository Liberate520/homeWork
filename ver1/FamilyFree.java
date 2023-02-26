package HomeWork3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import HomeWork3.comporator.HumanIterator; // 

public class FamilyFree implements Serializable,Iterable<Human> //
{
    private static List<Human> familyFree;
    
    public FamilyFree() 
    {
        familyFree = new ArrayList<>();
    }
    
    public static void addFamilyFree(Human human)
    {
        if (!familyFree.contains(human))
        {
            familyFree.add(human);
            if (human.getMather() != null)
            {
                human.getMather().addChild(human);
            }
            if (human.getFather() != null)
            {
                human.getFather().addChild(human);
            }
        }
    }   

    @Override
    public String toString() 
    {
        String res = "В семье " + familyFree.size() + " человек:\n";
        for (int i = 0; i < familyFree.size(); i++) 
        {
            res += (i+1) + ") " + familyFree.get(i).toString() + "\n";
        }
        return res;
    }

    public Human getByName(String nameHuman)
    {
        for (Human human: familyFree)
        {
            if (human.getName().equalsIgnoreCase(nameHuman))
            {
                return human;
            }
        }
        return null;
    }

    public static List<Human> getFamilyFree() 
    {
        return familyFree;
    }

    @Override
    public Iterator<Human> iterator() 
    {
        return new HumanIterator(familyFree);
        //return familyFree.iterator();         // вариант реализации без класса :)
    }

}
