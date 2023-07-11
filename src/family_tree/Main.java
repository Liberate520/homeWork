package family_tree;

public class Main {
    public static void main(String[] args) {

        FamilyTree romanovs = new FamilyTree();

        romanovs.addPerson(new Person("Михаил Федорович", 1596, 7, 12, 1645, 7, 13, Gender.Male));
        romanovs.addPerson(new Person("Евдокия Стрешнева", 1608, 1, 1, 1645, 8, 18, Gender.Female));
        romanovs.setPeak("Михаил Федорович");
        romanovs.setPeak("Евдокия Стрешнева");

        romanovs.addPerson(new Person("Алексей Михайлович", 1629, 3, 9, 1676, 1, 29, Gender.Male, romanovs.getPersonByName("Евдокия Стрешнева"), romanovs.getPersonByName("Михаил Федорович")));
//        romanovs.getPersonByName("Михаил Федорович").setChildren(romanovs.getPersonByName("Алексей Михайлович"));
//        romanovs.getPersonByName("Евдокия Стрешнева").setChildren(romanovs.getPersonByName("Алексей Михайлович"));

        romanovs.addPerson(new Person("Мария Милославская", 1624, 4, 1, 1669, 3, 3, Gender.Female));
        romanovs.getPersonByName("Мария Милославская").setCommit("муж:Алексей Михайлович");

        romanovs.addPerson(new Person("Наталья Нарышкина", 1651, 8, 22, 1694, 2, 4, Gender.Female));
        romanovs.getPersonByName("Наталья Нарышкина").setCommit("муж:Алексей Михайлович");

        romanovs.getPersonByName("Алексей Михайлович").setCommit("жены:Мария Милославская и Наталья Нарышкина");

        romanovs.addPerson(new Person("Фёдор III Алексеевич", 1661, 5, 30, 1682, 4, 27, Gender.Male, romanovs.getPersonByName("Мария Милославская"), romanovs.getPersonByName("Алексей Михайлович")));
        romanovs.addPerson(new Person("Пётр I Алексеевич", 1672, 5, 30, 1725, 1, 28, Gender.Male, romanovs.getPersonByName("Наталья Нарышкина"), romanovs.getPersonByName("Алексей Михайлович")));

        System.out.println(romanovs);
        System.out.println(romanovs.getPeakFather());
        System.out.println(romanovs.getPeakMother());
    }
}


