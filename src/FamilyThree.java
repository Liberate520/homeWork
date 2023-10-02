import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FamilyThree {
    private ArrayList<Human> familyMembers;
    public FamilyThree()
    {
        familyMembers = new ArrayList<>();
    }
    public ArrayList<Human> getAllFamilyMembers()
    {
        return familyMembers;
    }
    public void setLinkParents()
    {
        // Установить детско-родительскую связь
    }
    public void setLinkNewMarriage()
    {
        // Новая брачная связь
    }
    public Set<Human> getChildren(Human human )
    {
        return human.getChildren();
    }
}
