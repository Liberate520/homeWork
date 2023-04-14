public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("Василий", "Лежебокин", 32, Sex.Male);

        person1.setFather("Анатолий", "Лежебоков", 57);
        person1.setMother("Анна", "Лежебокова", 53);
        person1.addBrotherOrSister("Мария", "Лежебокова", 25, Sex.Female);
        person1.addBrotherOrSister("Роман", "Лежебоков", 29, Sex.Male);
        person1.addChildren("Петр", "Лежебоков", 7, Sex.Male);

        FamilyTree fTree = new FamilyTree();
        fTree.pushToTree(person1);

        System.out.println(person1);
        System.out.println();
        System.out.println(person1.printMother());
        System.out.println();
        System.out.println(person1.printBrothersOrSisters());

        System.out.println(fTree);
    }
}
