import human.Gender;
import human.Human;
import tree.FamilyTree;
import java.time.*;
public class Test {
        public static void main(String[] args) {
            FamilyTree MyTree = new FamilyTree();
            Human human1 = new Human(MyTree, "Кузнецов", "Владислав", LocalDate.of(1983, 5,1), Gender.Male);
            Human human2 = new Human(MyTree, "Березянская", "Ольга", LocalDate.of(1989, 2,20), Gender.Female);
            Human human3 = new Human(MyTree, "Кузнецов", "Юрий",LocalDate.of(1944, 7, 4), Gender.Male);
            Human human4 = new Human(MyTree, "Афонченко", "Людмила", LocalDate.of(1948, 8, 23), Gender.Female);
            Human human5 = new Human(MyTree, "Березянский", "Игорь", LocalDate.of(1960, 5, 26), Gender.Male);
            Human human6 = new Human(MyTree, "Березянская", "Наталья", LocalDate.of(1983, 5, 28), Gender.Female);
            Human human7 = new Human(MyTree, "Афонченко", "Федор", LocalDate.of(1921, 02, 23), Gender.Male);
            Human human8 = new Human(MyTree, "Ильченко", "Талия", LocalDate.of(1924, 4, 1), Gender.Female);
            Human human9 = new Human(MyTree, "Афонченко", "Ирина", LocalDate.of(1959, 9, 2), Gender.Female);
            Human human10 = new Human(MyTree, "Кузнецова", "Ирина", LocalDate.of(2014, 3, 26), Gender.Female);
            Human human11 = new Human(MyTree, "Кушнарева", "Людмила", LocalDate.of(1933, 2, 15), Gender.Female);

            human1.setSpouse(human2);
            human3.setSpouse(human4);
            human5.setSpouse(human6);
            human7.setSpouse(human8);

            human1.setChild(human10);
            human2.setChild(human10);
            human3.setChild(human1);
            human4.setChild(human1);
            human5.setChild(human2);
            human6.setChild(human2);
            human7.setChild(human9);
            human8.setChild(human9);
            human7.setChild(human4);
            human8.setChild(human4);
            human11.setChild(human6);

            human4.setDayOfDeath(LocalDate.of(2019, 9, 24));
            human5.setDayOfDeath(LocalDate.of(2011, 2, 10));
            human7.setDayOfDeath(LocalDate.of(2005, 12, 25));
            human8.setDayOfDeath(LocalDate.of(2012, 5, 7));

            /**
             * Вывод всех членов семьи
             */
            System.out.println("-".repeat(128));
            System.out.println(MyTree.AllTree());

            System.out.println("*".repeat(128));

            /**
             * Поиск по слову (имени)
             */
            String str = MyTree.SearchByNameSurname("Ирина");
            System.out.println(str);
            System.out.println("\n");

            /**
             * Поиск по слову (фамилии)
             */
            String str1 = MyTree.SearchByNameSurname("Афонченко");
            System.out.println(str1);
            System.out.println("\n");
        }


}
