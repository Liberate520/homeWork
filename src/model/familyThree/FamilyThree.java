package model.familyThree;

import model.familyThree.comparators.HumanCompotatorByBirtday;
import model.familyThree.comparators.HumanCompotatorByName;
import model.familyThree.iteration.FamilyThreeIterator;
import model.human.Gender;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class FamilyThree<E extends FamilyThreeElement<E>> implements Iterable<E> {
    private ArrayList<E> familyMembers;
    private double lastMarriageId = 1;
    public FamilyThree()
    {
        familyMembers = new ArrayList<>();
    }
    public ArrayList<E> getAllFamilyMembers()
    {
        return familyMembers;
    }
//    public void setLinkParentsMother( E mother, E child )
//    {
//        // Установить детско-родительскую связь (мать)
//        mother.addChild( child );
//        child.setMother( mother );
//    }
//    public void setLinkParentsFather( E father, E child )
//    {
//        // Установить детско-родительскую связь (мать)
//        father.addChild( child );
//        child.setFather( father );
//    }
    public void setLinkParent( E parent, E child )
    {
        parent.addChild( child );
        if ( parent.getGender() == Gender.female ) child.setMother( parent );
        else child.setFather( parent );
    }

//    public void setInfoAboutNewMarriage(
//            E firstHuman,
//            E secondHuman,
//            Date dateMarriage,
//            Date dateDivorce
//    )
//    {
//        // Новая брачная связь
//        Marriage infoAboutMarriage = new Marriage(
//                lastMarriageId,
//                dateMarriage,
//                firstHuman,
//                secondHuman,
//                null
//        );
//        firstHuman.addMarriage( infoAboutMarriage );
//        secondHuman.addMarriage( infoAboutMarriage );
//        lastMarriageId++;
//    }
    public Set<E> getChildren(E human )
    {
        return human.getChildren();
    }

    public ArrayList<E> getFamilyMembers() {
        return familyMembers;
    }

    @Override
    public Iterator<E> iterator() {
        return new FamilyThreeIterator<>( familyMembers );
    }
    public void sortByFirstName()
    {
        familyMembers.sort( new HumanCompotatorByName());
    }
    public void sortByBirthday()
    {
        familyMembers.sort( new HumanCompotatorByBirtday<>());
    }
}
