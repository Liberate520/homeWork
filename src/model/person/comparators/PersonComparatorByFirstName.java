package model.person.comparators;

import model.interfaces.Anthropoid;

import java.io.Serializable;
import java.util.Comparator;


/**
 * Помимо основных сравниваемых полей прописываем и остальные, чтобы во множество TreeSet
 * могли попасть все записи. Без сравнения остальных полей в TreeSet не попали бы личности
 * с одинаковым именем, фамилией или возрастом (в зависимости от выбранного компаратора).
 */
public class PersonComparatorByFirstName<E extends Anthropoid> implements Serializable, Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        int firstStage = o1.getFirstName().compareTo(o2.getFirstName());
        if (firstStage == 0) {
            int secondStage = o1.getLastName().compareTo(o2.getLastName());
            if (secondStage == 0) {
                int thirdStage = Integer.compare(o1.getAge(), o2.getAge());
                return thirdStage;
            }
            return secondStage;
        }
        return firstStage;
    }
}
