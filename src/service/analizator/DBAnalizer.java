package service.analizator;

import service.classes.Person;
import service.dataBase.DBHandler;

import java.util.ArrayList;
import java.util.Iterator;

import static service.classes.Gender.MALE;
import static service.classes.Marrige.YES;

public class DBAnalizer implements Iterable<Pair>, Analizer {

    private String stats;

    private final DBHandler db;
    private final ArrayList<Pair> families;
    StatWorker line = new StatWorker();

    @Override
    public void analyze() {
        line.addPosition("\n__________________________________DataBase statistics_________________________\n");
        this.getDBStats();
        this.getChildrenStatistics();

        this.stats = line.toString();
    }

    /*
    собирает общую статистику по базе
     */
    public void getDBStats() {
        int married = 0;
        int single = 0;
        int man = 0;
        int woman = 0;
        for (Person person : this.db) {
            if (person.getMarigeStatus() == YES) {
                married++;
            } else {
                single++;
            }
            if (person.getGender() == MALE) {
                man++;
            } else {
                woman++;
            }
        }
        line.addPosition("Size of DB = " + this.db.getDb().size() + "\n");
        line.addPosition("Number of families: " + this.db.getFullFamilies().size() + "\n");
        line.addPosition("Number of married people: " + married + "\n");
        line.addPosition("Number of single people: " + single + "\n");
        line.addPosition("Number of man: " + man + "\n");
        line.addPosition("Number of woman: " + woman + "\n");
    }

    /*
    статистика по количеству детей на семьях
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
        line.addPosition("Families with 0 children - " + noChildren + "\n");
        line.addPosition("Families with 1 children - " + oneChild + "\n");
        line.addPosition("Families with 2 children - " + twoChildren + "\n");
        line.addPosition("Families with 3 children - " + threeChildren + "\n");
    }


    @Override
    public String getStats() {
        return this.stats;
    }

    @Override
    public Iterator<Pair> iterator() {
        return new PairIterator(families);
    }


    public DBAnalizer(DBHandler db) {
        ArrayList<Pair> families = new ArrayList<>();
        for (Person[] family : db.getFamilies()) {
            families.add(new Pair(family));
        }
        this.families = families;
        this.db = db;
    }
}
