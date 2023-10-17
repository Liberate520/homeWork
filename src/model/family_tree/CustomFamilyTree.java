package model.family_tree;

import model.person.Gender;
import model.person.Person;

import java.time.LocalDate;
import java.time.Month;

public class CustomFamilyTree {
    public FamilyTree<Person> getCustomFamilyTree() {
        FamilyTree<Person> familyTree = new FamilyTree<>("Романовы");

        Person mihail = new Person("Михаил Федорович",
                LocalDate.of(1596, Month.JULY, 22),
                LocalDate.of(1596, Month.JULY, 22),
                Gender.Male);

        Person evdakia = new Person("Евдакия Лукьянина",
                LocalDate.of(1608, 1, 1),
                LocalDate.of(1645, Month.AUGUST, 18),
                Gender.Female);

        familyTree.isHusbands(mihail, evdakia);

        Person alexey = new Person("Алексей Михайлович",
                LocalDate.of(1629, Month.MARCH, 19),
                LocalDate.of(1676, Month.FEBRUARY, 8),
                Gender.Male);

        familyTree.isChildren(alexey, mihail, evdakia);

        Person maria = new Person("Мария Ильинична",
                LocalDate.of(1624, Month.APRIL, 11),
                LocalDate.of(1669, Month.MARCH, 13),
                Gender.Female);

        Person natalya = new Person("Наталья Кирилловна",
                LocalDate.of(1651, Month.SEPTEMBER, 1),
                LocalDate.of(1694, Month.FEBRUARY, 4),
                Gender.Female);

        familyTree.isHusbands(alexey, maria);
        familyTree.isHusbands(alexey, natalya);

        Person petr1 = new Person("Петр I Алексеевич",
                LocalDate.of(1672, Month.JUNE, 9),
                LocalDate.of(1725, Month.FEBRUARY, 8),
                Gender.Male);

        familyTree.isChildren(petr1, alexey, natalya);

        Person ivan5 = new Person("Иоанн V Алексеевич",
                LocalDate.of(1666, Month.SEPTEMBER, 6),
                LocalDate.of(1696, Month.FEBRUARY, 8),
                Gender.Male);

        familyTree.isChildren(ivan5, alexey, maria);

        familyTree.addInFamily(mihail);
        familyTree.addInFamily(evdakia);
        familyTree.addInFamily(alexey);
        familyTree.addInFamily(maria);
        familyTree.addInFamily(natalya);
        familyTree.addInFamily(petr1);
        familyTree.addInFamily(ivan5);

        return familyTree;
    }
}
