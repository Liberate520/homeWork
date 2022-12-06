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
        this.getFamiliesStatistics();
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
        line.addPosition("Number of full families: " + this.db.getFullFamilies().size() + "\n");
        line.addPosition("Number of married people: " + married + "\n");
        line.addPosition("Number of single people: " + single + "\n");
        line.addPosition("Number of man: " + man + "\n");
        line.addPosition("Number of woman: " + woman + "\n" + "\n");
    }

    /*
    статистика по количеству детей в семьях
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
        line.addPosition("Families with 3 children - " + threeChildren + "\n" + "\n");
    }

    /*
    статистика по количеству потомков в семьях
     */
    public void getFamiliesStatistics() {
        this.sortByDescendants();
        int maxCount = families.get(families.size() - 1).getDescendants();
        int level75 = (maxCount * 3) / 4;
        int level50 = maxCount / 2;
        int level25 = maxCount / 4;
        int count75 = 0;
        int count50 = 0;
        int count25 = 0;
        int count0 = 0;
        int noCount = 0;
        for (Pair pair : families) {
            int count = pair.getDescendants();
            if (count >= level75) {
                count75++;
                continue;
            }
            if (count >= level50) {
                count50++;
                continue;
            }
            if (count >= level25) {
                count25++;
                continue;
            }
            if (count > 0) {
                count0++;
                continue;
            }
            noCount++;
        }
        line.addPosition("Biggest number of descendants: " + maxCount + "\n");
        line.addPosition("Number of families with descendants level N:\n");
        line.addPosition("max> N >75% - " + count75 + "\n");
        line.addPosition("75%> N >50% - " + count50 + "\n");
        line.addPosition("50%> N >25% - " + count25 + "\n");
        line.addPosition("25%> N >0%  - " + count0 + "\n");
        line.addPosition("No children - " + noCount + "\n" + "\n");
    }


    @Override
    public String getStats() {
        return this.stats;
    }

    public void sortByDescendants() {
        families.sort(new FamiliesDescendantsComparator());
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
