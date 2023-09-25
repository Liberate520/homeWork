// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Human grandMother1_1 = new Human("Huse", "Loura", "10.04.1950","20.06.2012",Gender.FEMALE);
        Human grandFather1_1 = new Human("Huse", "Henry","20.05.1947",Gender.MALE);
        Human grandMother1_2 = new Human("Tomson", "Mary", "10.04.1950","20.06.2012",Gender.FEMALE);
        Human grandFather1_2 = new Human("Tomson", "Harry","20.05.1947",Gender.MALE);
        Human mother1_1 = new Human("Brown","Hillary","17.09.1990",Gender.FEMALE);
        Human father1_1 = new Human("Brown","John","17.11.1986", Gender.MALE);
        Human child1_1 = new Human("Brown","Bob","01.03.2010",Gender.MALE);
        Human child1_2 = new Human("Brown","Gretta","04.11.2011",Gender.FEMALE);

        //Добавляем родителей
        mother1_1.addParent(grandMother1_1);
        mother1_1.addParent(grandFather1_1);
        father1_1.addParent(grandMother1_2);
        father1_1.addParent(grandFather1_2);

        child1_1.addParent(mother1_1);
        child1_1.addParent(father1_1);
        child1_2.addParent(mother1_1);
        child1_2.addParent(father1_1);

        //Добавляем детей
        grandMother1_1.addChild(mother1_1);
        grandFather1_1.addChild(mother1_1);
        grandMother1_2.addChild(father1_1);
        grandFather1_2.addChild(father1_1);

        mother1_1.addChild(child1_1);
        mother1_1.addChild(child1_2);
        father1_1.addChild(child1_1);
        father1_1.addChild(child1_2);

        FamilyTree familyTree = new FamilyTree(mother1_1);
        Human root = familyTree.getRoot();
        System.out.println(root);
        System.out.println("Дети: ");
        root.printChildrens();
        System.out.println("Родители:");
        root.printParents();

        System.out.println();

        root = familyTree.setRoot(child1_1);
        System.out.println(root);
        System.out.println("Дети: ");
        root.printChildrens();
        System.out.println("Родители:");
        root.printParents();

        System.out.println();

        root = familyTree.setRoot(grandMother1_1);
        System.out.println(root);
        System.out.println("Дети: ");
        root.printChildrens();
        System.out.println("Родители:");
        root.printParents();


    }
}