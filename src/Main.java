public class Main {

    public static void main(String[] args) {
        Person person1 = new Person("Vasiliy", "Arapov", Gender.male, 1995, null);
        Person person2 = new Person("Yaroslav", "Salamandra", Gender.male, 1989, null);
        Person person3 = new Person("Alina", "Salamandra", Gender.female, 1965, null);
        Person person4 = new Person("Vitalia", "Arapova", Gender.female, 2007, null);
        Person person5 = new Person("Vladimir", "Arapov", Gender.male, 1955, 2019);

        FamilyTree familyTree = new FamilyTree();
        familyTree.addPerson(person1);
        familyTree.addPerson(person2);
        familyTree.addPerson(person3);
        familyTree.addPerson(person4);
        familyTree.addPerson(person5);
        person1.setFatherFirstName("Vladimir");
        person1.setFatherSecondName("Arapov");
        System.out.println(person1.getFatherFirstName());
        System.out.println(person1.getFatherSecondName());
        System.out.println(familyTree.getPersonByFirstSecondName("Vasiliy", "Arapov"));
        System.out.println(familyTree.getPersonByFirstSecondName(person1.getFatherFirstName(), person1.getFatherSecondName()));


        System.out.println(familyTree.getFamilyTree());
    }
}
