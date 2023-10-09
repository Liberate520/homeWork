package familyThree.iteration;

import familyThree.FamilyThreeElement;
import human.Human;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyThreeIterator<E extends FamilyThreeElement<E>> implements Iterator<E> {
    private ArrayList<E> familyMembers;
    private int i = 0;

    public FamilyThreeIterator( ArrayList<E> familyMembers )
    {
        this.familyMembers = familyMembers;
    }

    @Override
    public boolean hasNext() {
        return i < familyMembers.size();
    }

    @Override
    public E next() {
        return familyMembers.get( this.i++ );
    }
}
