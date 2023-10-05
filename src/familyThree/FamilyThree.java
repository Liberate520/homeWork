package familyThree;

import human.Human;
import human.Marriage;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class FamilyThree implements Iterable<Human> {
    private ArrayList<Human> familyMembers;
    private double lastMarriageId = 1;
    public FamilyThree()
    {
        familyMembers = new ArrayList<>();
    }
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

    @Override
    public Iterator<Human> iterator() {
        return null;
    }
}
