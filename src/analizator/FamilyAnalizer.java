package analizator;

import classes.Parent;
import dataBase.DataBase;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyAnalizer implements Iterable<Pair>{
    ArrayList<Pair> families;

    public FamilyAnalizer(DataBase db) {
        ArrayList<Pair> families = new ArrayList<>();
        for (Parent[] family : db.getFamilies()) {
            families.add(new Pair(family));
        }
        this.families = families;
    }

    /*
    статистика по количеству детей на семью
     */
    public void getChildrenStatistics() {
        int noChildren = 0;
        int oneChild = 0;
        int twoChildren = 0;
        int threeChildren = 0;
        for (Pair family : families) {
            int number = family.getPair()[0].getChildrenCount();
            switch (number) {
                case 1 -> oneChild++;
                case 2 -> twoChildren++;
                case 3 -> threeChildren++;
                default -> noChildren++;
            }
        }
        System.out.printf("Families with 0 children - %d\n", noChildren);
        System.out.printf("Families with 1 children - %d\n", oneChild);
        System.out.printf("Families with 2 children - %d\n", twoChildren);
        System.out.printf("Families with 3 children - %d\n", threeChildren);
    }

    public void sortByDescendants() {
        families.sort(new FamiliesDescendantsComparator());
    }

    @Override
    public Iterator<Pair> iterator() {
        return new FamiliesIterator(families);
    }
}
