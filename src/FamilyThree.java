import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FamilyThree {
    private ArrayList<Human> familyMembers;
    public FamilyThree()
    {
        familyMembers = new ArrayList<>();
    }
    double lastMarriageId = 1;
    public ArrayList<Human> getAllFamilyMembers()
    {
        return familyMembers;
    }
    public void setLinkParentsMother( Human mother, Human child )
    {
        // Установить детско-родительскую связь (мать)
        mother.addChild( child );
        child.setMother( mother );
    }
    public void setLinkParentsFather( Human father, Human child )
    {
        // Установить детско-родительскую связь (мать)
        father.addChild( child );
        child.setFather( father );
    }

    public void setInfoAboutNewMarriage(
            Human firstHuman,
            Human secondHuman,
            Date dateMarriage,
            Date dateDivorce
    )
    {
        // Новая брачная связь
        Marriage infoAboutMarriage = new Marriage(
                lastMarriageId,
                dateMarriage,
                firstHuman,
                secondHuman,
                null
        );
        firstHuman.addMarriage( infoAboutMarriage );
        secondHuman.addMarriage( infoAboutMarriage );
        lastMarriageId++;
    }
    public Set<Human> getChildren(Human human )
    {
        return human.getChildren();
    }
}
