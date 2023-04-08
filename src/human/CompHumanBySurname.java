package human;

import java.util.Comparator;

public class CompHumanBySurname  implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return o1.getSurname().compareTo(o2.getSurname());
    }
}
