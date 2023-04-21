package service;

import human.Human;

import java.util.Comparator;

public class HumanComporatorByDate implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {
        return o1.getDate_of_birth().compareTo(o2.getDate_of_birth());
    }
}
