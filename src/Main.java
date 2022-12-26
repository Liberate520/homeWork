public class Main {

    public static void main(String[] args)  {

        FamilyTree familyTree = new FamilyTree();

        // Family tree created manually
        Human human1 = new Human("Vitaliy", "male");
        Human human2 = new Human("Natalia", "female");
        Human human3 = new Human("Lidia", "female", human1, human2);
        Human human4 = new Human("Ilya", "male");
        Human human5 = new Human("Roman", "male", human4, human3);
        Human human6 = new Human("Victor", "male", human4, human3);
        Human human7 = new Human("Ivan", "male", human4, human3);

        familyTree.addHuman(human1);
        familyTree.addHuman(human2);
        familyTree.addHuman(human3);
        familyTree.addHuman(human4);
        familyTree.addHuman(human5);
        familyTree.addHuman(human6);
        familyTree.addHuman(human7);

//        System.out.println("Family tree: ");
//        System.out.println(familyTree);

//        System.out.println("Find by name: ");
//        System.out.println(familyTree.getHumanByName("Lidia"));

        // Save and restore family tree by stream writer
//        Writable StreamHandler = new StreamHandler("FamilyTree.ser");
//        familyTree.setWriter(StreamHandler);
//        familyTree.save();
//
//        familyTree.load();
//        System.out.println("");
//        System.out.println("Family tree from stream: ");
//        System.out.println(familyTree);

        // Save and restore family tree by file writer
//        Writable FileHandler = new FileHandler("FamilyTree.txt");
//        familyTree.setWriter(FileHandler);
//        familyTree.save();
//
//        familyTree.load();
//        System.out.println("");
//        System.out.println("Family tree from file: ");
//        System.out.println(familyTree);

        System.out.println("Iterable humans from family tree: ");
        for (Human human: familyTree)
            System.out.println(human);
        System.out.println();

        System.out.println("Sort humans by name from family tree: ");
        familyTree.sortByName();
        for (Human human: familyTree)
            System.out.println(human);
        System.out.println();

        System.out.println("Sort humans by children count desc from family tree: ");
        familyTree.sortByChildrenCountDesc();
        for (Human human: familyTree)
            System.out.printf("%s%s %d\n", human, "; children count:", human.getChildren().size());
        System.out.println();

    }
}
