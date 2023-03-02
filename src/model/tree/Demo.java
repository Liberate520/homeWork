package model.tree;

import java.time.LocalDate;

import model.entity.Person;
import model.entity.Sex;
// Используется для теста программы. Если лишнее удалю в следующих версиях
public class Demo {
    // метод заполняет дерево в соответствии с tree.jpg. 
    public static FamilyTree<Person> demoTree() {
        FamilyTree<Person> tree = new FamilyTree<>();
        tree.addEntity(new Person("Frederick", "Harrington", Sex.MALE, LocalDate.of(1939, 8, 25), LocalDate.of(2011, 9, 5)));
        tree.addEntity(new Person("Bruce", "Baker", Sex.MALE, LocalDate.of(1938, 10, 8), LocalDate.of(2003, 1, 8)));
        tree.addEntity(new Person("Wilson", "Rogers", Sex.MALE, LocalDate.of(1942, 5, 6), LocalDate.of(2009, 10, 23)));
        tree.addEntity(new Person("Judith", "Brady", Sex.FEMALE, LocalDate.of(1935, 8, 17), LocalDate.of(2005, 4, 23)));
        tree.addEntity(new Person("Michelle", "Powell", Sex.FEMALE, LocalDate.of(1943, 5, 31)));
        tree.addEntity(new Person("Hannah", "Nichols", Sex.FEMALE, LocalDate.of(1935, 2, 15), LocalDate.of(1987,10,25)));
        tree.addEntity(new Person("Bethany", "Harris", Sex.FEMALE, LocalDate.of(1942, 12, 26), LocalDate.of(1999, 3, 4)));
        tree.addEntity(new Person("Edith", "Lyons", Sex.FEMALE, LocalDate.of(1937, 6, 22), LocalDate.of(2001, 9, 5)));
        tree.addEntity(new Person("Dianne", "Brooks", Sex.FEMALE, LocalDate.of(1937, 4, 11), LocalDate.of(2008, 6, 22)));
        tree.addEntity(new Person("Ron", "Riley", Sex.MALE, LocalDate.of(1936, 12, 14), LocalDate.of(2001, 12, 3)));
        tree.addEntity(new Person("Trevor", "Drake", Sex.MALE, LocalDate.of(1941, 7, 7)));
        tree.addEntity(new Person("Dean", "Copeland", Sex.MALE, LocalDate.of(1939, 9, 24), LocalDate.of(1992, 4, 25)));
        tree.addEntity(new Person("Daniel", Sex.MALE, LocalDate.of(1955, 8, 13), LocalDate.of(2016, 12, 24)));
        tree.addEntity(new Person("Sabrina", Sex.FEMALE, LocalDate.of(1960, 9, 13)));
        tree.addEntity(new Person("Julia", Sex.FEMALE, LocalDate.of(1963, 10, 5)));
        tree.addEntity(new Person("Austin", Sex.MALE, LocalDate.of(1962, 12, 31), LocalDate.of(2020, 7, 31)));
        tree.addEntity(new Person("Ruby", Sex.FEMALE, LocalDate.of(1963, 9, 18)));
        tree.addEntity(new Person("Erica", Sex.FEMALE, LocalDate.of(1959, 12, 11), LocalDate.of(2015, 10, 26)));
        tree.addEntity(new Person("Marcos", Sex.MALE, LocalDate.of(1962, 8, 4)));
        tree.addEntity(new Person("Courtney", Sex.FEMALE, LocalDate.of(1976, 1, 19)));
        tree.addEntity(new Person("Cassandra", Sex.FEMALE, LocalDate.of(1983, 1, 28)));
        tree.addEntity(new Person("Paul", Sex.MALE, LocalDate.of(1975, 5, 22)));
        tree.addEntity(new Person("Marie", Sex.FEMALE, LocalDate.of(1983, 12, 9)));
        tree.addEntity(new Person("Colin", Sex.MALE, LocalDate.of(1982, 1, 9)));
        tree.addEntity(new Person("Megan", Sex.FEMALE, LocalDate.of(1975, 6, 10)));
        tree.addEntity(new Person("Miranda", "Anderson", Sex.FEMALE, LocalDate.of(2000, 7, 17)));
        tree.addEntity(new Person("Garry", Sex.MALE, LocalDate.of(2001, 5, 6)));
        tree.addEntity(new Person("Amy", Sex.FEMALE, LocalDate.of(2000, 3, 27)));
        tree.addEntity(new Person("Shaun", "Summers", Sex.MALE, LocalDate.of(2003, 4, 3)));
        tree.addEntity(new Person("Emily", Sex.FEMALE, LocalDate.of(2001, 2, 24)));
        tree.addEntity(new Person("Travis", "Goodwin", Sex.MALE, LocalDate.of(2001, 5, 6)));
        tree.addEntity(new Person("Hannah", Sex.FEMALE, LocalDate.of(2022, 4, 19)));
        tree.addEntity(new Person("Dean", Sex.MALE, LocalDate.of(2023, 2, 25)));
        tree.addEntity(new Person("Marty", Sex.MALE, LocalDate.of(2023, 1, 24)));
        tree.addEntity(new Person("Dani", Sex.FEMALE, LocalDate.of(2021, 9, 25)));
        tree.getEntityByID(13).addParents(tree.getEntityByID(1), tree.getEntityByID(7));
        tree.getEntityByID(14).addParents(tree.getEntityByID(2), tree.getEntityByID(8));
        tree.getEntityByID(15).addParents(tree.getEntityByID(2), tree.getEntityByID(8));
        tree.getEntityByID(16).addParents(tree.getEntityByID(3), tree.getEntityByID(9));
        tree.getEntityByID(17).addParents(tree.getEntityByID(4), tree.getEntityByID(10));
        tree.getEntityByID(18).addParents(tree.getEntityByID(5), tree.getEntityByID(11));
        tree.getEntityByID(19).addParents(tree.getEntityByID(6), tree.getEntityByID(12));
        tree.getEntityByID(20).addParents(tree.getEntityByID(13), tree.getEntityByID(14));
        tree.getEntityByID(21).addParents(tree.getEntityByID(13), tree.getEntityByID(14));
        tree.getEntityByID(22).addParents(tree.getEntityByID(16), tree.getEntityByID(17));
        tree.getEntityByID(23).addParents(tree.getEntityByID(16), tree.getEntityByID(17));
        tree.getEntityByID(24).addParents(tree.getEntityByID(18), tree.getEntityByID(19));
        tree.getEntityByID(25).addParents(tree.getEntityByID(18), tree.getEntityByID(19));
        tree.getEntityByID(27).addParents(tree.getEntityByID(21), tree.getEntityByID(22));
        tree.getEntityByID(28).addParents(tree.getEntityByID(21), tree.getEntityByID(22));
        tree.getEntityByID(30).addParents(tree.getEntityByID(23), tree.getEntityByID(24));
        tree.getEntityByID(32).addParents(tree.getEntityByID(26), tree.getEntityByID(27));
        tree.getEntityByID(33).addParents(tree.getEntityByID(28), tree.getEntityByID(29));
        tree.getEntityByID(34).addParents(tree.getEntityByID(28), tree.getEntityByID(29));
        tree.getEntityByID(35).addParents(tree.getEntityByID(30), tree.getEntityByID(31));

        return tree;
    }
}
