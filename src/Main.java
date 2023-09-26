import people.Gender;
import people.Person;

public class Main {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree("Романовы");

        Person mihail = new Person("Михаил Федорович",
                                    1596, 1645, Gender.Male);

        Person evdakia = new Person("Евдакия Лукьянина",
                                    1608, 1645, Gender.Female);

        familyTree.isHusbands(mihail, evdakia);

        Person alexey = new Person("Алексей Михайлович",
                                  1629, 1676, Gender.Male);

        familyTree.isChildren(alexey, mihail, evdakia);

        Person maria = new Person("Мария Ильинична",
                                1624, 1669, Gender.Female);

        Person natalya = new Person("Наталья Кирилловна",
                                  1651, 1694, Gender.Female);

        familyTree.isHusbands(alexey, maria);
        familyTree.isHusbands(alexey, natalya);

        Person petr1 = new Person("Петр I Алексеевич",
                                1672, 1725, Gender.Male);

        familyTree.isChildren(petr1, alexey, natalya);

        Person ivann5 = new Person("Иоанн V Алексеевич",
                                1666, 1696, Gender.Male);

        familyTree.isChildren(ivann5, alexey, maria);

        System.out.println(familyTree.getPersonInfo(alexey));

        familyTree.addInFamily(mihail);
        familyTree.addInFamily(evdakia);
        familyTree.addInFamily(alexey);
        familyTree.addInFamily(maria);
        familyTree.addInFamily(natalya);
        familyTree.addInFamily(petr1);
        familyTree.addInFamily(ivann5);

        System.out.println(familyTree.getFamilyInfo());
    }
}
