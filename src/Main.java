public class Main {
    public static void main(String[] args) {
        Person person1 = new Person(1993, true, "Ivan", "Sizov", Gender.Male);
        Person person2 = new Person(2022, true, "Nikita", "Sizov", Gender.Male);
        Person person3 = new Person(2016, true, "Semen", "Sizov", Gender.Male);
        Person person4 = new Person(1990, true, "Yana", "Sizova", Gender.Female);
        Person person5 = new Person(1973, true, "Yulia", "Sizova", Gender.Female);
        Person person6 = new Person(1969, true, "Sergey", "Nikulin", Gender.Male);

        FamilyTree familyTree = new FamilyTree();
        familyTree.setMother(person1, person5);
        familyTree.setFather(person1, person6);
        familyTree.setFather(person2, person1);
        familyTree.setMother(person2, person4);
        familyTree.setMother(person3, person4);
        familyTree.setFather(person3,person1);

        familyTree.addFamilyMember(person1);
        familyTree.addFamilyMember(person2);
        familyTree.addFamilyMember(person3);
        familyTree.addFamilyMember(person4);
        familyTree.addFamilyMember(person5);
        familyTree.addFamilyMember(person6);

        person1.printChildren();
        person5.printChildren();
    }
}
