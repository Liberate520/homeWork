package HomeWork3;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyFree implements Serializable
{
    private static List<Human> familyFree;
    
    public FamilyFree() 
    {
        familyFree = new ArrayList<>();
    }
    
    public static void addFamilyFree(Human human)
    {
        familyFree.add(human);
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

    public static List<Human> getFamilyFree() 
    {
        return familyFree;
    }

}
