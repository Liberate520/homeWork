package Homework.Human.Comparators;

import Homework.Human.Human;

import java.util.Comparator;

public class HumanComporatorByChildren implements Comparator<Human> {
    @Override
    public int compare(Human o1, Human o2) {return Integer.compare(o1.getChildren().size(), o2.getChildren().size());}
}
