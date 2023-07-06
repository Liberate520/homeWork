package familyTree.Human.Comporator;
import familyTree.Human.Human;

import java.util.Comparator;

public class humanComporatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getAge() - o2.getAge();
    }
}
