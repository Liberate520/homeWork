package familyTree.Human.Comporator;

import familyTree.Human.Human;

import java.util.Comparator;

public class humanComporatosByName implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
