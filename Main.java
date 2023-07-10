package homeWork;

import java.time.LocalDate;

public class Main {
     public static void main(String[] args){
        FamilyTree tree = new FamilyTree();
        tree.add(new Human("Андрей",Gender.Male, LocalDate.of(1980, 12, 10), tree.getByName("Андрей"), tree.getByName("Мария")));
        tree.add(new Human("Мария", Gender.Female, LocalDate.of(1985, 9, 15), tree.getByName("Василий"), tree.getByName("Мария")));
        tree.add(new Human("Кристина", Gender.Female, LocalDate.of(2008, 7, 5),
        tree.getByName("Андрей"), tree.getByName("Мария")));
        tree.add(new Human("Никита", Gender.Male, LocalDate.of(2011, 1, 25),
        tree.getByName("Андрей"), tree.getByName("Мария")));
            System.out.println(tree.getInfo());
        }
        
}
