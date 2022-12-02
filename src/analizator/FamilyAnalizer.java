package analizator;

import classes.Person;
import dataBase.DataBase;

import java.util.ArrayList;
import java.util.Iterator;

public class FamilyAnalizer implements Iterable<Pair>, Analizer {
    private final ArrayList<Pair> families;
    private String stats;

    @Override
    public String getStats() {
        return stats;
    }



    public FamilyAnalizer(DataBase db) {
        ArrayList<Pair> families = new ArrayList<>();
        for (Person[] family : db.getFamilies()) {
            families.add(new Pair(family));
        }
        this.families = families;
    }

    /*
    статистика по количеству детей на семью
     */
    public void getChildrenStatistics() {
        StatWorker line = new StatWorker();
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
        line.addPosition("Families with 0 children - " + noChildren);
        line.push();
        line.addPosition("Families with 1 children - " + oneChild);
        line.push();
        line.addPosition("Families with 2 children - " + twoChildren);
        line.push();
        line.addPosition("Families with 3 children - " + threeChildren);
        line.push();
        this.stats = line.toString();
    }

    public void sortByDescendants() {
        families.sort(new FamiliesDescendantsComparator());
    }

    @Override
    public Iterator<Pair> iterator() {
        return new FamiliesIterator(families);
    }

}
