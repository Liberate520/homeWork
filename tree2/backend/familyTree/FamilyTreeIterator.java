package homeWork.tree2.backend.familyTree;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyTreeIterator<HumanObjectInterface> implements Iterator<HumanObjectInterface> {

    private int index;
    public ArrayList<HumanObjectInterface> familyTree;


    public FamilyTreeIterator(ArrayList<HumanObjectInterface> familyTree) {
        this.familyTree = familyTree;
    }

    @Override
    public boolean hasNext() {
        return index < familyTree.size();
    }

    @Override
    public HumanObjectInterface next() {
        return familyTree.get(index++);
    }
}


/*
Заменил параметр итератора с неопределенного класса E на параметр HumanObjectInterface
т.к. наше семейное древо работает исключетельно с типом, наследуемым (имплементированным)
 от интерфейса HumanObjectInterface
 */
