package Seminars_OOP.HW_3;


import java.util.Comparator;

public class CorparatorByAge implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getYearOfBirth(), o2.getYearOfBirth());
    }
    
}
