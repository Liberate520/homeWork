//package service.analizator;
//
//import service.classes.Person;
//import service.dataBase.DBHandler;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//
//public class FamilyAnalizer extends PersonAnalizer{
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
//    public FamilyAnalizer(Person person) {
//        super(person);
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
//
//
//}
