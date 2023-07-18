public class Test {
    public static void main(String[] args) {
        FamilyTree familyTree = new FamilyTree();

        Person human = new Person("Алексей", "Шишкарев", "Юрьевич", 1987);
        Person human2 = new Person("Лариса", "Шишкарева", "Александровна", 1954);
        Person human3 = new Person("Юрий", "Шишкарев", "Константинович", 1953);
        Person human4 = new Person("Виталий", "Шишкарев", "Юрьевич", 1981);

        human.setMather(human2);
        human4.setMather(human2);
        human.setFather(human3);
        human4.setFather(human3);


        familyTree.addHumanList(human);
        familyTree.addHumanList(human2);
        familyTree.addHumanList(human3);
        familyTree.addHumanList(human4);

        System.out.println(human3);

        System.out.println(familyTree.findPerson("Виталий"));

        System.out.println(familyTree.getHumanListInfo());
        System.out.println(human2.getChildren());

    }
}