//package service.analizator;
//
//import service.classes.Person;
//import service.dataBase.DBHandler;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class FamilyAnalizer implements Iterable<Pair>, Analizer {
//    private final ArrayList<Pair> families;
//    private String stats;
//
//    @Override
//    public void analyze() {
//
//    }
//
//    @Override
//    public String getStats() {
//        return stats;
//    }
//
//
//
//    public FamilyAnalizer(DBHandler db) {
//        ArrayList<Pair> families = new ArrayList<>();
//        for (Person[] family : db.getFamilies()) {
//            families.add(new Pair(family));
//        }
//        this.families = families;
//    }
//
//    /*
//    статистика по количеству детей на семью
//     */
//    public void getChildrenStatistics() {
//        StatWorker line = new StatWorker();
//        int noChildren = 0;
//        int oneChild = 0;
//        int twoChildren = 0;
//        int threeChildren = 0;
//        for (Pair family : families) {
//            int number = family.getPair()[0].getChildrenCount();
//            switch (number) {
//                case 1 -> oneChild++;
//                case 2 -> twoChildren++;
//                case 3 -> threeChildren++;
//                default -> noChildren++;
//            }
//        }
//        line.addPosition("Families with 0 children - " + noChildren + "\n");
//        line.addPosition("Families with 1 children - " + oneChild + "\n");
//        line.addPosition("Families with 2 children - " + twoChildren + "\n");
//        line.addPosition("Families with 3 children - " + threeChildren + "\n");
//        this.stats = line.toString();
//    }
//
//    public void sortByDescendants() {
//        families.sort(new FamiliesDescendantsComparator());
//    }
//
//    @Override
//    public Iterator<Pair> iterator() {
//        return new PairIterator(families);
//    }
//
//}
