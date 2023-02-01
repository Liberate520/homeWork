package serviceCompares;

import java.util.Comparator;
import java.util.Map;

import models.Human;

public class HunamComparatorBySecondName<T extends Human> implements Comparator<Map.Entry<String, T>> {

    @Override
    public int compare(Map.Entry<String, T> o1, Map.Entry<String, T> o2) {
        return (o1.getValue().getSecondName()).compareTo(o2.getValue().getSecondName());
    }
}
