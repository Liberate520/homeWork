package familyThree.iteration;

import human.Human;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyThreeIterator implements Iterator<Human> {
    private ArrayList<Human> familyMembers;
    private int i = 0;

    public FamilyThreeIterator( ArrayList<Human> familyMembers )
    {
        this.familyMembers = familyMembers;
    }

    @Override
    public boolean hasNext() {
        return i < familyMembers.size();
    }

    @Override
    public Human next() {
        return familyMembers.get( this.i++ );
    }
}
