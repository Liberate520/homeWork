package ru.home_work.cherevichenko_sergey;

import ru.home_work.cherevichenko_sergey.familyTree.FamilyTree;
import ru.home_work.cherevichenko_sergey.human.Gender;
import ru.home_work.cherevichenko_sergey.service_tree.ServiceTree;

import java.time.LocalDate;
import java.time.Month;

public class Main {
    public static void main(String[] args) throws Exception {
        ServiceTree tree = new ServiceTree();
        tree.addHuman("Михаил", "Черевиченко", Gender.MALE,
                LocalDate.of(2013, Month.OCTOBER, 4), null);
        tree.addHuman("Сергей", "Черевиченко", Gender.MALE,
                LocalDate.of(1981, Month.DECEMBER, 10), null);
        tree.addHuman("Елена", "Черевиченко", Gender.FEMALE,
                LocalDate.of(1986, Month.MARCH, 17), null);
        tree.addHuman("Анна", "Черевиченко", Gender.FEMALE,
                LocalDate.of(2023, Month.NOVEMBER, 15), null);
        tree.addHuman("Ольга", "Черевиченко", Gender.FEMALE,
                LocalDate.of(1978, Month.SEPTEMBER, 19), null);
        tree.addHuman("Гульниса", "Черевиченко", Gender.FEMALE,
                LocalDate.of(1955, Month.APRIL, 26), null);
        tree.addHuman("Николай", "Черевиченко", Gender.MALE,
                LocalDate.of(1948, Month.NOVEMBER, 20), null);
        tree.addHuman("Валерий", "Пузанев", Gender.MALE,
                LocalDate.of(1970, Month.APRIL, 12), null);
        tree.addHuman("Людмила", "Краснова", Gender.FEMALE,
                LocalDate.of(1948, Month.NOVEMBER, 18), null);
        tree.addHuman("Борис", "Пузанев", Gender.MALE,
                LocalDate.of(1948, Month.SEPTEMBER, 15),
                LocalDate.of(2003, Month.MARCH, 15));
        tree.addChildForFamily("Елена", "Черевиченко",
                "Сергей", "Черевиченко", "Михаил", "Черевиченко");
        tree.addChildForFamily("Елена", "Черевиченко",
                "Сергей", "Черевиченко", "Анна", "Черевиченко");
        tree.addChildForFamily("Гульниса", "Черевиченко",
                "Николай", "Черевиченко", "Сергей", "Черевиченко");
        tree.addChildForFamily("Гульниса", "Черевиченко",
                "Николай", "Черевиченко", "Ольга", "Черевиченко");
        tree.addChildForFamily("Людмила", "Краснова",
                "Борис", "Пузанев", "Елена", "Черевиченко");
        tree.addChildForFamily("Людмила", "Краснова",
                "Борис", "Пузанев", "Валерий", "Пузанев");

        System.out.println(tree);

    }
}




